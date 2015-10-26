package com.dimon.xcrm.controller;


import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 一句话说明类的作用
 * @author Dimon
 * @createDate 2015年10月20日 上午9:52:15
 */
@Controller
@RequestMapping("/files")
public class FileController {
	private static Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@RequestMapping("/upload")
	public String upload(String desc,MultipartFile file) throws IllegalStateException, IOException{
		if (!file.isEmpty()){
			file.transferTo(new File("..\\"+file.getOriginalFilename()));
			logger.info("文件{}上传成功", file.getOriginalFilename());
		}
		return "main";
	}
	
}
