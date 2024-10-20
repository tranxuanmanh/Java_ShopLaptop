package com.example.hocjpa_hodanit.Service;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class UploadFileService {
    private final ServletContext servletContext;

    public UploadFileService(ServletContext servletContext) {
        this.servletContext =servletContext;
    }
    public String uploadFile(MultipartFile file,String foder) throws IOException {
        byte[] bytes=file.getBytes();
        String fileName="";
        //Duong dan tuyet doi
//       String rootPath = "D:/SpringMVC/HocJPA_HodanIT/src/main/resources/static/Image/Avatar";
        //Duong dan tuong doi
        StringBuilder rootFile=new StringBuilder("src/main/resources/static/Image/");
        //String rootPath="src/main/resources/static/Image/"+foder;
        File dir=new File(String.valueOf(rootFile.append(foder)));
        if(!dir.exists()) dir.mkdir();

        //Create the file on server
         fileName= System.currentTimeMillis()+"-"+file.getOriginalFilename();//Miligiay + ten file
         File serverFile=new File(dir.getAbsolutePath()+ File.separator+ fileName);
        BufferedOutputStream stream=new BufferedOutputStream(
                new FileOutputStream(serverFile)
        );
        stream.write(bytes);
        stream.close();
        return fileName;
    }
}
