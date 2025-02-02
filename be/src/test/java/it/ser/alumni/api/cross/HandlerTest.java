package it.ser.alumni.api.cross;

import it.ser.alumni.api.generated.model.AlumniRequest;
import it.ser.alumni.api.generated.model.AlumniResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {

    private Handler handler;

    @BeforeEach
    void setUp() {
        handler = new Handler();
    }

    @Test
    void handleMarioRossiWithTheRightName() {
        AlumniResponse alumniResponseExpected = new AlumniResponse();
        alumniResponseExpected.name("Mario Rossi");


        AlumniRequest alumniRequest = new AlumniRequest();

        Optional<AlumniResponse> alumniResponse = handler.handle(alumniRequest);

        assertTrue(alumniResponse.isPresent());
        assertEquals(alumniResponseExpected.getName(), alumniResponse.get().getName());
    }

    @Test
    void handleNullInput() {
        AlumniResponse alumniResponseExpected = new AlumniResponse();
        alumniResponseExpected.name("Mario Rossi");

        Optional<AlumniResponse> alumniResponse = handler.handle(null);

        assertFalse(alumniResponse.isPresent());
    }

}