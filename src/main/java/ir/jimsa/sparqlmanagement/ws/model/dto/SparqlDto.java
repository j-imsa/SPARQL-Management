package ir.jimsa.sparqlmanagement.ws.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SparqlDto {

    @JsonProperty("public_id")
    private String publicId;

    private String name;
    private String description;
    private String query;
    private String creator;
}
