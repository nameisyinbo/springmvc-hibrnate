package online.qsx.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProfessionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profession_id")
    private Long id;
    private String professionName;
    @Column(name = "profession_createDate")
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ProfessionModel(String professionName, Date createDate) {
        this.professionName = professionName;
        this.createDate = createDate;
    }

    public ProfessionModel(Long id) {
        this.id=id;
    }
    public ProfessionModel() {
    }
    public ProfessionModel(Long id,String professionName, Date createDate) {
        this.professionName = professionName;
        this.createDate = createDate;
        this.id = id;
    }
}
