package project.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import project.Entity.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
}