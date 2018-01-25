package online.qsx.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class LoginModel {
    @Id
    private String userName;
    private String password;

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

    public LoginModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LoginModel() {
    }

    public LoginModel(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginModel)) return false;
        LoginModel loginModel = (LoginModel) o;
        return Objects.equals(userName, loginModel.getUserName()) &&
                Objects.equals(password, loginModel.getPassword());
    }

}
