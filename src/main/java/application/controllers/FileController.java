package application.controllers;

import application.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class FileController {
	private final FileService fileService;

	@PostMapping("/file")
	public String submit(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		fileService.saveFile(multipartFile);
		return "redirect:/";
	}
}
