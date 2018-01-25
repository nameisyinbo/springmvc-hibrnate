package online.qsx.service;

import online.qsx.model.LoginModel;

public interface LoginService extends Service<LoginModel>{
    LoginModel queryByName(LoginModel loginModel);
}
