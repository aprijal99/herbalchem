package org.herbal.chem.compound.file.service;

import org.herbal.chem.compound.file.util.CompoundFileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class Structure3DFileServiceImpl implements Structure3DFileService {
    private final Path structure3DRootPath;

    public Structure3DFileServiceImpl(@Value("${storage.location.structure3d.file}") String structure3DStorageLocation) {
        this.structure3DRootPath = Paths.get(structure3DStorageLocation);
    }

    @Override
    public String storeStructure3DFile(MultipartFile structure3DFile) {
        return CompoundFileUtils.storeAndGetNewFilename(structure3DFile, structure3DRootPath);
    }

    @Override
    public Resource serveStructure3DFile(String structure3DFilename) {
        return CompoundFileUtils.getStructureResource(structure3DFilename, structure3DRootPath);
    }
}
