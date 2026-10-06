package model;
import java.sql.Timestamp;
public class Cart { private int cartId; private String customerName; private Timestamp createdAt; public Cart(){} public Cart(int id,String name,Timestamp t){cartId=id;customerName=name;createdAt=t;} public int getCartId(){return cartId;} public void setCartId(int v){cartId=v;} public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;} public Timestamp getCreatedAt(){return createdAt;} public void setCreatedAt(Timestamp v){createdAt=v;} }
