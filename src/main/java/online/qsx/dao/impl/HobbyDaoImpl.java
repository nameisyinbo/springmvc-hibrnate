package online.qsx.dao.impl;

import online.qsx.dao.HobbyDao;
import online.qsx.model.HobbyModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository("hobbyDaoImpl")
public class HobbyDaoImpl implements HobbyDao{
    @Autowired
    private BaseDao baseDao;
    @Override
    public HobbyModel queryById(HobbyModel hobbyModel) {
        return baseDao.getHibernateTemplate().get(HobbyModel.class,hobbyModel.getId());
    }

    @Override
    public List<HobbyModel> findAll() {
        return (List<HobbyModel>) baseDao.getHibernateTemplate().find("from HobbyModel");
    }

    @Override
    public void save(HobbyModel hobbyModel) {
        hobbyModel.setCreateDate(new Date());
        baseDao.getHibernateTemplate().save(hobbyModel);
    }

    @Override
    public void edit(HobbyModel hobbyModel) {
        hobbyModel.setCreateDate(new Date());
        baseDao.getHibernateTemplate().update(hobbyModel);
    }

    @Override
    public void remove(HobbyModel hobbyModel) {
        baseDao.getHibernateTemplate().delete(hobbyModel);
    }

    @Override
    public List<HobbyModel> pageAll(int pageSize, int pageNo) {
        Session session = baseDao.getHibernateTemplate().getSessionFactory().openSession();
        Query query= session.createQuery("from HobbyModel");
        query.setMaxResults(pageSize);
        query.setFirstResult((pageNo-1)*pageSize);
        List<HobbyModel> list=query.list();
        session.close();
        return list;
    }

    @Override
    public int totalCount() {
        List<HobbyModel> list =(List<HobbyModel>) baseDao.getHibernateTemplate().find("from HobbyModel");
        int totalCount= list.size();
        return totalCount;
    }
}
