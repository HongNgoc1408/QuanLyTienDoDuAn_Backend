package project.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

    @Id
    private String _id;
    private String username;
    private String password;
    private String id_user;
    private String email;
    private String fullName;
    private Role role;
    private String cccd;
    private String phone;
    private Boolean sex;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    public User() {
        this.role = Role.STAFF;
    }

    public User(String _id, String username, String password, String email, String fullName,
            Role role, String cccd, String phone, Boolean sex) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.role = role != null ? role : Role.STAFF;
        this.cccd = cccd;
        this.phone = phone;
        this.sex = sex;
    }

    // Getters and setters for all fields

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getcccd() {
        return cccd;
    }

    public void setcccd(String cccd) {
        this.cccd = cccd;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public Boolean getsex() {
        return sex;
    }

    public void setsex(Boolean sex) {
        this.sex = sex;
    }

    public String getFormattedCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return created_at.format(formatter);
    }

    public String getFormattedUpdatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return updated_at.format(formatter);
    }

    public enum Role {
        ADMIN, MANAGER, STAFF
    }
}
