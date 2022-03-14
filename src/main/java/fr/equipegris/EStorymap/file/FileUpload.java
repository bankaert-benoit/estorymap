package fr.equipegris.EStorymap.file;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;




@RestController
public class FileUpload {

    @PostMapping(value = "/upload")
    public ResponseEntity<?> retrieveFile(@RequestParam("file") MultipartFile req) {
        System.out.println(req);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
