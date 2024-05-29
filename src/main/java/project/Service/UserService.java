package project.Service;

import org.springframework.beans.factory.annotation.Autowired;
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
}