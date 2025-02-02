package it.ser.alumni.cross;

import it.ser.alumni.api.rest.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlumniApplicationTest {

    @Autowired
    private Controller controller;

    @Test
    void mainCheck() {
        assertNotNull(controller);
    }
}