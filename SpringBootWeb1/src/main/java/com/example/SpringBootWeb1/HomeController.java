package com.example.SpringBootWeb1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//    @RequestMapping("/home")
//    public String home() {
//        System.out.println("Controller called...");
//        return "index";
//    }

//    @RequestMapping("/add")
//    public String add(HttpServletRequest req, HttpSession session) {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1+num2;
//        session.setAttribute("result", result);
//        System.out.println("Result is " + result);
//        return "result.jsp";
//    }
//    @RequestMapping("/add")
//    public String add(int num1, int num2, Model model) {
//        int result = num1+num2;
//        model.addAttribute("result", result);
//        return "result";
//    }

//    @RequestMapping("/add")
//    public ModelAndView add(int num1, int num2, ModelAndView model) {
//        int result = num1+num2;
//        model.addObject("result",result);
//        model.setViewName("result");
//        return model;
//    }

//    @RequestMapping("addAlien")
//    public ModelAndView addAlien(@RequestParam("aid") int aid,@RequestParam("aname") String aname, ModelAndView model) {
//        Alien alien = new Alien();
//        alien.setAid(aid);
//        alien.setAname(aname);
//        model.addObject("alien", alien);
//        model.setViewName("result");
//        return model;
//    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute Alien alien) {

        return "result";
    }
}
