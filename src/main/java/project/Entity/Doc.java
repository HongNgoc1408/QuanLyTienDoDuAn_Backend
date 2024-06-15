package project.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "docs")
public class Doc {

    @Id
    private String _id;
    private String docname;
    private String contentType;
    private byte[] data;


    public Doc() {}

    public Doc(String _id, String docname, String contentType, byte[] data) {
        this._id = _id;
        this.docname = docname;
        this.contentType = contentType;
        this.data = data;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
