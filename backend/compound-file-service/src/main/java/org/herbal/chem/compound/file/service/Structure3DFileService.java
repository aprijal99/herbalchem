package org.herbal.chem.compound.file.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface Structure3DFileService {
    String storeStructure3DFile(MultipartFile structure3DFile);
    Resource serveStructure3DFile(String structure3DFilename);
}
