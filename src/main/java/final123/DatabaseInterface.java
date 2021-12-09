package final123;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {
    public void add(Category cat) throws ClassNotFoundException, SQLException;
    public Category edit(Category cat, String catCode) throws ClassNotFoundException, SQLException;
    public void delete(String catCode) throws SQLException, ClassNotFoundException;
    public Category search(String catCode) throws SQLException, ClassNotFoundException;
    public List<Category> display() throws SQLException, ClassNotFoundException;
    public List<Items> display2(String catCode) throws SQLException, ClassNotFoundException;

}
