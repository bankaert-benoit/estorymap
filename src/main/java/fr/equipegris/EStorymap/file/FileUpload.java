package fr.equipegris.EStorymap.file;


import fr.equipegris.EStorymap.diagramme.mcd.Mcd;
import fr.equipegris.EStorymap.diagramme.mfc.Mfc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class FileUpload {
	
	@Autowired
	private FileEntityRepository repo;

    @PostMapping(value = "/upload")
    public ResponseEntity<?> retrieveFile(@RequestParam("mcd") MultipartFile mcd, @RequestParam("mfc") MultipartFile mfc) {
		Mfc mfcObject = FileBuilder.buildMfc(mfc);
		Mcd mcdObject = FileBuilder.buildMcd(mcd);
		System.out.println(mcdObject.toString());
        if (mcd.isEmpty()) {
        	return new ResponseEntity<String> (HttpStatus.NO_CONTENT);
        }else {
        	this.saveUploadedFileToDB(mcd);
        	return new ResponseEntity<String>(HttpStatus.OK);
        }

    }
    
    /**
     * Save an uploaded file to DB
     * @param mpFile : MultipartFile from a request
     */
    public void saveUploadedFileToDB(MultipartFile mpFile) {
    	try {
    		String filename = mpFile.getOriginalFilename(); //attention à getOriginalFileName (cf doc)
			byte[] content = mpFile.getBytes();
			FileEntity fileEntity = new FileEntity(filename, content);
			
	    	repo.save(fileEntity); //on sauvegarde le fichier
		} catch (IOException e) {
			//TODO: Montrer l'erreur du côté client
			e.printStackTrace();
			System.err.println("Error on get content from uploaded file.");
		}
    	
    }



}
