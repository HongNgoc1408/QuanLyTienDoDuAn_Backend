// package project.Service;
// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;
// import project.Entity.Doc;
// import project.Repo.DocRepository;
// @Service
// public class DocStorageService {
//     @Autowired
//     private DocRepository docRepository;
//     public Doc saveFile(MultipartFile file) {
//         String docname = file.getOriginalFilename();
//         try {
//             if (docname == null || file.isEmpty()) {
//                 throw new IllegalArgumentException("File is empty or filename is null");
//             }
//             String id = UUID.randomUUID().toString(); // Generate a unique ID
//             Doc doc = new Doc(id, docname, file.getContentType(), file.getBytes());
//             return docRepository.save(doc);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return null;
//     }
//     public Optional<Doc> getFile(String fileId) {
//         return docRepository.findById(fileId);
//     }
//     public List<Doc> getFiles() {
//         return docRepository.findAll();
//     }
// }
package project.Service;

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
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    public List<Doc> getFiles() {
        return docRepository.findAll();
    }

    public Optional<Doc> getFile(String id) {
        return docRepository.findById(id);
    }
}
