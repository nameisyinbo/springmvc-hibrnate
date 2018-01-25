package online.qsx.service.impl;

import online.qsx.dao.HobbyDao;
import online.qsx.model.HobbyModel;
import online.qsx.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("hobbyServiceImpl")
public class HobbyServiceImpl implements HobbyService{
    @Autowired
    private HobbyDao hobbyDao;
    @Override
    public HobbyModel queryById(HobbyModel hobbyModel) {
        return hobbyDao.queryById(hobbyModel);
    }

    @Override
    public List<HobbyModel> findAll() {
        return hobbyDao.findAll();
    }

    @Override
    public void save(HobbyModel hobbyModel) {
        hobbyDao.save(hobbyModel);
    }

    @Override
    public void edit(HobbyModel hobbyModel) {
        hobbyDao.edit(hobbyModel);
    }

    @Override
    public void remove(HobbyModel hobbyModel) {
        hobbyDao.remove(hobbyModel);
    }

    @Override
    public List<HobbyModel> pageAll(int pageSize, int pageNo) {
        return hobbyDao.pageAll(pageSize,pageNo);
    }

    @Override
    public int totalCount() {
        return hobbyDao.totalCount();
    }
}
