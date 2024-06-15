package project.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import project.Entity.Progress;

@Repository
public interface ProgressRepo extends MongoRepository<Progress, String> {
    List<Progress> findByAssignedToContaining(String userId);
}
