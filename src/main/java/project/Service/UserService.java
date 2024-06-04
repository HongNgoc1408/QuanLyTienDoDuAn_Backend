package project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import project.Entity.User;
import project.Repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public void saveOrUpdate(User user) {
        repo.save(user);
    }

    public Iterable<User> listAll() {
        return repo.findAll();
    }

    public void deleteUser(String id) {
        repo.deleteById(id);
    }

    public User getUserById(String id) {
        return repo.findById(id).orElse(null);
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean checkUserExistence(User user) {
        Query query = new Query();
        query.addCriteria(
                new Criteria().orOperator(
                        Criteria.where("username").is(user.getUsername()),
                        Criteria.where("email").is(user.getEmail()),
                        Criteria.where("id_user").is(user.getId_user()),
                        Criteria.where("fullname").is(user.getFullName())));
        return mongoTemplate.exists(query, User.class);
    }
}
