package online.qsx.dao;

import online.qsx.model.LoginModel;

public interface LoginDao extends Dao<LoginModel>{
    LoginModel queryByName(LoginModel loginModel);
}
