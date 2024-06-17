package project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.Entity.Doc;
import project.Service.DocStorageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/docs")
public class DocController {

    @Autowired
    private DocStorageService docStorageService;

    @PostMapping("/uploadFiles")
    public ResponseEntity<List<Doc>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            docStorageService.saveFile(file);
        }
        List<Doc> uploadedDocs = docStorageService.getFiles();
        return ResponseEntity.ok(uploadedDocs);
    }

    @GetMapping("/files")
    public ResponseEntity<List<Doc>> getFiles() {
        List<Doc> docs = docStorageService.getFiles();
        return ResponseEntity.ok(docs);
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileId) {
        Optional<Doc> docOptional = docStorageService.getFile(fileId);
        if (!docOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Doc doc = docOptional.get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + doc.getDocname() + "\"")
                .body(new ByteArrayResource(doc.getData()));
    }
}
