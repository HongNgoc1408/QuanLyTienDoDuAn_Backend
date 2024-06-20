package project.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Progresses")
public class Progress {

    @Id
    private String _id;
    private String title;
    private String description;
    private String manager;
    private List<String> assignedTo;
    private List<String> profileId;
    private String status;
    private String priority;
    private String start_date;
    private String end_date;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    public Progress(String _id, String title, String description, String manager, List<String> assignedTo, List<String> profileId, String status,
            String priority, String start_date, String end_date) {
        this._id = _id;
        this.title = title;
        this.description = description;
        this.manager = manager;
        this.assignedTo = assignedTo;
        this.profileId = profileId;
        this.status = status;
        this.priority = priority;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Progress() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<String> getassignedTo() {
        return assignedTo;
    }

    public void setassignedTo(List<String> assignedTo) {
        this.assignedTo = assignedTo;
    }

    public List<String> getprofileId() {
        return profileId;
    }

    public void setprofileId(List<String> profileId) {
        this.profileId = profileId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public String getFormattedCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return created_at.format(formatter);
    }

    public String getFormattedUpdatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return updated_at.format(formatter);
    }

    @Override
    public String toString() {
        return "Progress{"
                + "_id='" + _id + '\''
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + ", assignedTo='" + assignedTo + '\''
                + ", profileId='" + profileId + '\''
                + ", status='" + status + '\''
                + ", priority='" + priority + '\''
                + ", start_date='" + start_date + '\''
                + ", end_date='" + end_date + '\''
                + '}';
    }
}
