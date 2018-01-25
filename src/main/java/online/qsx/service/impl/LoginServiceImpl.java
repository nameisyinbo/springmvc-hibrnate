package online.qsx.service.impl;

import online.qsx.dao.LoginDao;
import online.qsx.model.LoginModel;
import online.qsx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginDao loginDao;
    @Override
    public LoginModel queryByName(LoginModel loginModel) {
        return loginDao.queryByName(loginModel);
    }

    @Override
    public List<LoginModel> findAll() {
        return null;
    }

    @Override
    public void save(LoginModel loginModel) {

    }

    @Override
    public void edit(LoginModel loginModel) {

    }

    @Override
    public void remove(LoginModel loginModel) {

    }

    @Override
    public List<LoginModel> pageAll(int pageSize, int pageNo) {
        return null;
    }

    @Override
    public int totalCount() {
        return 0;
    }
}
