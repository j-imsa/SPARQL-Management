package ir.jimsa.sparqlmanagement.unit.service;

import ir.jimsa.sparqlmanagement.config.exception.AppServiceException;
import ir.jimsa.sparqlmanagement.utility.mapper.SparqlMapper;
import ir.jimsa.sparqlmanagement.ws.model.dto.SparqlDto;
import ir.jimsa.sparqlmanagement.ws.repository.SparqlRepository;
import ir.jimsa.sparqlmanagement.ws.service.impl.SparqlServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static ir.jimsa.sparqlmanagement.utility.constant.ProjectConstants.EXCEPTION_PUBLIC_ID_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SparqlServiceTests {

    @InjectMocks
    private SparqlServiceImpl sparqlService;

    @Mock
    private SparqlRepository sparqlRepository;

    @Mock
    private SparqlMapper sparqlMapper;

    @Nested
    @DisplayName("CreateSparql")
    class CreateSparqlTests {

        @Test
        @DisplayName("with invalid public_id, should throw AppServiceException")
        void testCreateSparqlWithInvalidPublicId() {
            SparqlDto sparqlDto = new SparqlDto();
            sparqlDto.setPublicId("null"); // Setting publicId is an invalid action!

            assertThatThrownBy(() -> sparqlService.create(sparqlDto))
                    .isInstanceOf(AppServiceException.class)
                    .hasMessageContaining(EXCEPTION_PUBLIC_ID_MESSAGE);
            verify(sparqlRepository, times(0)).findAll();
            verify(sparqlMapper, times(0)).mapToEntity(any(SparqlDto.class));
        }

    }

    @Nested
    @DisplayName("ReadSparql")
    class ReadSparqlTests {
    }

    @Nested
    @DisplayName("UpdateSparql")
    class UpdateSparqlTests {
    }

    @Nested
    @DisplayName("DeleteSparql")
    class DeleteSparqlTests {
    }
}
