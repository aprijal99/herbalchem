package org.herbal.chem.compound.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.api.exception.InvalidInputException;
import org.herbal.chem.api.exception.NotFoundException;
import org.herbal.chem.compound.entity.CompoundEntity;
import org.herbal.chem.compound.mapper.CompoundMapper;
import org.herbal.chem.compound.service.CompoundService;
import org.springframework.hateoas.CollectionModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class CompoundController {
    private final CompoundService compoundService;
    private final CompoundMapper compoundMapper;

    @PostMapping(path = "/compounds", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompoundEntity> saveCompound(@RequestBody CompoundEntity compoundEntity) {
        log.debug("Save a compound with name: {}", compoundEntity.getCompoundName());
        CompoundEntity savedCompound = compoundService.saveCompound(compoundEntity);

        savedCompound.add(linkTo(methodOn(CompoundController.class).oneCompound(savedCompound.getHerbalChemCid())).withSelfRel());
        savedCompound.add(linkTo(methodOn(CompoundController.class).allCompounds()).withRel(IanaLinkRelations.COLLECTION));

        return ResponseEntity
                .created(linkTo(methodOn(CompoundController.class).oneCompound(savedCompound.getHerbalChemCid())).toUri())
                .body(savedCompound);
    }

    @GetMapping(path = "/compounds/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompoundServiceDto> oneCompound(@PathVariable(name = "cid") Integer cid) {
        if (cid < 1) {
            throw new InvalidInputException("Invalid CID " + cid + ", it can not be negative value");
        }

        log.debug("Get a compound with cid: {}", cid);
        CompoundEntity compound = compoundService.getCompoundByCid(cid)
                .orElseThrow(() -> new NotFoundException("Compound with CID " + cid + " is not found in database"));
        CompoundServiceDto compoundServiceDto = compoundMapper.entityToDto(compound);

        return ResponseEntity.ok(compoundServiceDto);
    }

    @GetMapping(path = "/compounds", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollectionModel<CompoundEntity>> allCompounds() {
        log.debug("Get all compounds");
        List<CompoundEntity> compounds = compoundService.getAllCompounds();

        if (compounds.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        compounds.forEach(compound -> {
            compound.add(linkTo(methodOn(CompoundController.class).oneCompound(compound.getHerbalChemCid())).withSelfRel());
            compound.add(linkTo(methodOn(CompoundController.class).allCompounds()).withRel(IanaLinkRelations.COLLECTION));
        });

        CollectionModel<CompoundEntity> compoundEntityCollectionModel = CollectionModel.of(
                compounds,
                linkTo(methodOn(CompoundController.class).allCompounds()).withSelfRel()
        );

        return ResponseEntity.ok(compoundEntityCollectionModel);
    }
}
