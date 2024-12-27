package ir.jimsa.sparqlmanagement.ws.controller;

import ir.jimsa.sparqlmanagement.ws.model.dto.ResponseDto;
import ir.jimsa.sparqlmanagement.ws.model.dto.SparqlDto;
import ir.jimsa.sparqlmanagement.ws.service.SparqlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/sparql", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class SparqlController {

    private final SparqlService sparqlService;

    @PostMapping
    public ResponseEntity<ResponseDto> createSparql(@RequestBody SparqlDto sparqlDto) {
        SparqlDto savedSparql = sparqlService.create(sparqlDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ResponseDto.builder()
                                .action(true)
                                .timestamp(LocalDateTime.now())
                                .result(savedSparql)
                                .build()
                );
    }

    @GetMapping
    public ResponseEntity<ResponseDto> readAllSparql(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        List<SparqlDto> sparqlDtos = sparqlService.read(page, size);
        return ResponseEntity
                .ok(
                        ResponseDto.builder()
                                .action(true)
                                .timestamp(LocalDateTime.now())
                                .result(sparqlDtos)
                                .build()
                );
    }

    @GetMapping("/{public_id}")
    public ResponseEntity<ResponseDto> readSparql(@PathVariable("public_id") String publicId) {
        SparqlDto sparqlDto = sparqlService.read(publicId);
        return ResponseEntity
                .ok(
                        ResponseDto.builder()
                                .action(true)
                                .timestamp(LocalDateTime.now())
                                .result(sparqlDto)
                                .build()
                );
    }

    @PutMapping("/{public_id}")
    public ResponseEntity<ResponseDto> updateSparql(@PathVariable("public_id") String publicId, @RequestBody SparqlDto sparqlDto) {
        SparqlDto updatedSparqlDto = sparqlService.update(publicId, sparqlDto);
        return ResponseEntity
                .ok(
                        ResponseDto.builder()
                                .action(true)
                                .timestamp(LocalDateTime.now())
                                .result(updatedSparqlDto)
                                .build()
                );
    }

    @DeleteMapping("/{public_id}")
    public ResponseEntity<ResponseDto> deleteSparql(@PathVariable("public_id") String publicId) {
        boolean result = sparqlService.delete(publicId);
        return ResponseEntity
                .ok(
                        ResponseDto.builder()
                                .action(true)
                                .timestamp(LocalDateTime.now())
                                .result(result)
                                .build()
                );
    }
}
