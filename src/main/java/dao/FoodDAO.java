package dao;
import database.DBConnection; import model.Food; import org.springframework.stereotype.Repository; import java.sql.*; import java.util.*;
@Repository public class FoodDAO {
 public List<Food> getAllFoods(){return query("SELECT * FROM Food",null);}
 public List<Food> getFoodsByClimate(String c){return query("SELECT * FROM Food WHERE LOWER(TRIM(climate))=LOWER(TRIM(?))",c);}
 public List<Food> searchFoods(String s){String sql="SELECT * FROM Food WHERE food_name LIKE ? OR category LIKE ? OR climate LIKE ? OR description LIKE ?";return search(sql,s);}
 private List<Food> search(String sql,String s){List<Food> l=new ArrayList<>();try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){String k="%"+s+"%";for(int i=1;i<=4;i++)p.setString(i,k);try(ResultSet r=p.executeQuery()){while(r.next())l.add(map(r));}}catch(Exception e){e.printStackTrace();}return l;}
 private List<Food> query(String sql,String v){List<Food> l=new ArrayList<>();try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){if(v!=null)p.setString(1,v);try(ResultSet r=p.executeQuery()){while(r.next())l.add(map(r));}}catch(Exception e){e.printStackTrace();}return l;}
 public Food getFoodById(int id){try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM Food WHERE food_id=?")){p.setInt(1,id);try(ResultSet r=p.executeQuery()){if(r.next())return map(r);}}catch(Exception e){e.printStackTrace();}return null;}
 private Food map(ResultSet r)throws SQLException{Food f=new Food();f.setFoodId(r.getInt("food_id"));f.setFoodName(r.getString("food_name"));f.setCategory(r.getString("category"));f.setPrice(r.getDouble("price"));f.setClimate(r.getString("climate"));f.setAvailability(r.getString("availability"));f.setDescription(r.getString("description"));return f;}
}
