package project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Entity.Profile;
import project.Repo.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    public Profile getProfileById(String id) {
        Optional<Profile> profileOptional = profileRepo.findById(id);
        return profileOptional.orElse(null);
    }

    public Profile createProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    public Profile updateProfile(String id, Profile profile) {
        Optional<Profile> profileOptional = profileRepo.findById(id);
        if (profileOptional.isPresent()) {
            profile.set_id(id);
            return profileRepo.save(profile);
        } else {
            return null; // or throw an exception
        }
    }

    public void deleteProfile(String id) {
        profileRepo.deleteById(id);
    }
}
