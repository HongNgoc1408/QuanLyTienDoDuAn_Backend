package project.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import project.Entity.Profile;

@Repository
public interface ProfileRepo extends MongoRepository<Profile, String> {
}
