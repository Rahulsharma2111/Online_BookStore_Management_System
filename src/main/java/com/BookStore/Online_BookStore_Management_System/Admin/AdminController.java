package com.BookStore.Online_BookStore_Management_System.Admin;

import com.BookStore.Online_BookStore_Management_System.Order.Order;
import com.BookStore.Online_BookStore_Management_System.Order.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private OrderServices orderServices;

    @GetMapping("/")
    @ResponseBody
    public List<Order> getAllOrderByStatus(){
        return this.orderServices.getAllOrder();
    }

//    @GetMapping("/dashboard")
//    public String getDashboard(){
//        return this.adminService.adminDashboard();
//    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("ms", "this is message text");
        return "adminDashboard";
    }

}
