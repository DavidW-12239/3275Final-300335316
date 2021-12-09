package final123;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface {
    Connection con;

    public DatabaseService(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Category cat) throws ClassNotFoundException, SQLException {
        String query1 = "insert into category values(?,?)";
        PreparedStatement query = con.prepareStatement(query1);
        query.setString(1, cat.getCatCode());
        query.setString(2, cat.getCatDesc());
        query.executeUpdate();
    }

    @Override
    public Category edit(Category cat, String catCode) throws ClassNotFoundException, SQLException {
        PreparedStatement query = con.prepareStatement("Update category set catcode=?, catdesc=? where catcode = ?");
        query.setString(1, cat.getCatCode());
        query.setString(2, cat.getCatDesc());
        query.setString(3, catCode);
        query.executeUpdate();
        return cat;
    }

    @Override
    public void delete(String catCode) throws SQLException, ClassNotFoundException {
        String query1 = "delete from category where catcode = ?";
        PreparedStatement query = con.prepareStatement(query1);
        query.setString(1, catCode);
        query.executeUpdate();
    }

    @Override
    public Category search(String catCode) throws SQLException, ClassNotFoundException {
        String query1 = "Select * from category where catcode = ?";
        PreparedStatement query = con.prepareStatement(query1, 1004, 1007);
        query.setString(1, catCode);
        ResultSet rs = query.executeQuery();
        if (!rs.first()) {
            return null;
        } else {
            Category obj1 =  new Category(rs.getString("catCode"), rs.getString("catDesc"));
            return obj1;
        }
    }

    @Override
    public List<Category> display() throws SQLException, ClassNotFoundException {
        List<Category> catList = new ArrayList<Category>();
        String query1 = "Select * from category";
        PreparedStatement query = con.prepareStatement(query1);
        ResultSet rs = query.executeQuery();

        Category obj1;

        while (rs.next()){
            obj1 = new Category(rs.getString("catCode"), rs.getString("catDesc"));
            catList.add(obj1);
        }
        return catList;
    }

    @Override
    public List<Items> display2(String catCode) throws SQLException, ClassNotFoundException {
        List<Items> itemsList = new ArrayList<Items>();
        String query1 = "Select itemcode, itemdesc from item where catcode = ?";
        PreparedStatement query = con.prepareStatement(query1);
        query.setString(1, catCode);
        ResultSet rs = query.executeQuery();

        Items obj2;
        while (rs.next()){
            obj2 = new Items(rs.getString("itemCode"), rs.getString("itemDesc"));
            itemsList.add(obj2);
        }
        return itemsList;
    }


}
