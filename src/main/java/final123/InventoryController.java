package final123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"id", "desc", "errMsg", "errorMessage"})
@Controller
public class InventoryController {
    DatabaseService service1;

    @Autowired
    CategoryService service;

    @Autowired
    Connection123 connect;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String showCategoryPage(ModelMap model, @RequestParam(defaultValue = "") String id)
            throws ClassNotFoundException, SQLException{
        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos", service1.display());

        List<Category> filteredTodos = new ArrayList<Category>();
        filteredTodos = (List) model.get("todos");

        model.put("id", filteredTodos.get(0).getCatCode());
        model.put("desc", filteredTodos.get(0).getCatDesc());
        return "category";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCategoryPage2(ModelMap model) throws ClassNotFoundException, SQLException {
        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos", service1.display());

        List<Category> filteredTodos = new ArrayList<Category>();
        filteredTodos = (List) model.get("todos");

        model.put("id", filteredTodos.get(0).getCatCode());
        model.put("desc", filteredTodos.get(0).getCatDesc());
        return "category";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodoPage(){
        return "catSer";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String catCode, @RequestParam String catDesc)
            throws ClassNotFoundException, SQLException {
        if (!((service1.search(catCode)) == null)){
            model.put("errorMessage", "Record Existing");
            return "redirect:/category";
        }

        Category cc = new Category(catCode, catDesc);
        service1.add(cc);
        model.clear();
        return "redirect:/category";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam(defaultValue = "") String id)
            throws ClassNotFoundException, SQLException{
        model.put("id", id);
        Category cc = service1.search(id);
        model.put("id", cc.getCatCode());
        model.put("desc", cc.getCatDesc());
        return "cateDit";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model, @RequestParam String catCode, @RequestParam String catDesc)
            throws ClassNotFoundException, SQLException {
        //get the old catCode
        String iid = (String) model.get("id");
        Category cc = new Category(catCode, catDesc);
        service1.edit(cc, iid);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws ClassNotFoundException, SQLException{
        service1.delete(id);
        model.clear();
        return "redirect:/";
    }

    @RequestMapping(value = "/see-todo", method = RequestMethod.GET)
    public String seeTodo(ModelMap model, @RequestParam(defaultValue = "") String id)
            throws ClassNotFoundException, SQLException{
        model.put("id", id);
        service1 = new DatabaseService(connect.connect());
        String iid = (String) model.get("id");
        List<Items> itemsList = new ArrayList<>();
        itemsList = service1.display2(iid);

        if (itemsList.size()==0){
            model.put("errorMessage", "There are no items for this category");
            return "redirect:/";
        }

        model.put("desc", iid);
        model.addAttribute("todos1", service1.display2(iid));
        return "items";
    }

    @RequestMapping(value = "/see-todo", method = RequestMethod.POST)
    public String seeTodo2(ModelMap model) throws ClassNotFoundException, SQLException {
        return "redirect:/";
    }
}
