package ir.jimsa.sparqlmanagement.unit.utility;

import ir.jimsa.sparqlmanagement.utility.id.PublicIdGenerator;
import ir.jimsa.sparqlmanagement.utility.mapper.SparqlMapper;
import ir.jimsa.sparqlmanagement.ws.model.dto.SparqlDto;
import ir.jimsa.sparqlmanagement.ws.model.entity.SparqlEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SparqlMapperTests {

    private SparqlMapper mapper;

    @BeforeEach
    public void setup() {
        PublicIdGenerator publicIdGenerator = new PublicIdGenerator();
        mapper = new SparqlMapper(publicIdGenerator);
    }

    @Nested
    @DisplayName("MapToEntity")
    class MapToEntityTests {

        @Test
        @DisplayName("Should map SparqlDto to SparqlEntity correctly")
        void testMapToEntity() {
            // Arrange
            SparqlDto dto = SparqlDto.builder()
                    .name("Sample Name")
                    .description("Sample Description")
                    .query("SELECT * WHERE { ?s ?p ?o }")
                    .creator("creator")
                    .build();

            // Act
            SparqlEntity entity = mapper.mapToEntity(dto);

            // Assert
            assertNotNull(entity);
            assertNotNull(entity.getPublicId());
            assertEquals(dto.getName(), entity.getName());
            assertEquals(dto.getDescription(), entity.getDescription());
            assertEquals(dto.getQuery(), entity.getQuery());
            assertEquals(dto.getCreator(), entity.getCreator());
        }

    }

    @Nested
    @DisplayName("MapToDto")
    class MapToDtoTests {

        @Test
        @DisplayName("Should map SparqlEntity to SparqlDto correctly")
        void testMapToDto() {
            // Arrange
            SparqlEntity entity = SparqlEntity.builder()
                    .publicId("publicId123")
                    .name("Sample Name")
                    .description("Sample Description")
                    .query("SELECT * WHERE { ?s ?p ?o }")
                    .creator("creator")
                    .build();

            // Act
            SparqlDto dto = mapper.mapToDto(entity);

            // Assert
            assertNotNull(dto);
            assertEquals(entity.getPublicId(), dto.getPublicId());
            assertEquals(entity.getName(), dto.getName());
            assertEquals(entity.getDescription(), dto.getDescription());
            assertEquals(entity.getQuery(), dto.getQuery());
            assertEquals(entity.getCreator(), dto.getCreator());
        }


    }

}
