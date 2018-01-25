package online.qsx.service.impl;

import online.qsx.dao.ProfessionDao;
import online.qsx.model.ProfessionModel;
import online.qsx.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessionServiceImpl implements ProfessionService{
    @Autowired
    private ProfessionDao professionDao;
    @Override
    public ProfessionModel queryById(ProfessionModel professionModel) {
        return professionDao.queryById(professionModel);
    }

    @Override
    public List<ProfessionModel> findAll() {
        return professionDao.findAll();
    }

    @Override
    public void save(ProfessionModel professionModel) {
        professionDao.save(professionModel);
    }

    @Override
    public void edit(ProfessionModel professionModel) {
        professionDao.edit(professionModel);
    }

    @Override
    public void remove(ProfessionModel professionModel) {
        professionDao.remove(professionModel);
    }

    @Override
    public List<ProfessionModel> pageAll(int pageSize, int pageNo) {
        return professionDao.pageAll(pageSize,pageNo);
    }

    @Override
    public int totalCount() {
        return professionDao.totalCount();
    }
}
