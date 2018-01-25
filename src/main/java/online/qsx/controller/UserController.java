package online.qsx.controller;

import online.qsx.model.*;
import online.qsx.service.HobbyService;
import online.qsx.service.LoginService;
import online.qsx.service.ProfessionService;
import online.qsx.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private Page page;
    @Autowired
    private HobbyService hobbyService;
    @Autowired
    private ProfessionService professionService;
    //localhost:8080/user/to_login
    @RequestMapping("to_login")
    public String to_login(){
        return "login";
    }
    /**
     * 登录操作
     * @param loginModel
     * @param model
     * @return
     */
    @RequestMapping("do_login")
    public String do_login(LoginModel loginModel, Model model, HttpServletRequest request){
        LoginModel login=loginService.queryByName(loginModel);
        if (login.equals(loginModel)){
            request.getSession().setAttribute("loginModel",login);
            System.out.println("成功");
            model.addAttribute("user",login);
            return "forward:to_index";
        }else {
            System.out.println("失败");
            request.getSession().setAttribute("loginModel",null);
            model.addAttribute("mess","输入有误，登录失败");
            return "forward:to_login";
        }
    }
    //localhost:8080/user/to_index
    @RequestMapping("to_index")
    public String index(){
        return "index";
    }
    /*
     * 解决Date格式转换问题Date to String
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /**
     * 分页查询方法
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String page(Model model){
        int pageNo=1;
        page.setPageNo(pageNo);
        page.setTotalCount(userService.totalCount());
        List<UserModel> list=userService.pageAll(page.getPageSize(),page.getPageNo());

        model.addAttribute("list",list);
        model.addAttribute("page",page);
        return "user/list";
    }

    /**
     * 去添加页面
     * @param model
     * @return
     */
    @RequestMapping("form")
    public String to_add(Model model){
        List<HobbyModel> hobby=hobbyService.findAll();
        List<ProfessionModel> profession=professionService.findAll();
        model.addAttribute("profession",profession);
        model.addAttribute("hobby",hobby);
        return "user/form";
    }

    /**
     * 执行添加方法
     * @param userModel
     * @return
     */
    @RequestMapping("save")
    public String save(UserModel userModel){
        userService.save(userModel);
        return "forward:list";
    }

    /**
     * 删除后返回分页查询方法
     * @param userModel
     * @return
     */
    @RequestMapping("remove")
    public String delete(UserModel userModel){
        userService.remove(userModel);
        return "forward:list";
    }

    /**
     * 通过用户进行查询
     * @param model
     * @param userModel
     * @return
     */
    @RequestMapping("query")
    public String query(Model model,UserModel userModel){
        List list= userService.queryOneByName(userModel);
       if(list.size()==0){
           System.out.println("查无此人！");
           model.addAttribute("mess","请输入正确用户名");
           return "forward:list";
       }else {
           model.addAttribute("obj", list);
           return "user/userList";
       }
    }
    @RequestMapping("update")
    public String to_edit(UserModel userModel,Model model){
        UserModel users=userService.queryOneById(userModel);
        model.addAttribute("user",users);
        return "user/userUpdate";
    }
    @RequestMapping("do_update")
    public String do_edit(UserModel userModel){
        userService.edit(userModel);
        return "forward:list";
    }

    public String verify(UserModel userModel,Model model){
       UserModel user=(UserModel) userService.queryOneByName(userModel);
       return "";
    }

    /**
     * 导出所有联系人到excel文件
     *
     * @param fileName
     *            文件名称
     *
     * @return
     */
    @RequestMapping(value = "/export/{fileName}", method = RequestMethod.GET)
    public void exportContact(Model model, @PathVariable String fileName, HttpServletResponse response) throws IOException{
            // 获取所有需要导出的联系人信息
            System.out.println("开始导出了");
            List<UserModel> users = userService.findAll();
            // 将联系人列表数据转换成工作文档对象
            Workbook workbook = userService.exportContact(fileName, users);

            // 设置发送到客户端的响应的内容类型
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");

            // 为了解决中文名称乱码问题
            String finalFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
            response.setHeader("Content-disposition", "attachment;filename=" + finalFileName + ".xlsx");

            // 获取输出流
            OutputStream ouputStream = new BufferedOutputStream(response.getOutputStream());
            // 下载文件(写输出流)
            workbook.write(ouputStream);
            // 刷新流
            ouputStream.flush();
            // 关闭流
            ouputStream.close();
    }
}
