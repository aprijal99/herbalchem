package org.herbal.chem.compound.detail.service;

import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.api.dto.chemical.physical.property.ChemicalPhysicalPropertyServiceDto;
import org.herbal.chem.api.dto.name.identifier.NameIdentifierServiceDto;
import org.herbal.chem.api.dto.organism.OrganismServiceDto;
import org.herbal.chem.api.dto.structure.StructureServiceDto;
import org.herbal.chem.util.HttpClientErrorExceptionHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CompoundDetailServiceImpl implements CompoundDetailService{
    private final RestTemplate restTemplate;
    private final HttpClientErrorExceptionHandler httpClientErrorExceptionHandler;

    private final String COMPOUND_SERVICE_URL = "http://compound-service/compounds/";
    private final String STRUCTURE_SERVICE_URL = "http://structure-service/structures/";
    private final String NAME_IDENTIFIER_SERVICE_URL = "http://name-identifier-service/names-identifiers/";
    private final String CHEMICAL_PHYSICAL_PROPERTY_URL = "http://chem-phys-prop-service/chemical-physical-properties/";
    private final String ORGANISM_SERVICE_URL = "http://organism-service/organisms/";

    public CompoundDetailServiceImpl(RestTemplate restTemplate, HttpClientErrorExceptionHandler httpClientErrorExceptionHandler) {
        this.restTemplate = restTemplate;
        this.httpClientErrorExceptionHandler = httpClientErrorExceptionHandler;
    }

    @Override
    public CompoundServiceDto getCompoundFromCompoundService(Integer cid) {
        try {
            String url = COMPOUND_SERVICE_URL + cid;

            return restTemplate.getForObject(url, CompoundServiceDto.class);
        } catch (HttpClientErrorException e) {
            throw httpClientErrorExceptionHandler.throwNewException(e);
        }
    }

    @Override
    public StructureServiceDto getStructureFromStructureService(Integer cid) {
        String url = STRUCTURE_SERVICE_URL + cid;

        return restTemplate.getForObject(url, StructureServiceDto.class);
    }

    @Override
    public NameIdentifierServiceDto getNameIdentifierFromNameIdentifierService(Integer cid) {
        String url = NAME_IDENTIFIER_SERVICE_URL + cid;

        return restTemplate.getForObject(url, NameIdentifierServiceDto.class);
    }

    @Override
    public ChemicalPhysicalPropertyServiceDto getChemicalPhysicalPropertyFromChemicalPhysicalPropertyService(Integer cid) {
        String url = CHEMICAL_PHYSICAL_PROPERTY_URL + cid;

        return restTemplate.getForObject(url, ChemicalPhysicalPropertyServiceDto.class);
    }

    @Override
    public OrganismServiceDto getOrganismFromOrganismService(Integer cid) {
        String url = ORGANISM_SERVICE_URL + cid;

        return restTemplate.getForObject(url, OrganismServiceDto.class);
    }
}
