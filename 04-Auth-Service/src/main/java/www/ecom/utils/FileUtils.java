package www.ecom.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	public static String saveFile(String fileName, MultipartFile file) throws Exception{
		Path uploadPath=Paths.get("uploads/user-images");
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		Path filePath=uploadPath.resolve(file.getOriginalFilename());
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		return filePath.getFileName().toString();
	}

}
