package ir.jimsa.sparqlmanagement.unit.repository;

import ir.jimsa.sparqlmanagement.ws.model.entity.SparqlEntity;
import ir.jimsa.sparqlmanagement.ws.repository.SparqlRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SparqlRepositoryTests {

    @Autowired
    private SparqlRepository sparqlRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Nested
    @DisplayName("Save")
    class SaveTests {

    }

    @Nested
    @DisplayName("FindByPublicId")
    class FindByPublicIdTests {

        @Test
        @DisplayName("with valid info, should return valid entity")
        void testFindByPublicIdWithValidInfo() {
            SparqlEntity entity = sparqlRepository.save(
                    SparqlEntity.builder()
                            .publicId("publicId")
                            .creator("creator")
                            .query("query")
                            .name("name")
                            .description("description")
                            .build()
            );

            Optional<SparqlEntity> optionalSparql = sparqlRepository.findByPublicId(entity.getPublicId());

            assertThat(optionalSparql)
                    .isPresent()
                    .contains(entity)
                    .hasValueSatisfying(sql -> {
                        assertThat(sql).isNotNull();
                        assertThat(sql.getPublicId()).isEqualTo(entity.getPublicId());
                        assertThat(sql.getId()).isGreaterThan(0L);
                        assertThat(sql)
                                .hasFieldOrPropertyWithValue("name", sql.getName())
                                .hasFieldOrPropertyWithValue("creator", sql.getCreator())
                                .hasFieldOrPropertyWithValue("query", sql.getQuery())
                                .hasFieldOrPropertyWithValue("description", sql.getDescription());
                    });
        }

    }

    @Nested
    @DisplayName("Delete")
    class DeleteTests {

    }

    @Nested
    @DisplayName("FindAll")
    class FindAllTests {

    }
}
