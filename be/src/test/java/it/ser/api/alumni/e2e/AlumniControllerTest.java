package it.ser.api.alumni.e2e;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import it.ser.api.alumni.cross.AlumniApplication;
import it.ser.api.alumni.storage.entities.Alumnae;
import it.ser.api.alumni.storage.repo.AlumnaeRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AlumniApplication.class)
@Testcontainers
public class AlumniControllerTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    AlumnaeRepository alumnaeRepository;

    @Container
    public static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("test_db")
            .withUsername("test_user")
            .withPassword("test_password");

    @BeforeAll
    static void beforeAll() {
        postgresContainer.start();
        await().atMost(10, SECONDS).until(() -> postgresContainer.isRunning());
    }

    @AfterAll
    static void afterAll() {
        postgresContainer.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
    }


    @Test
    void testAlumniEndpoint() {
        String expectedName = "John Doe";
        String requestBody = "{"
                + "\"name\": \"" + expectedName + "\""
                + "}";
        Integer id = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/alumni")
                .then()
                .statusCode(200)
                .extract().path("id");

        Alumnae alumnae = alumnaeRepository.findById(Long.valueOf(id)).orElseThrow();

        assertEquals(expectedName, alumnae.getName());
    }
}

