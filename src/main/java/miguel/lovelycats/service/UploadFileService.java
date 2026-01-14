package miguel.lovelycats.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileService {

    private final String UPLOAD_FOLDER = "src/main/resources/static/uploads";
    // Usar ruta estática relativa para desarrollo, o externa para prod.
    // Al usar JAR, static/uploads estará en classpath, no escribible en runtime si
    // está dentro del jar.
    // Para simplificar: guardaré fuera, o usaré una carpeta temporal.
    // Mejor: "uploads" en root del proyecto (fuera de src) para que persista en
    // dev.
    private final Path rootLocation = Paths.get("uploads");

    public UploadFileService() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo inicializar carpeta uploads", e);
        }
    }

    public String copy(MultipartFile file) throws IOException {
        String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path destinationFile = rootLocation.resolve(uniqueFilename);

        Files.copy(file.getInputStream(), destinationFile);

        return uniqueFilename;
    }

    public boolean delete(String filename) {
        Path file = rootLocation.resolve(filename);
        try {
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Resource load(String filename) throws MalformedURLException {
        Path file = rootLocation.resolve(filename);
        Resource resource = new UrlResource(file.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("No se puede leer archivo: " + filename);
        }
    }
}