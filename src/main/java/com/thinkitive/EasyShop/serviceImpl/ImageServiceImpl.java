package com.thinkitive.EasyShop.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.thinkitive.EasyShop.Exception.FileNotFoundException;
import com.thinkitive.EasyShop.Exception.FileStorageException;
import com.thinkitive.EasyShop.model.StorageProperties;
import com.thinkitive.EasyShop.service.ImageService;


@Service
public class ImageServiceImpl implements ImageService{
	
	
	private final Path fileStorageProperties;
	
	@Autowired
	public ImageServiceImpl(StorageProperties fileStorageProperties) {
		this.fileStorageProperties = Paths.get(fileStorageProperties.getLocation()).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.fileStorageProperties);
		}catch(Exception ex){
			throw new FileStorageException("could not create the directory");
		}
	}
	
	

	
	@Override
	@PostConstruct
	public void init() {
		try {
            Files.createDirectories(fileStorageProperties);
        } catch (IOException e) {
            throw new FileStorageException("Could not initialize storage location", e);
        }		
	}

	@Override
	public String store(MultipartFile file) {
		 String filename = StringUtils.cleanPath(file.getOriginalFilename());
	        try {
	            if (file.isEmpty()) {
	                throw new FileStorageException("Failed to store empty file " + filename);
	            }
	            if (filename.contains("..")) {
	                // This is a security check
	                throw new FileStorageException(
	                        "Cannot store file with relative path outside current directory "
	                                + filename);
	            }
	            try (InputStream inputStream = file.getInputStream()) {
	                Files.copy(inputStream, this.fileStorageProperties.resolve(filename),
	                        StandardCopyOption.REPLACE_EXISTING);
	            }
	        }
	        catch (IOException e) {
	            throw new FileStorageException("Failed to store file " + filename, e);
	        }

	        return filename;
	}

	@Override
	public Stream<Path> loadAll() {
		try {
            return Files.walk(this.fileStorageProperties, 1)
                    .filter(path -> !path.equals(this.fileStorageProperties))
                    .map(this.fileStorageProperties::relativize);
        }
        catch (IOException e) {
            throw new FileStorageException("Failed to read stored files", e);
        }
	}

	@Override
	public Path load(String filename) {
		 return fileStorageProperties.resolve(filename);
	}
	@Override
	public Resource loadAsResource(String filename) {
		 try {
	            Path file = load(filename);
	            Resource resource = new UrlResource(file.toUri());
	            if (resource.exists() || resource.isReadable()) {
	                return resource;
	            }
	            else {
	                throw new FileNotFoundException(
	                        "Could not read file: " + filename);
	            }
	        }
	        catch (MalformedURLException e) {
	            throw new FileNotFoundException("Could not read file: " + filename, e);
	        }
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(fileStorageProperties.toFile());		
	}

}
