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

    @Autowired
    private MongoTemplate mongoTemplate;

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

    public boolean checkUsernameExistence(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mongoTemplate.exists(query, User.class);
    }

    public boolean checkEmailExistence(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.exists(query, User.class);
    }

    public boolean checkUserIdExistence(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id_user").is(userId));
        return mongoTemplate.exists(query, User.class);
    }
}
