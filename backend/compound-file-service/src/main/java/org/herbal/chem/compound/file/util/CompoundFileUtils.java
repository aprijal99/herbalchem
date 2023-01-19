package org.herbal.chem.compound.file.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class CompoundFileUtils {
    public static String storeAndGetNewFilename(MultipartFile multipartFile, Path rootPath) {
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String filename = UUID.randomUUID() + "." + extension;

        Path destinationFile = rootPath.resolve(Paths.get(filename)).normalize().toAbsolutePath();

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return filename;
    }

    public static Resource getStructureResource(String structureFilename, Path rootPath) {
        Path resolvedFile = rootPath.resolve(structureFilename);

        try {
            return new UrlResource(resolvedFile.toUri());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
