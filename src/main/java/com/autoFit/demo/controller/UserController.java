package com.autoFit.demo.controller;

import com.autoFit.demo.model.*;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @Autowired
    SparePartService sparePartService;
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;

    @Autowired
    QuoteService quoteService;
    private static final String CART_STATUS_1 = "new";
    private static final String CART_STATUS_2 = "pending";
    private static final String QUOTE_REQ_STATUS_1 = "pending";

    private static final String USER_DASHBOARD_PAGE = "userDashBoard";

    private static final String SPARE_PART_PAGE = "partList1";

    private static final String BRAND_WISE_SPARE_PART_PAGE = "partListByBrand";

    private static final String SPARE_PART_ENTITY_LIST = "sparePartModels";

    private static final String ORDER_ENTITY_LIST = "orderModels";

    private static final String CAR_BRAND = "brand";

    @GetMapping(value = "/dashBoard")
    public ModelAndView userDashBoard(Principal principal) {
        UserModel userModel = userService.findByUserName(principal.getName());
        return new ModelAndView(USER_DASHBOARD_PAGE, "user", userModel);
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
    public ModelAndView newAddress(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("addressEdit");
        AddressModel addressModel = new AddressModel();
        UserModel userModel = userService.get(userId);
        mv.addObject("address", addressModel);
        mv.addObject("user", userModel);
        return mv;
    }

    @PostMapping(value = "/addressSave")
    public ModelAndView saveAddress(AddressModel addressModel, @RequestParam int addressId, @RequestParam int userId, Principal principal) {
        ModelAndView mv = new ModelAndView(USER_DASHBOARD_PAGE);
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
        UserModel user = addressModel.getUser();
        mv.addObject("address", addressModel);
        mv.addObject("user", user);
        return mv;
    }

    @GetMapping(value = "/deleteAddress")
    public String deleteAddress(@RequestParam int addressId, @RequestParam int userId, Model model) {
        addressService.delete(addressId);
        UserModel userModel = userService.get(userId);
        model.addAttribute("user", userModel);
        model.addAttribute("addressModels", userModel.getAddressModelList());
        return "userProfile";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editProfile(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("userInfoEdit");
        UserModel userModel = userService.get(userId);
        mv.addObject("user", userModel);
        return mv;
    }

    @PostMapping(value = "/save/{userId}")
    public String saveUser(UserModel userModel, @PathVariable int userId, Model model) {
        userModel.setActive(true);
        userModel.setRole("ROLE_USER");
        userModel.setId(userId);
        userService.save(userModel);
        model.addAttribute("user", userModel);
        return USER_DASHBOARD_PAGE;
    }

    @GetMapping(value = "/listAll")
    public ModelAndView sparePartList(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView(SPARE_PART_PAGE);
        List<SparePartModel> sparePartModelList = sparePartService.listAll();
        UserModel userModel1 = userService.get(userId);
        mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModelList);
        mv.addObject("user", userModel1);
        return mv;
    }

    @PostMapping(value = "/search1")
    public ModelAndView searchByBrand(@RequestParam String carBrand, @RequestParam int userId) {
        ModelAndView mv = new ModelAndView(BRAND_WISE_SPARE_PART_PAGE);
        List<SparePartModel> sparePartModels = sparePartService.findBySuitedVhl(carBrand);
        UserModel userModel2 = userService.get(userId);
        mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModels);
        mv.addObject(CAR_BRAND, carBrand);
        mv.addObject("user", userModel2);
        return mv;
    }

    @GetMapping(value = "/addToOrder")
    public ModelAndView addToOrder(@RequestParam int partId, @RequestParam int userId, @RequestParam(required = false) String carBrand) {
        ModelAndView mv = new ModelAndView();
        SparePartModel sparePartModel = sparePartService.get(partId);
        UserModel userModel3 = userService.get(userId);
        OrderModel orderModel = new OrderModel();
        mv.addObject("sparePartModel", sparePartModel);
        mv.addObject("user", userModel3);
        mv.addObject("order", orderModel);
        mv.addObject(CAR_BRAND, carBrand);
        mv.setViewName("orderDetails");
        return mv;
    }

    @PostMapping(value = "/submit")
    public ModelAndView orderSubmit(@RequestParam int userId, @RequestParam int partId, OrderModel orderModel, @RequestParam(required = false) String carBrand) {
        ModelAndView mv = new ModelAndView();
        UserModel userModel4 = userService.get(userId);
        SparePartModel sparePartModel = sparePartService.get(partId);
        sparePartModel.setAvlCount(sparePartModel.getAvlCount() - orderModel.getQuantity());
        sparePartService.save(sparePartModel);
        List<SparePartModel> sparePartModelList = sparePartService.listAll();
        CartModel cartModel = new CartModel();
        cartModel.setStatus(CART_STATUS_1);
        cartModel.setUser(userModel4);
        cartService.save(cartModel);
        orderModel.setPartId(partId);
        orderModel.setAmount(orderModel.getQuantity() * sparePartModel.getPrice());
        orderModel.setCart(cartModel);
        orderService.save(orderModel);
        Set<OrderModel> orderModelList = new HashSet<>();
        orderModelList.add(orderModel);
        cartModel.setOrderModelList(orderModelList);
        cartModel.setTotalAmount(cartModel.getTotalAmount() + orderModel.getAmount());
        cartService.save(cartModel);
        if (!carBrand.isEmpty()) {
            List<SparePartModel> sparePartModels = sparePartService.findBySuitedVhl(carBrand);
            mv.setViewName(BRAND_WISE_SPARE_PART_PAGE);
            mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModels);
            mv.addObject("cart", cartModel);
            mv.addObject(CAR_BRAND, carBrand);
        } else {
            mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModelList);
            mv.addObject("cart", cartModel);
            mv.setViewName(SPARE_PART_PAGE);
        }
        return mv;
    }

    @GetMapping(value = "/addToCart")
    public ModelAndView addToCart(@RequestParam int partId, @RequestParam int cartId, @RequestParam(required = false) String carBrand) {
        ModelAndView mv = new ModelAndView("orderDetails");
        SparePartModel sparePartModel = sparePartService.get(partId);
        CartModel cartModel = cartService.get(cartId);
        OrderModel orderModel = new OrderModel();
        mv.addObject("sparePartModel", sparePartModel);
        mv.addObject("cart", cartModel);
        mv.addObject("order", orderModel);
        mv.addObject(CAR_BRAND, carBrand);
        return mv;
    }

    @PostMapping(value = "/saveToCart")
    public ModelAndView saveToCart(@RequestParam int partId, @RequestParam int cartId, OrderModel orderModel, @RequestParam(required = false) String carBrand) {
        ModelAndView mv = new ModelAndView();
        SparePartModel sparePartModel = sparePartService.get(partId);
        sparePartModel.setAvlCount(sparePartModel.getAvlCount() - orderModel.getQuantity());
        sparePartService.save(sparePartModel);
        CartModel cartModel = cartService.get(cartId);
        List<SparePartModel> sparePartModelList = sparePartService.listAll();
        orderModel.setPartId(partId);
        orderModel.setAmount(orderModel.getQuantity() * sparePartModel.getPrice());
        orderModel.setCart(cartModel);
        orderService.save(orderModel);
        Set<OrderModel> orderModels = new HashSet<>();
        orderModels.add(orderModel);
        cartModel.setOrderModelList(orderModels);
        cartModel.setTotalAmount(cartModel.getTotalAmount() + orderModel.getAmount());
        cartService.save(cartModel);
        if (!carBrand.isEmpty()) {
            List<SparePartModel> sparePartModels = sparePartService.findBySuitedVhl(carBrand);
            mv.setViewName(BRAND_WISE_SPARE_PART_PAGE);
            mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModels);
            mv.addObject("cart", cartModel);
            mv.addObject(CAR_BRAND, carBrand);
        } else {
            mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModelList);
            mv.addObject("cart", cartModel);
            mv.setViewName(SPARE_PART_PAGE);
        }
        return mv;
    }

    @PostMapping(value = "/search2")
    public ModelAndView searchByCarBrand(@RequestParam String carBrand, @RequestParam int cartId) {
        ModelAndView mv = new ModelAndView(BRAND_WISE_SPARE_PART_PAGE);
        List<SparePartModel> sparePartModels = sparePartService.findBySuitedVhl(carBrand);
        CartModel cartModel = cartService.get(cartId);
        mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModels);
        mv.addObject(CAR_BRAND, carBrand);
        mv.addObject("cart", cartModel);
        return mv;
    }

    @GetMapping(value = "/list")
    public ModelAndView partList(@RequestParam int cartId) {
        ModelAndView mv = new ModelAndView(SPARE_PART_PAGE);
        List<SparePartModel> sparePartModelList = sparePartService.listAll();
        CartModel cartModel = cartService.get(cartId);
        mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModelList);
        mv.addObject("cart", cartModel);
        return mv;
    }

    @GetMapping(value = "/orderList1")
    public ModelAndView orderList(@RequestParam int cartId) {
        ModelAndView mv = new ModelAndView("orderList1");
        CartModel cartModel = cartService.get(cartId);
        List<OrderModel> orderModels = orderService.OrderModelList(cartId);
        List<Integer> partIdLists = orderService.findPartIds(cartId);
        List<SparePartModel> sparePartModels = new ArrayList<>();
        for (int i : partIdLists) {
            SparePartModel sparePartModel = sparePartService.get(i);
            sparePartModels.add(sparePartModel);
        }
        mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModels);
        mv.addObject(ORDER_ENTITY_LIST, orderModels);
        mv.addObject("cart", cartModel);
        return mv;
    }

    @GetMapping(value = "/confirm")
    public ModelAndView confirmOrder(@RequestParam int cartId) {
        ModelAndView mv = new ModelAndView("orderStatement");
        CartModel cartModel = cartService.get(cartId);
        cartModel.setStatus(CART_STATUS_2);
        cartService.save(cartModel);
        List<OrderModel> orderModels = orderService.OrderModelList(cartId);
        List<Integer> partIdLists = orderService.findPartIds(cartId);
        List<SparePartModel> sparePartModels = new ArrayList<>();
        for (int i : partIdLists) {
            SparePartModel sparePartModel = sparePartService.get(i);
            sparePartModels.add(sparePartModel);
        }
        mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModels);
        mv.addObject(ORDER_ENTITY_LIST, orderModels);
        mv.addObject("cart", cartModel);
        return mv;
    }

    @GetMapping(value = "/newQuote/{cartId}")
    public ModelAndView newQuote(@PathVariable int cartId) {
        ModelAndView mv = new ModelAndView("pricingPage");
        CartModel cartModel = cartService.get(cartId);
        QuoteModel quoteModel = new QuoteModel();
        List<Integer> partIdLists = orderService.findPartIds(cartId);
        List<SparePartModel> sparePartModels = new ArrayList<>();
        for (int i : partIdLists) {
            SparePartModel sparePartModel = sparePartService.get(i);
            sparePartModels.add(sparePartModel);
        }
        mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModels);
        mv.addObject("cartModel", cartModel);
        mv.addObject("quote", quoteModel);
        return mv;
    }

    @PostMapping(value = "/submitQuote")
    public ModelAndView quoteSubmission(@RequestParam int cartId, QuoteModel quoteModel) {
        ModelAndView mv = new ModelAndView("success2");
        CartModel cartModel = cartService.get(cartId);
        Set<QuoteModel> quoteModelSet = new HashSet<>();
        quoteModel.setStatus(QUOTE_REQ_STATUS_1);
        quoteModel.setCart(cartModel);
        quoteService.save(quoteModel);
        quoteModelSet.add(quoteModel);
        cartModel.setQuoteModelList(quoteModelSet);
        cartModel.setStatus(CART_STATUS_2);
        cartService.save(cartModel);
        mv.addObject("message", " Hey User " + cartModel.getUser().getFirstName() + " we will get back to you as soon as possible");
        return mv;
    }

    @GetMapping(value = "/userTransactions")
    public ModelAndView userTransactions(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("userTransactions");
        List<CartModel> userCartList = cartService.findUserCartList(userId);
        mv.addObject("userCartList", userCartList);
        mv.addObject("userId", userId);
        return mv;
    }

    @GetMapping(value = "/quoteList")
    public ModelAndView quoteList(@RequestParam int cartId) {
        ModelAndView mv = new ModelAndView("quoteList");
        List<QuoteModel> quoteList = quoteService.getQuoteList(cartId);
        mv.addObject("quoteList", quoteList);
        return mv;
    }

    @GetMapping(value = "/orderList3")
    public ModelAndView orderList3(@RequestParam int cartId) {
        ModelAndView mv = new ModelAndView("orderList3");
        CartModel cartModel = cartService.get(cartId);
        List<OrderModel> orderModels = orderService.OrderModelList(cartId);
        List<Integer> partIdLists = orderService.findPartIds(cartId);
        List<SparePartModel> sparePartModels = new ArrayList<>();
        for (int i : partIdLists) {
            SparePartModel sparePartModel = sparePartService.get(i);
            sparePartModels.add(sparePartModel);
        }
        mv.addObject(SPARE_PART_ENTITY_LIST, sparePartModels);
        mv.addObject(ORDER_ENTITY_LIST, orderModels);
        mv.addObject("cart", cartModel);
        return mv;
    }


}
