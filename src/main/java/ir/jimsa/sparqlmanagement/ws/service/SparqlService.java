package ir.jimsa.sparqlmanagement.ws.service;

import ir.jimsa.sparqlmanagement.ws.model.dto.SparqlDto;

import java.util.List;

public interface SparqlService {
    SparqlDto create(SparqlDto sparqlDto);

    List<SparqlDto> read(int page, int size);

    SparqlDto read(String publicId);

    SparqlDto update(String publicId, SparqlDto sparqlDto);

    boolean delete(String publicId);
}
