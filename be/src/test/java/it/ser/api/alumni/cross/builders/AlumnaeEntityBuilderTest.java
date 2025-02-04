package it.ser.api.alumni.cross.builders;

import it.ser.api.alumni.rest.generated.model.Address;
import it.ser.api.alumni.rest.generated.model.Degree;
import it.ser.api.alumni.rest.generated.model.Education;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.storage.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


class AlumnaeEntityBuilderTest {

    private AlumnaeEntityBuilder alumnaeEntityBuilder;

    private AlumniRequest alumniRequest;

    private List<Address> addressesRequest;

    private Education educationRequest;

    private Degree masterRequest;

    private Degree phdRequest;

    @BeforeEach
    public void setUp() {
        alumnaeEntityBuilder = new AlumnaeEntityBuilder();
        alumniRequest = Mockito.mock(AlumniRequest.class);
        addressesRequest = new LinkedList<>();
        educationRequest = Mockito.mock(Education.class);
        masterRequest = Mockito.mock(Degree.class);
        phdRequest = Mockito.mock(Degree.class);
    }

    @Test
    void testBuildWithValidData() {
        Mockito.when(alumniRequest.getName()).thenReturn("John Doe");
        Mockito.when(alumniRequest.getAddresses()).thenReturn(addressesRequest);
        Mockito.when(alumniRequest.getEducation()).thenReturn(educationRequest);

        Mockito.when(educationRequest.getMaster()).thenReturn(Optional.of(masterRequest));
        Mockito.when(masterRequest.getUniversity()).thenReturn("University B");
        Mockito.when(masterRequest.getYear()).thenReturn(2020);

        Mockito.when(educationRequest.getPhd()).thenReturn(Optional.of(phdRequest));
        Mockito.when(phdRequest.getUniversity()).thenReturn("University A");
        Mockito.when(phdRequest.getYear()).thenReturn(2025);

        Address addressRequest = Mockito.mock(Address.class);
        addressesRequest.add(addressRequest);
        Mockito.when(addressRequest.getStreet()).thenReturn("Main St");
        Mockito.when(addressRequest.getNumber()).thenReturn("123");
        Mockito.when(addressRequest.getCountry()).thenReturn("Italy");

        Optional<AlumnaeEntity> alumnaeEntityOpt = alumnaeEntityBuilder.build(alumniRequest);

        assertTrue(alumnaeEntityOpt.isPresent());
        AlumnaeEntity alumnaeEntity = alumnaeEntityOpt.get();

        assertEquals("John Doe", alumnaeEntity.getName());
        assertEquals("Main St", alumnaeEntity.getAddresses().getFirst().getStreet());
        assertEquals("123", alumnaeEntity.getAddresses().getFirst().getNumber());
        assertEquals("Italy", alumnaeEntity.getAddresses().getFirst().getCountry());
        assertEquals("University B", alumnaeEntity.getEducation().getMaster().getUniversity());
        assertEquals(2020, alumnaeEntity.getEducation().getMaster().getYear());
        assertEquals("University A", alumnaeEntity.getEducation().getPhd().getUniversity());
        assertEquals(2025, alumnaeEntity.getEducation().getPhd().getYear());
    }

    @Test
    void testBuildWithMissingPhd() {
        Mockito.when(alumniRequest.getName()).thenReturn("John Doe");
        Mockito.when(alumniRequest.getAddresses()).thenReturn(addressesRequest);
        Mockito.when(alumniRequest.getEducation()).thenReturn(educationRequest);

        Mockito.when(educationRequest.getMaster()).thenReturn(Optional.of(masterRequest));
        Mockito.when(masterRequest.getUniversity()).thenReturn("University B");
        Mockito.when(masterRequest.getYear()).thenReturn(2020);

        Mockito.when(educationRequest.getPhd()).thenReturn(Optional.empty());

        Optional<AlumnaeEntity> alumnaeEntityOpt = alumnaeEntityBuilder.build(alumniRequest);

        assertTrue(alumnaeEntityOpt.isPresent());
        AlumnaeEntity alumnaeEntity = alumnaeEntityOpt.get();
        assertNull(alumnaeEntity.getEducation().getPhd());
    }

    @Test
    void testBuildWithNullRequest() {
        Optional<AlumnaeEntity> alumnaeEntityOpt = alumnaeEntityBuilder.build(null);
        assertFalse(alumnaeEntityOpt.isPresent());
    }

    @Test
    void testBuildWithMissingMaster() {
        Mockito.when(alumniRequest.getEducation()).thenReturn(educationRequest);
        Mockito.when(educationRequest.getMaster()).thenReturn(Optional.empty());

        Optional<AlumnaeEntity> alumnaeEntityOpt = alumnaeEntityBuilder.build(alumniRequest);

        assertTrue(alumnaeEntityOpt.isPresent());
        assertNull(alumnaeEntityOpt.get().getEducation().getMaster());
    }

}
