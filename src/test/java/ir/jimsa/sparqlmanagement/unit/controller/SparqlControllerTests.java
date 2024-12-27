package ir.jimsa.sparqlmanagement.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.jimsa.sparqlmanagement.ws.controller.SparqlController;
import ir.jimsa.sparqlmanagement.ws.model.dto.SparqlDto;
import ir.jimsa.sparqlmanagement.ws.service.SparqlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SparqlController.class)
public class SparqlControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SparqlService sparqlService;

    @Autowired
    private ObjectMapper objectMapper;

    private String basicAuthHeader;

    @BeforeEach
    void setUp() {
        String credentials = "alirezaemad:ihavenosecrets";
        String base64Credentials = new String(Base64.getEncoder().encode(credentials.getBytes()));
        basicAuthHeader = "Basic " + base64Credentials;
    }

    @Nested
    @DisplayName("CreateSparql")
    class CreateSparqlTests {

        @Test
        @DisplayName("should return status 403")
        void shouldReturnStatus403Auth() throws Exception {
            // Arrange
            SparqlDto sparqlDto = SparqlDto.builder()
                    .name("name")
                    .description("description")
                    .creator("creator")
                    .build();

            when(sparqlService.create(any(SparqlDto.class))).thenReturn(sparqlDto);

            // Act & Assert
            mockMvc.perform(post("/sparql")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(sparqlDto)))
                    .andExpect(status().is4xxClientError());
        }

    }

    @Nested
    @DisplayName("ReadSparql")
    class ReadSparqlTests {}

    @Nested
    @DisplayName("UpdateSparql")
    class UpdateSparqlTests {}

    @Nested
    @DisplayName("DeleteSparql")
    class DeleteSparqlTests {}
}
