package project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entity.Progress;
import project.Repo.ProgressRepo;

@Service
public class ProgressServices {
    @Autowired
    private ProgressRepo repo;

    public void saveorUpdate(Progress progresses) {

        repo.save(progresses);
    }

    public Iterable<Progress> listAll() {

        return this.repo.findAll();
    }

    public void deleteProgress(String _id) {

        repo.deleteById(_id);
    }

    public Progress getProgressByID(String _id) {

        return repo.findById(_id).get();
    }

    public List<Progress> getProgressByUserId(String userId) {
        return repo.findByAssignedToContaining(userId);
    }
}
