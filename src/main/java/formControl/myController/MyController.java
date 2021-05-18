package formControl.myController;

import formControl.Service.UserService;
import formControl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String TrangChu(){
        return "index";
    }

    @PostMapping("/dangky")
    public String dangKy(@ModelAttribute("User") User user){
        userService.save(user);
        return "redirect:/trangChu";
    }
    @GetMapping("/trangChu")
    public String trangChu(Model model){
        model.addAttribute("listUsers", userService.findAll());
        model.addAttribute("countUsers", userService.count());
        return "trangChu";
    }
    @GetMapping("/userDetail")
    public String userDetail(Model model, @RequestParam("id") long id){
        model.addAttribute("userDetail", userService.findById(id));
        return "user";
    }
    @GetMapping("/userSex")
    @ResponseBody
    public List<User> listUserSex(@RequestParam("sex") boolean sex){
        return userService.findBySex(sex);
    }


}
