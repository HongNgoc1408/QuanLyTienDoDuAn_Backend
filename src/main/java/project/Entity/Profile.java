package project.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Profiles")
public class Profile {

    @Id
    private String _id;
    private String title;
    private String content;
    private String type;
    private String published_date;
    private String organ;
    // private String quantity;
    private String original;
    private String offical;
    private String photo;
    private String note;
    private List<String> fileId;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    public Profile(String _id, String title, String content, String type,
            String published_date, String organ, String original, String offical, String photo, String note,
            List<String> fileId) {
        this._id = _id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.published_date = published_date;
        this.organ = organ;
        // this.quantity = quantity;
        this.original = original;
        this.offical = offical;
        this.photo = photo;
        this.note = note;
        this.fileId = fileId;
    }

    public Profile() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    // public String getQuantity() {
    //     return quantity;
    // }
    // public void setQuantity(String quantity) {
    //     this.quantity = quantity;
    // }
    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOffical() {
        return offical;
    }

    public void setOffical(String offical) {
        this.offical = offical;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public String getFormattedCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return created_at.format(formatter);
    }

    public String getFormattedUpdatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return updated_at.format(formatter);
    }

    public List<String> getFileId() {
        return fileId;
    }

    public void setFileId(List<String> fileId) {
        this.fileId = fileId;
    }

}
