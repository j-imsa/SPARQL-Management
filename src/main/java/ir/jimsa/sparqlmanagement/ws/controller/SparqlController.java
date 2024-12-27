package ir.jimsa.sparqlmanagement.ws.controller;

import ir.jimsa.sparqlmanagement.ws.model.dto.ResponseDto;
import ir.jimsa.sparqlmanagement.ws.model.dto.SparqlDto;
import ir.jimsa.sparqlmanagement.ws.service.SparqlService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sparql", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class SparqlController {

    private final SparqlService sparqlService;

    @GetMapping
    public ResponseEntity<ResponseDto> readAllSparql() {
        return null;
    }

    @GetMapping("/{public-id}")
    public ResponseEntity<ResponseDto> readSparql(@PathVariable String publicId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createSparql(@RequestBody SparqlDto sparqlDto) {
        return null;
    }

    @PutMapping("/{public_id}")
    public ResponseEntity<ResponseDto> updateSparql(@PathVariable String publicId, @RequestBody SparqlDto sparqlDto) {
        return null;
    }

    @DeleteMapping("/{public-id}")
    public ResponseEntity<ResponseDto> deleteSparql(@PathVariable String publicId) {
        return null;
    }
}
