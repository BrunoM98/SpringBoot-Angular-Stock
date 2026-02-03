package bm.inventary.controller;

import bm.inventary.entity.Product;
import bm.inventary.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class) // Solo carga la capa web
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService; // Simulamos el servicio

    @Autowired
    private ObjectMapper objectMapper; // Para convertir objetos a JSON

    @Test
    void testObtainProduct() throws Exception {
        // Configuramos el comportamiento del Mock
        Product p1 = new Product(1, "Teclado", 5000.0, 10);
        when(productService.productList()).thenReturn(Arrays.asList(p1));

        // Simulamos el GET
        mockMvc.perform(get("/stock-app/product"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].description").value("Teclado"));
    }

    @Test
    void testAddProduct() throws Exception {
        Product p1 = new Product(1, "Mouse", 1500.0, 5);
        when(productService.saveProduct(any(Product.class))).thenReturn(p1);

        // Simulamos el POST enviando un JSON
        mockMvc.perform(post("/stock-app/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(p1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Mouse"));
    }
}