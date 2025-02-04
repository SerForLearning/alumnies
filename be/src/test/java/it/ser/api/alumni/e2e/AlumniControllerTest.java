package it.ser.api.alumni.e2e;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import it.ser.api.alumni.cross.config.AlumniApplication;
import it.ser.api.alumni.storage.entities.AddressEntity;
import it.ser.api.alumni.storage.entities.AlumnaeEntity;
import it.ser.api.alumni.storage.repo.AlumnaeRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    Integer savedAlumnaeId;

    @BeforeEach
    void setUp() {
        alumnaeRepository.deleteAll();
        RestAssured.baseURI = "http://localhost:" + port;
        String requestBody = getRequestBody();
        savedAlumnaeId = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/alumni")
                .then()
                .statusCode(200)
                .extract().path("id");
    }

    private static @NotNull String getRequestBody() {
        return """
                {
                   "name": "nome",
                   "addresses": [
                     {
                       "street": "streetname",
                       "number": "22",
                       "country": "country"
                     },
                     {
                       "street": "streetname2",
                       "number": "33",
                       "country": "country"
                     }
                   ],
                   "education": {
                     "master": {
                       "university": "Politecnico Milano",
                       "year": 2004
                     },
                     "phd": {
                       "university": "UCSD",
                       "year": 2009
                     }
                   }
                 }
                """;
    }


    @Test
    void testAlumniEndpointSaveName() {
        String expectedName = "nome";

        AlumnaeEntity alumnaeEntity = getAlumnae();

        assertEquals(expectedName, alumnaeEntity.getName());
    }

    private @NotNull AlumnaeEntity getAlumnae() {
        return alumnaeRepository.findById(Long.valueOf(savedAlumnaeId)).orElseThrow();
    }

    @ParameterizedTest
    @CsvSource({
            "0, 'streetname'",
            "1, 'streetname2'"
    })
    void testAlumniEndpointSaveAddressStreet(int index, String expected) {
        AlumnaeEntity alumnaeEntity = getAlumnae();

        String actual = getAddressEntity(alumnaeEntity, index).getStreet();
        assertEquals(expected, actual);
    }

    private static AddressEntity getAddressEntity(AlumnaeEntity alumnaeEntity, int index) {
        return alumnaeEntity.getAddresses().get(index);
    }

    @ParameterizedTest
    @CsvSource({
            "0, '22'",
            "1, '33'"
    })
    void testAlumniEndpointSaveAddressNumber(int index, String expected) {
        AlumnaeEntity alumnaeEntity = getAlumnae();

        String actual = getAddressEntity(alumnaeEntity, index).getNumber();
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({
            "0, 'country'",
            "1, 'country'"
    })
    void testAlumniEndpointSaveAddressCountry(int index, String expected) {
        AlumnaeEntity alumnaeEntity = getAlumnae();

        String actual = getAddressEntity(alumnaeEntity, index).getCountry();
        assertEquals(expected, actual);
    }

    @Test
    void testAlumniEndpointSaveMasterUniversity() {
        String expected = "Politecnico Milano";

        AlumnaeEntity alumnaeEntity = getAlumnae();

        String actual = alumnaeEntity.getEducation().getMaster().getUniversity();
        assertEquals(expected, actual);
    }

    @Test
    void testAlumniEndpointSaveMasterYear() {
        Integer expected = 2004;

        AlumnaeEntity alumnaeEntity = getAlumnae();

        Integer actual = alumnaeEntity.getEducation().getMaster().getYear();
        assertEquals(expected, actual);
    }
    @Test
    void testAlumniEndpointSavePhdUniversity() {
        String expected = "UCSD";

        AlumnaeEntity alumnaeEntity = getAlumnae();

        String actual = alumnaeEntity.getEducation().getPhd().getUniversity();
        assertEquals(expected, actual);
    }

    @Test
    void testAlumniEndpointSavePhdYear() {
        Integer expected = 2009;

        AlumnaeEntity alumnaeEntity = getAlumnae();

        Integer actual = alumnaeEntity.getEducation().getPhd().getYear();
        assertEquals(expected, actual);
    }

}

