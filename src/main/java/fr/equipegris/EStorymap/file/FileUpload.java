package fr.equipegris.EStorymap.file;

import fr.equipegris.EStorymap.diagramme.mfc.Composant;
import fr.equipegris.EStorymap.diagramme.mfc.Mfc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class FileUpload {
	
	@Autowired
	private FileEntityRepository repo;

    @PostMapping(value = "/upload")
    public ResponseEntity<?> retrieveFile(@RequestParam("mcd") MultipartFile req, @RequestParam("mfc") MultipartFile mfc) {
        System.out.println(req);
        //save file to DB
        if (req.isEmpty()) {
        	//TODO: dire au client que son fichier est vide
        	// et stopper exécution
        }else {
        	 //this.saveUploadedFileToDB(req);
        }

		try {
			File tmp = convert(mfc);
			FileInputStream fis = new FileInputStream(tmp);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			List<Composant> composants = (ArrayList) ois.readObject();

			Mfc mfc1 = new Mfc(mfc.getOriginalFilename(),composants);
			System.out.println(mfc1.toString());

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}


		return new ResponseEntity<String>(HttpStatus.OK);
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

	public File convert(MultipartFile file) throws IOException {
		File convFile = File.createTempFile(System.getProperty("java.io.tmpdir"), file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
