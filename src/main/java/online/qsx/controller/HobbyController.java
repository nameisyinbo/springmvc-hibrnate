package online.qsx.controller;

import online.qsx.model.HobbyModel;
import online.qsx.model.Page;
import online.qsx.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("hobby")
public class HobbyController {
    @Autowired
    private HobbyService hobbyService;
    @Autowired
    private Page page;


    @RequestMapping("list")
    public String hobby(Model model){
        int pageNo=1;
        page.setPageNo(pageNo);
        page.setTotalCount(hobbyService.totalCount());
        List<HobbyModel> list=hobbyService.pageAll(page.getPageSize(),page.getPageNo());
        model.addAttribute("list",list);
        model.addAttribute("page",page);
      return "hobby/hobbylist";
    }
    @RequestMapping("to_save")
    public String to_save(){
        return "hobby/hobbySave";
    }
    @RequestMapping("save")
    public String save(HobbyModel hobbyModel){
        hobbyService.save(hobbyModel);
        return "forward:list";
    }
    @RequestMapping("delete")
    public String delete(HobbyModel hobbyModel){
        hobbyService.remove(hobbyModel);
        return "forward:list";
    }
    @RequestMapping("to_update")
    public String to_update(Model model,HobbyModel hobbyModel){
       HobbyModel hobbys= hobbyService.queryById(hobbyModel);
       model.addAttribute("hobby",hobbys);
       return "hobby/hobbyUpdate";
    }
    @RequestMapping("update")
    public String update(HobbyModel hobbyModel){
        hobbyService.edit(hobbyModel);
        return "forward:list";
    }
}
