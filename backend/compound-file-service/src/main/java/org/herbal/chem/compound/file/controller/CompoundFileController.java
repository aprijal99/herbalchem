package org.herbal.chem.compound.file.controller;

import lombok.AllArgsConstructor;
import org.herbal.chem.compound.file.service.Structure2DFileService;
import org.herbal.chem.compound.file.service.Structure3DFileService;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/compound-file")
public class CompoundFileController {
    private final Structure2DFileService structure2DFileService;
    private final Structure3DFileService structure3DFileService;

    @PostMapping(
            path = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<EntityModel<Map<String, String>>> uploadFile(
            @RequestParam(name = "structure2DFile") MultipartFile structure2DFile,
            @RequestParam(name = "structure3DFile") MultipartFile structure3DFile
    ) {
        String structure2DFilename = structure2DFileService.storeStructure2DFile(structure2DFile);
        String structure3DFilename = structure3DFileService.storeStructure3DFile(structure3DFile);

        Map<String, String> uploadFileResponse = new HashMap<>();
        uploadFileResponse.put("structure_2d_filename", structure2DFilename);
        uploadFileResponse.put("structure_3d_filename", structure3DFilename);

        EntityModel<Map<String, String>> uploadFileResponseEntityModel = EntityModel.of(uploadFileResponse)
                .add(linkTo(methodOn(CompoundFileController.class).structure2DFile(structure2DFilename)).withRel("structure_2d_link"))
                .add(linkTo(methodOn(CompoundFileController.class).structure3DFile(structure3DFilename)).withRel("structure_3d_link"));

        return ResponseEntity.ok(uploadFileResponseEntityModel);
    }

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(path = "/structure2d/{structure2d}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Resource> structure2DFile(@PathVariable(name = "structure2d") String structure2DFilename) {
        Resource structure2DResource = structure2DFileService.serveStructure2DFile(structure2DFilename);

        return ResponseEntity.ok(structure2DResource);
    }

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(path = "/structure3d/{structure3d}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Resource> structure3DFile(@PathVariable(name = "structure3d") String structure3DFilename) {
        Resource structure3DResource = structure3DFileService.serveStructure3DFile(structure3DFilename);

        return ResponseEntity.ok(structure3DResource);
    }
}
