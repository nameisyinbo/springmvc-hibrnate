package online.qsx.dao.impl;

import online.qsx.dao.ProfessionDao;
import online.qsx.model.ProfessionModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ProfessionDaoImpl implements ProfessionDao{
    @Autowired
    private BaseDao baseDao;

    @Override
    public ProfessionModel queryById(ProfessionModel professionModel) {
        return baseDao.getHibernateTemplate().get(ProfessionModel.class,professionModel.getId());
    }

    @Override
    public List<ProfessionModel> findAll() {
        return (List<ProfessionModel>) baseDao.getHibernateTemplate().find("from ProfessionModel");
    }

    @Override
    public void save(ProfessionModel professionModel) {
        professionModel.setCreateDate(new Date());
        baseDao.getHibernateTemplate().save(professionModel);
    }

    @Override
    public void edit(ProfessionModel professionModel) {
        professionModel.setCreateDate(new Date());
        baseDao.getHibernateTemplate().update(professionModel);
    }

    @Override
    public void remove(ProfessionModel professionModel) {
        baseDao.getHibernateTemplate().delete(professionModel);
    }

    @Override
    public List<ProfessionModel> pageAll(int pageSize, int pageNo) {
       Session session= baseDao.getHibernateTemplate().getSessionFactory().openSession();
       Query query= session.createQuery("from ProfessionModel");
       query.setMaxResults(pageSize);
       query.setFirstResult((pageNo-1)*pageSize);
       List<ProfessionModel> list=query.list();
        return list;
    }

    @Override
    public int totalCount() {
        List<ProfessionModel> list=(List<ProfessionModel>)baseDao.getHibernateTemplate().find("from ProfessionModel");
        int totalCount =list.size();
        return totalCount;
    }

}
