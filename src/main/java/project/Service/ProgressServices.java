package project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entity.Profile;
import project.Entity.Progress;
import project.Exception.ResourceNotFoundException;
import project.Repo.ProgressRepo;

@Service
public class ProgressServices {

    @Autowired
    private ProgressRepo repo;

    public void saveorUpdate(Progress progress) {
        progress.calculatePercentComplete();
        repo.save(progress);
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

    public Progress updateProfileInProgress(String progressId, String profileId, Profile updatedProfile) {
        Optional<Progress> progressOptional = repo.findById(progressId);
        if (progressOptional.isPresent()) {
            Progress progress = progressOptional.get();
            List<Profile> profiles = progress.getprofileId();
            for (int i = 0; i < profiles.size(); i++) {
                if (profiles.get(i).get_id().equals(profileId)) {
                    profiles.set(i, updatedProfile);
                    break;
                }
            }
            progress.setprofileId(profiles);
            repo.save(progress);
            return progress;
        } else {
            throw new ResourceNotFoundException("Progress not found with id: " + progressId);
        }
    }
}
