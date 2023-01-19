package org.herbal.chem.compound.file.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface Structure2DFileService {
    String storeStructure2DFile(MultipartFile structure2DFile);
    Resource serveStructure2DFile(String structure2DFilename);
}
