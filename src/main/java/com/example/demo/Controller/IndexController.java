package com.example.demo.Controller;

import com.example.demo.Bean.Account;
import com.example.demo.Bean.City;
import com.example.demo.service.AccountService;
import com.example.demo.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {
    /**
     * 来登录页
     *
     * @return
     */
//    @Autowired
//    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountService accountService;
    @Autowired
    CityService cityService;
    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return  cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/qiu")
    public Account getById(@RequestParam("id") Long id){
        return accountService.getById(id);
    }

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(String username,String password,HttpSession session,Model model) {
            if(StringUtils.hasLength(username)&&"123456".equals(password)){
                session.setAttribute("loginuser",username);
                return "redirect:/main.html";
            }else {
                model.addAttribute("msg","账号密码错误");
                return "login";
            }

        }


    /**
     * 去主页面
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model) {
        Object loginuser = session.getAttribute("loginuser");
        if(loginuser!=null){
            return "main";
        }else {
            model.addAttribute("msg","请重新登入");
            return "login";
        }
    }
}
