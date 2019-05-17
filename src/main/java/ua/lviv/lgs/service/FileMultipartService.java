package ua.lviv.lgs.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.model.Photo;
import ua.lviv.lgs.repository.FileMultipartRepository;

@Service
public class FileMultipartService {

	@Autowired
	private FileMultipartRepository fileMultipartRepository;

	public Photo storeFile(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Photo multipart = null;

		if (!fileName.contains("..")) {
			multipart = new Photo(fileName, file.getContentType(), file.getBytes());
		}

		return fileMultipartRepository.save(multipart);
	}

	public Photo getFile(String fileId) throws FileNotFoundException {
		return fileMultipartRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with Id =" + fileId));
	}

}
