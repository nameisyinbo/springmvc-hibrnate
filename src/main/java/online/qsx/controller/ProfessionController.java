package online.qsx.controller;

import online.qsx.model.Page;
import online.qsx.model.ProfessionModel;
import online.qsx.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("profession")
public class ProfessionController {
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private Page page;
    @RequestMapping("list")
    public String page(Model model){
        int pageNo=1;
        page.setPageNo(pageNo);
        page.setTotalCount(professionService.totalCount());
        List<ProfessionModel> list=professionService.pageAll(page.getPageSize(),page.getPageNo());
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        return "profession/professionList";
    }
    @RequestMapping("to_save")
    public String to_save(){
        return "profession/professionSave";
    }
    @RequestMapping("save")
    public String save(ProfessionModel professionModel){
        professionService.save(professionModel);
        return "forward:list";
    }
    @RequestMapping("delete")
    public String delete(ProfessionModel professionModel){
        professionService.remove(professionModel);
        return "forward:list";
    }
    @RequestMapping("to_update")
    public String to_update(Model model,ProfessionModel professionModel){
        ProfessionModel professions= professionService.queryById(professionModel);
        model.addAttribute("profession",professions);
        return "profession/professionUpdate";
    }
    @RequestMapping("update")
    public String update(ProfessionModel professionModel){
        professionService.edit(professionModel);
        return "forward:list";
    }
}
