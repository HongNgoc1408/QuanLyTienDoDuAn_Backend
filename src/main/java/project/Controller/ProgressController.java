package project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.Entity.Progress;
import project.Service.ProgressServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/progress")

public class ProgressController {
    @Autowired
    private ProgressServices progressServices;

    @PostMapping(value = "/add")
    private String saveProgress(@RequestBody Progress progresss) {

        progressServices.saveorUpdate(progresss);
        return progresss.get_id();
    }

    @GetMapping(value = "/getall")
    public Iterable<Progress> getProgresses() {
        return progressServices.listAll();
    }

    @GetMapping(value = "/get/{id}")
    private Progress getProgressById(@PathVariable(name = "id") String _id) {
        return progressServices.getProgressByID(_id);
    }

    @PutMapping(value = "/edit/{id}")
    private Progress update(@RequestBody Progress progress, @PathVariable(name = "id") String _id) {
        progress.set_id(_id);
        progressServices.saveorUpdate(progress);
        return progress;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteProgress(@PathVariable("id") String _id) {
        progressServices.deleteProgress(_id);
    }


    @RequestMapping("/search/{id}")
    private Progress getProgresses(@PathVariable(name = "id") String _id) {
        return progressServices.getProgressByID(_id);
    }
}
