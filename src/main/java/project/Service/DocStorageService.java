package project.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.Entity.Doc;
import project.Repo.DocRepository;

@Service
public class DocStorageService {

    @Autowired
    private DocRepository docRepository;

    public void saveFile(MultipartFile file) {
        try {
            Doc doc = new Doc();
            doc.setDocname(file.getOriginalFilename());
            doc.setContentType(file.getContentType());
            doc.setData(file.getBytes());
            docRepository.save(doc);
        } catch (IOException e) {
          throw new RuntimeException("Error saving file", e);
        }
    }

    public List<Doc> getFiles() {
        return docRepository.findAll();
    }

    public Optional<Doc> getFile(String id) {
        return docRepository.findById(id);
    }
}
