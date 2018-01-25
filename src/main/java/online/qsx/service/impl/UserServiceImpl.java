package online.qsx.service.impl;

import online.qsx.dao.UserDao;
import online.qsx.model.UserModel;
import online.qsx.service.UserService;
import online.qsx.util.Poi4Excel;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserModel queryOneById(UserModel userModel) {
        return userDao.queryOneById(userModel);
    }

    @Override
    public List<UserModel> queryOneByName(UserModel userModel) {

        return userDao.queryOneByName(userModel);
    }


    @Override
    public List<UserModel> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserModel userModel) {
        userDao.save(userModel);
    }

    @Override
    public void edit(UserModel userModel) {
        userDao.edit(userModel);
    }

    @Override
    public void remove(UserModel userModel) {
        userDao.remove(userModel);
    }

    @Override
    public List<UserModel> pageAll(int pageSize, int pageNo) {
        return userDao.pageAll(pageSize, pageNo);
    }

    @Override
    public int totalCount() {
        return userDao.totalCount();
    }


    /**
     * Excel导出方法
     *
     * @param users 联系人集合
     * @return Workbook 工作文档对象
     */
    public Workbook exportContact(String fileName, List<UserModel> users) throws IOException {
        // excel格式是.xlsx
        String fileType = "xlsx";
        // 导出excel需要的数据格式
        ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
        // 导出excel第一行标题数据
        ArrayList<Object> listTitle = new ArrayList<Object>();
        // 存放标题顺序
        listTitle.add("用户名称");
        listTitle.add("职业");
        listTitle.add("邮箱");
        listTitle.add("性别");
        listTitle.add("生日");
        listTitle.add("爱好");
        listTitle.add("创建时间");
        // 将标题数据放在excel数据
        list.add(listTitle);

        for (int i = 0; i < users.size(); i++) {
            // 存放excel内容数据
            ArrayList<Object> listBody = new ArrayList<Object>();
            // 存放数据顺序和存放标题顺序对应
            listBody.add(users.get(i).getUserName());
            listBody.add(users.get(i).getProfession());
            listBody.add(users.get(i).getEmail());
            listBody.add(users.get(i).getSex());
            listBody.add(users.get(i).getBirthdate());
            listBody.add(users.get(i).getHobby());
            listBody.add(users.get(i).getCreateDate());
            list.add(listBody);
        }

        // 调用 Poi4Excel 公共类的导出方法
        return Poi4Excel.writer(fileName, fileType, list);
    }

}


