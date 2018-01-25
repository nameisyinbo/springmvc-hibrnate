package online.qsx.dao.impl;

import online.qsx.dao.LoginDao;
import online.qsx.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LoginDaoImpl implements LoginDao{
    @Autowired
    private BaseDao baseDao;
    @Override
    public LoginModel queryByName(LoginModel loginModel) {
        return baseDao.getHibernateTemplate().get(LoginModel.class,loginModel.getUserName());
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
