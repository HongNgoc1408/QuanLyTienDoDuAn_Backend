package project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entity.Profile;
import project.Repo.ProfileRepo;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    public void saveOrUpdate(Profile profile) {
        profileRepo.save(profile);
    }

    public Iterable<Profile> listAll() {
        return profileRepo.findAll();
    }

    public void deleteProfile(String id) {
        profileRepo.deleteById(id);
    }

    public Profile getProfileById(String id) {
        return profileRepo.findById(id).orElse(null);
    }
}
