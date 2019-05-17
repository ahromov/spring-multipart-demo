package ua.lviv.lgs.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ua.lviv.lgs.dto.MultipartUploadResponse;
import ua.lviv.lgs.model.Photo;
import ua.lviv.lgs.model.User;
import ua.lviv.lgs.service.FileMultipartService;
import ua.lviv.lgs.service.UserService;

@RestController
public class FileMultipartController {

	@Autowired
	FileMultipartService fileMultipartService;

	@Autowired
	UserService userService;

	@PostMapping("/uploadFile")
	public MultipartUploadResponse uploadFile(@RequestParam("fName") String firstName,
			@RequestParam("lName") String lastName, @RequestParam("age") Integer userAge,
			@RequestParam("file") MultipartFile fileMultipart) throws IOException {
		Photo file = fileMultipartService.storeFile(fileMultipart);
		User user = userService.store(new User(firstName, lastName, userAge, file));

		String fName = user.getFirstName(), lName = user.getLastName();
		Integer age = user.getAge();

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(file.getId()).toUriString();

		return new MultipartUploadResponse(fName, lName, age, file.getFileName(), fileDownloadUri,
				fileMultipart.getContentType(), fileMultipart.getSize());
	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downlaodFile(@PathVariable String fileId) throws FileNotFoundException {
		Photo fileMultipart = fileMultipartService.getFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileMultipart.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileMultipart.getFileName() + "\"")
				.body(new ByteArrayResource(fileMultipart.getData()));
	}

}
