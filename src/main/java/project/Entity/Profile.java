package project.Entity;

import org.springframework.data.annotation.Id;
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
    private String quantity;
    private String note;

    public Profile(String _id, String title, String content, String type, 
            String published_date, String organ, String quantity, String note) {
        this._id = _id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.published_date = published_date;
        this.organ = organ;
        this.quantity = quantity;
        this.note = note;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}

