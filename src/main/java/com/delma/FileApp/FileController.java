package com.delma.FileApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    FileServiceImplementation fileServiceImplementation;

    @GetMapping("/upload")
    public String getUploadPage(){
        return "UploadFile";
    }

    @PostMapping("/processUpload")
    public String processUpload(@RequestParam("file")MultipartFile file, Model model) throws IOException {
        byte[] content = file.getBytes();
        String name = file.getOriginalFilename();
        String fileType = file.getContentType();
        FileModel fileModel = new FileModel(content, name, fileType);
        fileServiceImplementation.saveFile(fileModel);

        model.addAttribute("allFiles", fileServiceImplementation.getAllFiles());

        return "DisplayFiles";
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id){
        FileModel fm = fileServiceImplementation.getFile(id);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_TYPE, fm.getFileType());
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename="+fm.getName());
        return ResponseEntity.ok()
                .headers(header)
                .body(fm.getContent());

    }



}
