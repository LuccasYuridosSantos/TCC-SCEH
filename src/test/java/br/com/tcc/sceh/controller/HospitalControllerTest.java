package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.exceptions.ApiException;
import br.com.tcc.sceh.helper.HospitalBuilder;
import br.com.tcc.sceh.model.Hospital;
import br.com.tcc.sceh.repository.HospitalRepository;
import br.com.tcc.sceh.service.HospitalService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class HospitalControllerTest {

    @InjectMocks
    private HospitalController controller;

    @Mock
    private HospitalService hospitalService;

    @Mock
    private HospitalRepository hospitalRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        hospitalService = new HospitalService();
        controller = new HospitalController(hospitalService, hospitalRepository);
    }

    @Test
    public void testeCriandoHospitalComSucesso() {

        final Hospital hospitalMock = HospitalBuilder.builder().hospitalCompleto().build();

        Mockito.when(hospitalRepository.save(hospitalMock)).thenReturn(hospitalMock);

        final  ResponseEntity<Hospital> hospitalResponse = controller.cadastrarHospital(hospitalMock);

        Assert.assertEquals(hospitalMock, hospitalResponse.getBody());
        Assert.assertEquals(HttpStatus.CREATED, hospitalResponse.getStatusCode());
    }

    @Test(expected = ApiException.class)
    public void testeCriandoHospitalComCnpjInvalido(){
        final Hospital hospitalMock = HospitalBuilder.builder().hospitalCompleto().setCnpj("invalido").build();

        final  ResponseEntity<Hospital> hospitalResponse = controller.cadastrarHospital(hospitalMock);
    }

    @Test(expected = ApiException.class)
    public void testeCriandoHospitalComCamposNulos(){
        final Hospital hospitalMock = HospitalBuilder.builder().camposNulos().build();
        final  ResponseEntity<Hospital> hospitalResponse = controller.cadastrarHospital(hospitalMock);
    }

    @Test(expected = ApiException.class)
    public void testeCriandoHospitalComCamposVazios(){
        final Hospital hospitalMock = HospitalBuilder.builder().camposVazios().build();
        final  ResponseEntity<Hospital> hospitalResponse = controller.cadastrarHospital(hospitalMock);
    }





}