package online.qsx.model;


import javax.persistence.*;
import java.util.Date;

//一般用户
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String verifyPassword;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    private String sex;
    private String profession;
    private String hobby;
    @Temporal(TemporalType.DATE)
    @Column(name="user_createDate")
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public UserModel(Long id) {
        this.id = id;
    }


    public UserModel() {
    }

    public UserModel(String userName, String password, String verifyPassword, String email, Date birthdate, String sex, String profession, String hobby, Date createDate) {
        this.userName = userName;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.email = email;
        this.birthdate = birthdate;
        this.sex = sex;
        this.profession = profession;
        this.hobby = hobby;
        this.createDate = createDate;
    }

    public UserModel(Long id, String userName, String password, String verifyPassword, String email, Date birthdate, String sex, String profession, String hobby, Date createDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.email = email;
        this.birthdate = birthdate;
        this.sex = sex;
        this.profession = profession;
        this.hobby = hobby;
        this.createDate = createDate;
    }

}
