package ir.jimsa.sparqlmanagement.unit.service;

import ir.jimsa.sparqlmanagement.ws.repository.SparqlRepository;
import ir.jimsa.sparqlmanagement.ws.service.impl.SparqlServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SparqlServiceTests {

    @InjectMocks
    private SparqlServiceImpl sparqlService;

    @Mock
    private SparqlRepository sparqlRepository;

    @Nested
    @DisplayName("CreateSparql")
    class CreateSparqlTests {


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
