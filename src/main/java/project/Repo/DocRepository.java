package project.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import project.Entity.Doc;

@Repository
public interface DocRepository  extends MongoRepository<Doc,String>{

}