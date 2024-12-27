package ir.jimsa.sparqlmanagement.ws.repository;

import ir.jimsa.sparqlmanagement.ws.model.entity.SparqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparqlRepository extends JpaRepository<SparqlEntity, String> {
}
