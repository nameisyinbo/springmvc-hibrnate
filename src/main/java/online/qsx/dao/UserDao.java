package online.qsx.dao;

import online.qsx.model.UserModel;

import java.util.List;

public interface UserDao extends Dao<UserModel>{
    UserModel queryOneById(UserModel userModel);
    List<UserModel> queryOneByName(UserModel userModel);
}
