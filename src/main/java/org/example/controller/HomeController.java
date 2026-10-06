package org.example.controller;
import dao.*; import model.*; import org.example.service.CashfreePaymentService; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import java.util.*;
@Controller public class HomeController {
 private final FoodDAO foodDAO; private final CartDAO cartDAO; private final OrderDAO orderDAO; private final ReviewDAO reviewDAO; private final CashfreePaymentService paymentService; private int cartId=1;
 public HomeController(FoodDAO f,CartDAO c,OrderDAO o,ReviewDAO r,CashfreePaymentService p){foodDAO=f;cartDAO=c;orderDAO=o;reviewDAO=r;paymentService=p;}
 @GetMapping("/") public String home(Model m){m.addAttribute("foods",foodDAO.getAllFoods());return "index";}
 @GetMapping("/menu") public String menu(@RequestParam(required=false)String climate,@RequestParam(required=false)String search,Model m){List<Food> foods=(search!=null&&!search.isBlank())?foodDAO.searchFoods(search):(climate!=null&&!climate.isBlank()?foodDAO.getFoodsByClimate(climate):foodDAO.getAllFoods());Map<Integer,List<Review>> map=new HashMap<>();for(Food f:foods)map.put(f.getFoodId(),reviewDAO.getReviewsByFoodId(f.getFoodId()));m.addAttribute("foods",foods);m.addAttribute("reviewsMap",map);m.addAttribute("search",search);m.addAttribute("cartCount",cartDAO.getCartCount(cartId));return "menu";}
 @PostMapping("/cart/add") public String add(@RequestParam int foodId){cartDAO.addToCart(cartId,foodId);return "redirect:/cart";}
 @GetMapping("/cart") public String cart(Model m){m.addAttribute("items",cartDAO.getCartItems(cartId));m.addAttribute("total",cartDAO.getCartTotal(cartId));return "cart";}
 @PostMapping("/cart/increase") public String inc(@RequestParam int cartItemId){cartDAO.increaseQuantity(cartItemId);return "redirect:/cart";}
 @PostMapping("/cart/decrease") public String dec(@RequestParam int cartItemId){cartDAO.decreaseQuantity(cartItemId);return "redirect:/cart";}
 @PostMapping("/cart/remove") public String rem(@RequestParam int cartItemId){cartDAO.removeItem(cartItemId);return "redirect:/cart";}
 @PostMapping("/buy-now") public String buy(@RequestParam int foodId){cartDAO.addToCart(cartId,foodId);return "redirect:/checkout";}
 @GetMapping("/checkout") public String checkout(Model m){m.addAttribute("total",cartDAO.getCartTotal(cartId));return "checkout";}
 @PostMapping("/checkout") public String payment(@RequestParam String customerName,@RequestParam String phoneNumber,Model m){double amount=cartDAO.getCartTotal(cartId);String oid="BB-"+System.currentTimeMillis();String response=paymentService.createOrder(oid,amount,customerName,phoneNumber,"http://localhost:8080/ByteBites/payment-success");String session=extract(response,"payment_session_id");m.addAttribute("cashfreeOrderId",oid);m.addAttribute("amount",amount);m.addAttribute("paymentSessionId",session);return "payment";}
 @GetMapping("/payment-success") public String success(@RequestParam(required=false)String order_id,Model m){m.addAttribute("orderId",order_id==null?"Pending":order_id);return "order-success";}
 @PostMapping("/review") public String review(@ModelAttribute Review r){reviewDAO.addReview(r);return "redirect:/menu";}
 private String extract(String json,String key){String t="\""+key+"\"";int k=json.indexOf(t),c=json.indexOf(':',k),a=json.indexOf('"',c+1),b=json.indexOf('"',a+1);return k<0||a<0||b<0?"":json.substring(a+1,b);}
}
