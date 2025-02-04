package it.ser.api.alumni.rest;

import it.ser.api.alumni.handler.Handler;
import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.rest.generated.model.AlumniResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class ControllerTest {


    @Test
    void createAlumniValidPayloadMarioRossi() {
        Handler handler = Mockito.mock(Handler.class);

        AlumniResponse alumniResponse = new AlumniResponse();
        Mockito.when(handler.handle(any())).thenReturn(Optional.of(alumniResponse.name("Mario Rossi")));

        Controller controller = new Controller(handler);

        ResponseEntity<AlumniResponse> alumni = controller.createAlumni(new AlumniRequest());

        assertNotNull(alumni);

        Mockito.verify(handler, Mockito.times(1)).handle(any());
    }
}