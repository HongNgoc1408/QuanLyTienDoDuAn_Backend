package project.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import project.Entity.User;
import project.Entity.User.Role;
import project.Repo.UserRepo;

@Service
public class UserService {
    LocalDateTime now = LocalDateTime.now();
    int year = now.getYear();
    int lastTwoDigitsOfYear = year % 100;
    @Autowired
    private UserRepo repo;

    @Autowired
    private MongoTemplate mongoTemplate;

    private int idCounter;

    @PostConstruct
    public void initializeIdCounter() {
        Query query = new Query();
        long count = mongoTemplate.count(query, User.class);
        idCounter = (int) count;
    }

    public void saveOrUpdate(User user) {
        idCounter++;
        String id_userPrefix = getIdPrefixForRole(user.getRole());
        String id_user = String.format("%s%d%02d", id_userPrefix, lastTwoDigitsOfYear, idCounter);
        user.setId_user(id_user);
        System.out.println("DEBUG: Generated id_user = " + id_user);
        repo.save(user);
    }

    private String getIdPrefixForRole(Role role) {
        switch (role) {
            case ADMIN:
                return "AD";
            case MANAGER:
                return "TP";
            default:
                return "NV";
        }
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
