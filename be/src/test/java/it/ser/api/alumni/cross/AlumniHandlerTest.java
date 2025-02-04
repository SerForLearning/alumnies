package it.ser.api.alumni.cross;

import it.ser.api.alumni.handler.AlumniHandler;
import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.rest.generated.model.AlumniResponse;
import it.ser.api.alumni.storage.entities.AlumnaeEntity;
import it.ser.api.alumni.storage.repo.AlumnaeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class AlumniHandlerTest {

    private AlumniHandler alumniHandler;
    private AlumnaeRepository alumnaeRepository;

    @BeforeEach
    void setUp() {
        alumnaeRepository = Mockito.mock(AlumnaeRepository.class);
        AlumnaeEntity t = new AlumnaeEntity();
        t.setName("Mario Rossi");
        Mockito.when(alumnaeRepository.save(any())).thenReturn(t);
        alumniHandler = new AlumniHandler(alumnaeRepository);
    }

    @Test
    void handleMarioRossiWithTheRightName() {
        AlumniResponse alumniResponseExpected = new AlumniResponse();
        alumniResponseExpected.name("Mario Rossi");


        AlumniRequest alumniRequest = new AlumniRequest();

        Optional<AlumniResponse> alumniResponse = alumniHandler.handle(alumniRequest);

        assertTrue(alumniResponse.isPresent());
        assertEquals(alumniResponseExpected.getName(), alumniResponse.get().getName());
    }

    @Test
    void handleNullInput() {
        AlumniResponse alumniResponseExpected = new AlumniResponse();
        alumniResponseExpected.name("Mario Rossi");

        Optional<AlumniResponse> alumniResponse = alumniHandler.handle(null);

        assertFalse(alumniResponse.isPresent());
    }

}