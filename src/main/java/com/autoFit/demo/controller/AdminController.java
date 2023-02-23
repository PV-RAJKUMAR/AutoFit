package com.autoFit.demo.controller;

import com.autoFit.demo.model.*;
import com.autoFit.demo.repository.OrderRepository;
import com.autoFit.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @Autowired
    CartService cartService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SparePartService sparePartService;

    @Autowired
    QuoteService quoteService;


    private static final String CART_STATUS_3 = "approved";

    private static final String QUOTE_REQ_STATUS_2 = "sanctioned";

    private static final String QUOTE_REQ_STATUS_3 = "rejected";

    @GetMapping(value = "/dashBoard")
    public ModelAndView userDashBoard(Principal principal) {
        UserModel userModel = userService.findByUserName(principal.getName());
        return new ModelAndView("adminDashBoard", "user", userModel);
    }

    @GetMapping(value = "/profile")
    public ModelAndView userProfile(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("userProfile");
        UserModel userModel = userService.get(userId);
        Set<AddressModel> addressModelList = userModel.getAddressModelList();
        mv.addObject("user", userModel);
        mv.addObject("addressModels", addressModelList);
        return mv;
    }

    @GetMapping(value = "/newAddress")
    public ModelAndView addAddress(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("addressEdit");
        AddressModel addressModel = new AddressModel();
        UserModel userModel = userService.get(userId);
        mv.addObject("address", addressModel);
        mv.addObject("user", userModel);
        return mv;
    }

    @PostMapping(value = "/addressSave")
    public ModelAndView saveAddress(AddressModel addressModel, @RequestParam int addressId, @RequestParam int userId, Principal principal) {
        ModelAndView mv = new ModelAndView("adminDashBoard");
        addressModel.setId(addressId);
        UserModel userModel = userService.get(userId);
        addressModel.setUser(userModel);
        addressService.save(addressModel);
        Set<AddressModel> addressModelList = new HashSet<>();
        addressModelList.add(addressModel);
        userModel.setAddressModelList(addressModelList);
        userService.save(userModel);
        mv.addObject("user", userService.findByUserName(principal.getName()));
        return mv;
    }

    @GetMapping(value = "/addressEdit")
    public ModelAndView editAddress(@RequestParam int addressId) {
        ModelAndView mv = new ModelAndView("addressEdit");
        AddressModel addressModel = addressService.get(addressId);
        UserModel userModel = addressModel.getUser();
        mv.addObject("address", addressModel);
        mv.addObject("user", userModel);
        return mv;
    }

    @GetMapping(value = "/deleteAddress")
    public String delete(@RequestParam int addressId, @RequestParam int userId, Model model) {
        addressService.delete(addressId);
        UserModel userModel = userService.get(userId);
        model.addAttribute("user", userModel);
        model.addAttribute("addressModels", userModel.getAddressModelList());
        return "userProfile";
    }

    @GetMapping(value = "/inactiveUserList")
    public String inactiveUserList(Model model) {
        List<UserModel> inactiveUsers = userService.findInactiveUsers();
        model.addAttribute("inactiveUserModels", inactiveUsers);
        return "inactiveUserList";
    }

    @GetMapping(value = "/approve")
    public String approve(@RequestParam int userId) {
        UserModel userModel = userService.get(userId);
        userModel.setActive(true);
        userService.save(userModel);
        return "redirect:inactiveUserList";
    }

    @GetMapping(value = "/reject")
    public String reject(@RequestParam int userId) {
        List<Integer> addressIdList = addressService.findAddressId(userId);

        for (int addressId : addressIdList) {
            addressService.delete(addressId);
        }
        userService.delete(userId);
        return "redirect:inactiveUserList";
    }

    @GetMapping(value = "/listForApproval")
    public String listForApproval(Model model) {
        List<CartModel> cartModelList = cartService.getPendingStatusList();
        model.addAttribute("cartModels", cartModelList);
        return "listForApproval";
    }

    @GetMapping(value = "/orders/{cartId}")
    public ModelAndView orderDetails(@PathVariable int cartId) {
        ModelAndView mv = new ModelAndView("orderList2");
        CartModel cartModel = cartService.get(cartId);
        List<OrderModel> orderModels = orderRepository.OrderModelList(cartId);
        List<Integer> partIdLists = orderRepository.findPartIds(cartId);
        List<SparePartModel> sparePartModels = new ArrayList<>();
        for (int i : partIdLists) {
            SparePartModel sparePartModel = sparePartService.get(i);
            sparePartModels.add(sparePartModel);
        }
        mv.addObject("sparePartModels", sparePartModels);
        mv.addObject("orderModels", orderModels);
        mv.addObject("cart", cartModel);
        return mv;
    }

    @GetMapping(value = "/approveOrder/{cartId}")
    public String approveOrder(@PathVariable int cartId) {
        CartModel cartModel = cartService.get(cartId);
        cartModel.setStatus(CART_STATUS_3);
        cartService.save(cartModel);
        return "redirect:/admin/listForApproval";
    }

    @GetMapping(value = "/rejectOrder/{cartId}")
    public String rejectOrder(@PathVariable int cartId) {
        CartModel cartModel = cartService.get(cartId);
        Set<OrderModel> orderModels = cartModel.getOrderModelList();
        for (OrderModel orderModel : orderModels) {
            int partId = orderModel.getPartId();
            SparePartModel sparePartModel = sparePartService.get(partId);
            sparePartModel.setAvlCount(orderModel.getQuantity() + sparePartModel.getAvlCount());
            sparePartService.save(sparePartModel);
            orderRepository.delete(orderModel);
        }
        cartService.delete(cartId);
        return "redirect:/admin/listForApproval";
    }

    @GetMapping(value = "/quoteList")
    public String quoteList(Model model) {
        List<QuoteModel> quoteModelList = quoteService.findPendingQuoteModelList();
        model.addAttribute("quoteModels", quoteModelList);
        return "userQuoteList";
    }

    @GetMapping(value = "/sanctionQuote/{quoteId}")
    public String sanctionQuote(@PathVariable int quoteId, Model model) {
        QuoteModel quoteModel = quoteService.get(quoteId);
        quoteModel.setStatus(QUOTE_REQ_STATUS_2);
        quoteService.save(quoteModel);
        CartModel cartModel = cartService.get(quoteModel.getCart().getId());
        cartModel.setApprovedAmount(quoteModel.getReqQuote());
        cartModel.setStatus(CART_STATUS_3);
        cartService.save(cartModel);
        model.addAttribute("quoteId", quoteId);
        return "redirect:/admin/quoteList";
    }

    @GetMapping(value = "/refuseQuote/{quoteId}")
    public String refuseQuote(@PathVariable int quoteId, Model model) {
        QuoteModel quoteModel = quoteService.get(quoteId);
        quoteModel.setStatus(QUOTE_REQ_STATUS_3);
        quoteService.save(quoteModel);
        CartModel cartModel = cartService.get(quoteModel.getCart().getId());
        Set<OrderModel> orderModels = cartModel.getOrderModelList();
        for (OrderModel orderModel : orderModels) {
            int partId = orderModel.getPartId();
            SparePartModel sparePartModel = sparePartService.get(partId);
            sparePartModel.setAvlCount(orderModel.getQuantity() + sparePartModel.getAvlCount());
            sparePartService.save(sparePartModel);
        }
        model.addAttribute("quoteId", quoteId);
        return "redirect:/admin/quoteList";
    }

    @GetMapping(value = "/newEntry")
    public ModelAndView newEntry() {
        ModelAndView mv = new ModelAndView("newSparePartEntry");
        SparePartModel sparePartModel = new SparePartModel();
        mv.addObject("sparePartModel", sparePartModel);
        return mv;
    }

    @PostMapping(value = "/save")
    public String saveEntry(SparePartModel sparePartModel) {
        sparePartService.save(sparePartModel);
        return "redirect:newEntry";
    }
}
