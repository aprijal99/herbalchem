package org.herbal.chem.compound.file.service;

import org.herbal.chem.compound.file.util.CompoundFileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class Structure2DFileServiceImpl implements Structure2DFileService{
    private final Path structure2DRootPath;

    public Structure2DFileServiceImpl(@Value("${storage.location.structure2d.file}") String structure2DStorageLocation) {
        this.structure2DRootPath = Paths.get(structure2DStorageLocation);
    }

    @Override
    public String storeStructure2DFile(MultipartFile structure2DFile) {
        return CompoundFileUtils.storeAndGetNewFilename(structure2DFile, structure2DRootPath);
    }

    @Override
    public Resource serveStructure2DFile(String structure2DFilename) {
        return CompoundFileUtils.getStructureResource(structure2DFilename, structure2DRootPath);
    }
}
