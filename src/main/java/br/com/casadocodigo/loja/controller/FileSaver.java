package br.com.casadocodigo.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Cristiano on 10/14/17.
 */
@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;

	public String write(String baseFolder, MultipartFile file) {
		String realPath = request.getServletContext().getRealPath("/" + baseFolder);

		try {
			String homePath = System.getProperty("user.home");
			String baseFolderPath = homePath + "/" + baseFolder;
			String filePath = baseFolderPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(filePath));
			return baseFolder + "/" + file.getOriginalFilename();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
