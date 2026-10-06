package model;
public class Food {
 private int foodId; private String foodName,category,climate,availability,description; private double price;
 public Food(){}
 public Food(int foodId,String foodName,String category,double price,String climate,String availability,String description){this.foodId=foodId;this.foodName=foodName;this.category=category;this.price=price;this.climate=climate;this.availability=availability;this.description=description;}
 public int getFoodId(){return foodId;} public void setFoodId(int v){foodId=v;} public String getFoodName(){return foodName;} public void setFoodName(String v){foodName=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public double getPrice(){return price;} public void setPrice(double v){price=v;} public String getClimate(){return climate;} public void setClimate(String v){climate=v;} public String getAvailability(){return availability;} public void setAvailability(String v){availability=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
}
