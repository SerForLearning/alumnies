package it.ser.api.alumni.cross;

import it.ser.api.alumni.handler.Handler;
import it.ser.api.alumni.generated.model.AlumniRequest;
import it.ser.api.alumni.generated.model.AlumniResponse;
import it.ser.api.alumni.storage.entities.Alumnae;
import it.ser.api.alumni.storage.repo.AlumnaeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class HandlerTest {

    private Handler handler;
    private AlumnaeRepository alumnaeRepository;

    @BeforeEach
    void setUp() {
        alumnaeRepository = Mockito.mock(AlumnaeRepository.class);
        Alumnae t = new Alumnae();
        t.setName("Mario Rossi");
        Mockito.when(alumnaeRepository.save(any())).thenReturn(t);
        handler = new Handler(alumnaeRepository);
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