package online.qsx.service;

import online.qsx.model.UserModel;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.List;

public interface UserService extends Service<UserModel>{
    UserModel queryOneById(UserModel userModel);
    List<UserModel> queryOneByName(UserModel userModel);
    Workbook exportContact(String fileName, List<UserModel> users) throws IOException;

}
