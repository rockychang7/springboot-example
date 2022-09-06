package com.mamba.excel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author JoeBig7
 * @date 2022/9/6 13:14:31
 */
@Controller
@RequestMapping("/api/excel")
public class ExcelUploadController {

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            //对流进行后续操作，存入mysql,写出到另外的文件等
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
