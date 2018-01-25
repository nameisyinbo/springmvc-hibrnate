package online.qsx.dao.impl;

import online.qsx.dao.UserDao;
import online.qsx.model.UserModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{
    @Autowired
    private BaseDao baseDao;

    @Override
    public UserModel queryOneById(UserModel userModel) {
        return baseDao.getHibernateTemplate().get(UserModel.class,userModel.getId());
    }

    @Override
    public List<UserModel> queryOneByName(UserModel userModel) {
        Session session = baseDao.getHibernateTemplate().getSessionFactory().openSession();
        String hql = "from UserModel where userName like ? ";
        Query query= session.createQuery(hql);
        query.setString(0,userModel.getUserName());
        List<UserModel> list=query.list();
        session.close();
        return list;
    }

    @Override
    public List<UserModel> findAll() {
        return (List<UserModel>)baseDao.getHibernateTemplate().find("from UserModel");
    }

    @Override
    public void save(UserModel userModel) {
        userModel.setCreateDate(new Date());
        baseDao.getHibernateTemplate().save(userModel);
    }

    @Override
    public void edit(UserModel userModel) {
        userModel.setCreateDate(new Date());
        baseDao.getHibernateTemplate().update(userModel);
    }

    @Override
    public void remove(UserModel userModel) {
        baseDao.getHibernateTemplate().delete(userModel);
    }

    @Override
    public List<UserModel> pageAll(int pageSize, int pageNo) {
        Session session = baseDao.getHibernateTemplate().getSessionFactory().openSession();
        Query query= session.createQuery("from UserModel");
        query.setMaxResults(pageSize);
        query.setFirstResult((pageNo-1)*pageSize);
        List<UserModel> list=query.list();
        session.close();
        return list;
    }

    @Override
    public int totalCount() {
        List<UserModel> list =(List<UserModel>) baseDao.getHibernateTemplate().find("from UserModel");
        int totalCount= list.size();
        return totalCount;
    }
}
