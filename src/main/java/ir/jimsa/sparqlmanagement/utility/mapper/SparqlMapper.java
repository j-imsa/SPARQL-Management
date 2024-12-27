package ir.jimsa.sparqlmanagement.utility.mapper;

import ir.jimsa.sparqlmanagement.utility.id.PublicIdGenerator;
import ir.jimsa.sparqlmanagement.ws.model.dto.SparqlDto;
import ir.jimsa.sparqlmanagement.ws.model.entity.SparqlEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static ir.jimsa.sparqlmanagement.utility.constant.ProjectConstants.PUBLIC_ID_DEFAULT_LENGTH;

@Component
@AllArgsConstructor
public class SparqlMapper {

    private final PublicIdGenerator idGenerator;

    public SparqlEntity mapToEntity(SparqlDto dto) {
        return SparqlEntity.builder()
                .publicId(idGenerator.generatePublicId(PUBLIC_ID_DEFAULT_LENGTH))
                .name(dto.getName())
                .description(dto.getDescription())
                .query(dto.getQuery())
                .creator(dto.getCreator())
                .build();
    }

    public SparqlDto mapToDto(SparqlEntity entity) {
        return SparqlDto.builder()
                .publicId(entity.getPublicId())
                .name(entity.getName())
                .description(entity.getDescription())
                .query(entity.getQuery())
                .creator(entity.getCreator())
                .build();
    }
}
