package ma.zs.stocky.unit.ws.facade.admin.commun;

import ma.zs.stocky.bean.core.commun.Produit;
import ma.zs.stocky.service.impl.admin.commun.ProduitAdminServiceImpl;
import ma.zs.stocky.ws.converter.commun.ProduitConverter;
import ma.zs.stocky.ws.dto.commun.ProduitDto;
import ma.zs.stocky.ws.facade.admin.commun.ProduitRestAdmin;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProduitRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private ProduitAdminServiceImpl service;
    @Mock
    private ProduitConverter converter;

    @InjectMocks
    private ProduitRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllProduitTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ProduitDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ProduitDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveProduitTest() throws Exception {
        // Mock data
        ProduitDto requestDto = new ProduitDto();
        Produit entity = new Produit();
        Produit saved = new Produit();
        ProduitDto savedDto = new ProduitDto();

        // Mock the converter to return the produit object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved produit DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ProduitDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ProduitDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved produit DTO
        assertEquals(savedDto.getReference(), responseBody.getReference());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getBarcode(), responseBody.getBarcode());
        assertEquals(savedDto.getDiscription(), responseBody.getDiscription());
        assertEquals(savedDto.getPrixAchatMoyen(), responseBody.getPrixAchatMoyen());
        assertEquals(savedDto.getQuantite(), responseBody.getQuantite());
        assertEquals(savedDto.getSeuilAlert(), responseBody.getSeuilAlert());
    }

}
