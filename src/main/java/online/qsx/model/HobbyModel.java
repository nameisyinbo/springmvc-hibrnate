package online.qsx.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HobbyModel {
    @Id
    @Column(name="hobby_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hobbyName;
    @Column(name="hobby_createDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public HobbyModel(String hobbyName, Date createDate) {
        this.hobbyName = hobbyName;
        this.createDate = createDate;
    }

    public HobbyModel() {
    }
    public HobbyModel(Long id,String hobbyName, Date createDate) {
        this.hobbyName = hobbyName;
        this.createDate = createDate;
        this.id = id;
    }
    public HobbyModel(Long id) {
        this.id=id;
    }
}
