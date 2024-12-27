package ir.jimsa.sparqlmanagement.ws.service.impl;

import ir.jimsa.sparqlmanagement.config.exception.AppServiceException;
import ir.jimsa.sparqlmanagement.utility.mapper.SparqlMapper;
import ir.jimsa.sparqlmanagement.ws.model.dto.SparqlDto;
import ir.jimsa.sparqlmanagement.ws.model.entity.SparqlEntity;
import ir.jimsa.sparqlmanagement.ws.repository.SparqlRepository;
import ir.jimsa.sparqlmanagement.ws.service.SparqlService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static ir.jimsa.sparqlmanagement.utility.constant.ProjectConstants.EXCEPTION_NOT_FOUND_RESOURCE_MESSAGE;
import static ir.jimsa.sparqlmanagement.utility.constant.ProjectConstants.EXCEPTION_PUBLIC_ID_MESSAGE;

@Service
@AllArgsConstructor
public class SparqlServiceImpl implements SparqlService {

    private final SparqlRepository repository;
    private final SparqlMapper mapper;

    @Override
    public SparqlDto create(SparqlDto sparqlDto) {
        if (sparqlDto.getPublicId() != null) {
            throw new AppServiceException(EXCEPTION_PUBLIC_ID_MESSAGE, HttpStatus.BAD_REQUEST);
        }
        SparqlEntity entity = mapper.mapToEntity(sparqlDto);
        entity = repository.save(entity);
        return mapper.mapToDto(entity);
    }

    @Override
    public List<SparqlDto> read(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.ASC);
        Page<SparqlEntity> sparqlEntityPage = repository.findAll(pageable);
        return sparqlEntityPage
                .get()
                .map(mapper::mapToDto)
                .toList();
    }

    @Override
    public SparqlDto read(String publicId) {
        if (publicId == null || publicId.isEmpty()) {
            throw new AppServiceException(EXCEPTION_PUBLIC_ID_MESSAGE, HttpStatus.BAD_REQUEST);
        }
        return repository.findByPublicId(publicId)
                .map(mapper::mapToDto)
                .orElseThrow(() -> new AppServiceException(EXCEPTION_NOT_FOUND_RESOURCE_MESSAGE, HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public SparqlDto update(String publicId, SparqlDto sparqlDto) {
        if (publicId == null || publicId.isEmpty()) {
            throw new AppServiceException(EXCEPTION_PUBLIC_ID_MESSAGE, HttpStatus.BAD_REQUEST);
        }

        Optional<SparqlEntity> sparqlEntityOptional = repository.findByPublicId(publicId);
        if (sparqlEntityOptional.isEmpty()) {
            throw new AppServiceException(EXCEPTION_NOT_FOUND_RESOURCE_MESSAGE, HttpStatus.NOT_FOUND);
        } else {
            SparqlEntity sparqlEntity = sparqlEntityOptional.get();
            sparqlEntity.setName(sparqlDto.getName());
            sparqlEntity.setDescription(sparqlDto.getDescription());
            sparqlEntity.setQuery(sparqlDto.getQuery());
            sparqlEntity.setCreator(sparqlDto.getCreator());
            return mapper.mapToDto(repository.save(sparqlEntity));
        }
    }

    @Override
    public boolean delete(String publicId) {
        if (publicId == null || publicId.isEmpty()) {
            throw new AppServiceException(EXCEPTION_PUBLIC_ID_MESSAGE, HttpStatus.BAD_REQUEST);
        }
        Optional<SparqlEntity> sparqlEntityOptional = repository.findByPublicId(publicId);
        if (sparqlEntityOptional.isEmpty()) {
            throw new AppServiceException(EXCEPTION_NOT_FOUND_RESOURCE_MESSAGE, HttpStatus.NOT_FOUND);
        } else {
            SparqlEntity sparqlEntity = sparqlEntityOptional.get();
            repository.delete(sparqlEntity);
            return true;
        }
    }
}
