package com.ujc.clouddishes.service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImplementation implements FileStorageService {

	private final Path root = Paths.get("uploads");

	@Override
	public void save(MultipartFile file) {
		try {
				
			int lastDotIndex = file.getOriginalFilename().lastIndexOf('.');
			String s = file.getOriginalFilename().substring(0, lastDotIndex ) + this.DateFormattedForUploads() + file.getOriginalFilename().substring(lastDotIndex);
			
			Files.copy(file.getInputStream(), this.root.resolve(s));
		
		} catch (Exception e) {

			throw new RuntimeException("Could not store the file, Error: " + e.getMessage());
		}

	}

	@Override
	public Resource load(String filename) {
		try {

			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				
				 return new UrlResource("http://localhost:8080/api/device/files/default24052022.png");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	
	@Override
	public String DateFormattedForUploads() {
		LocalDateTime myDateObj = LocalDateTime.now();  
	    System.out.println("Before formatting: " + myDateObj);  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");  
	    String formattedDate = myDateObj.format(myFormatObj);  
	    return formattedDate;
	}
	





}
