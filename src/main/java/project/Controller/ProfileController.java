package project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.Entity.Profile;
import project.Service.ProfileService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/add")
    public void addProfile(@RequestBody Profile profile) {
        profileService.saveOrUpdate(profile);
    }

    @GetMapping("/getall")
    public Iterable<Profile> getAllProfiles() {
        return profileService.listAll();
    }

    @GetMapping(value = "/get/{id}")
    private Profile getProfileById(@PathVariable(name = "id") String _id) {
        return profileService.getProfileById(_id);
    }


    @PutMapping("/edit/{id}")
    public void updateProfile(@PathVariable String id, @RequestBody Profile profile) {
        Profile existingProfile = profileService.getProfileById(id);
        if (existingProfile != null) {
            profile.set_id(id); // Ensure the ID remains the same
            profileService.saveOrUpdate(profile);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfile(@PathVariable String id) {
        profileService.deleteProfile(id);
    }
}
