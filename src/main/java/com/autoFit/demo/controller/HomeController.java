package com.autoFit.demo.controller;

import com.autoFit.demo.model.AddressModel;
import com.autoFit.demo.model.UserModel;
import com.autoFit.demo.service.AddressService;
import com.autoFit.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @GetMapping(value = "/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping(value = "/403")
    public ModelAndView accessDenied(Principal user) {

        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", You can not access this page!");
        } else {
            model.addObject("msg",
                    "You can not access this page!");
        }

        model.setViewName("403");
        return model;
    }

    @GetMapping(value = "/regPage")
    public String regPage(Model model) {
        model.addAttribute("user", new UserModel());
        model.addAttribute("address", new AddressModel());
        return "regPage";
    }

    @GetMapping(value = "/save")
    public String save(UserModel userModel, AddressModel addressModel, Model model) {
        userModel.setRole("ROLE_USER");
        userService.save(userModel);
        addressModel.setUser(userModel);
        addressService.save(addressModel);
        Set<AddressModel> addressModelList = new HashSet<>();
        addressModelList.add(addressModel);
        userModel.setAddressModelList(addressModelList);
        userService.save(userModel);
        model.addAttribute("message", " Hi " + userModel.getFirstName() + userModel.getLastName() + " Your request is added...Kindly wait for Approval ");
        return "success";
    }
}
