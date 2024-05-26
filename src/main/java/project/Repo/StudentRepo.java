package project.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import project.Entity.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student,String> {
}
