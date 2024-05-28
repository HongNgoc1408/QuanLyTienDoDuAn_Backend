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

    @PostMapping(value = "/add")
    public String saveProfile(@RequestBody Profile profile) {
        profileService.createProfile(profile);
        return profile.get_id();
    }

    @GetMapping(value = "/getall")
    public Iterable<Profile> getProfiles() {
        return profileService.getAllProfiles();
    }

    @PutMapping(value = "/edit/{id}")
    public Profile updateProfile(@RequestBody Profile profile, @PathVariable("id") String id) {
        return profileService.updateProfile(id, profile);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfile(@PathVariable("id") String id) {
        profileService.deleteProfile(id);
    }

    @GetMapping("/get/{id}")
    public Profile getProfileById(@PathVariable("id") String id) {
        return profileService.getProfileById(id);
    }
}
