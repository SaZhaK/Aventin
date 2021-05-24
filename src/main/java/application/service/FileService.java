package application.service;

import application.properties.FileProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class FileService {
	private final FileProperties fileProperties;

	public void saveFile(MultipartFile multipartFile) throws IOException {
		if (!Files.exists(Paths.get("src/main/resources/xml"))) {
			Files.createDirectory(Paths.get("src/main/resources/xml"));
		}

		if (Files.exists(Paths.get(fileProperties.getRootDirectory()))) {
			Files.delete(Paths.get(fileProperties.getRootDirectory()));
		}

		File targetFile = new File(fileProperties.getRootDirectory());

		InputStream initialStream = multipartFile.getInputStream();
		byte[] buffer = new byte[initialStream.available()];
		initialStream.read(buffer);

		try (OutputStream outStream = new FileOutputStream(targetFile)) {
			outStream.write(buffer);
		}
	}

}
