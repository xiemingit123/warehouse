package cn.kgc.controller;

import cn.kgc.domain.Takeout;
import cn.kgc.service.TakeOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class TakeOutController {
    @Autowired
    private TakeOutService takeOutService;


    @RequestMapping("insertIntoTakeOut")
    public ModelAndView insertIntoTakeOut(Integer id, String quantity, String handler, ModelAndView mv){
        Date now=new Date();
        Takeout takeout=new Takeout();
        takeout.setQuantity(Integer.parseInt(quantity));
        takeout.setHandler(handler);
        takeout.setOutdate(now);
        takeout.setProductid(id);
        int i = takeOutService.insertIntoTakeOut(takeout);
        if (i>0){
            mv.addObject("flag",1);
        }else {
            mv.addObject("flag",0);
        }
        mv.setViewName("main");
        return mv;
    }
}
