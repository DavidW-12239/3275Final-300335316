package final123;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private static List<Category> todos = new ArrayList<Category>();

    static{
        todos.add(new Category("SS", "School Supplies"));
        todos.add(new Category("Dr", "Drinks"));
    }

    public void initialAdd(){
        todos.add(new Category("SS", "School Supplies"));
        todos.add(new Category("Dr", "Drinks"));
    }

    public List<Category> retrieveTodos(){
        List<Category> filteredTodos = new ArrayList<Category>();
        for (Category todo: todos){
            filteredTodos.add(todo);
        }
        return filteredTodos;
    }

    public void addTodo(String catCode, String catDesc){
        todos.add(new Category(catCode, catDesc));
    }

    public void deleteTodos(String id){
        for (int i=0; i< todos.size(); i++){
            if(id.equals(todos.get(i).getCatCode())){
                todos.remove(i);
                break;
            }
        }
    }

    public Category retrieve(String id){
        for (Category todo: todos){
            if (todo.getCatCode().equals(id)){
                return todo;
            }
        }
        return null;
    }

    public void update(Category todo){
        todos.remove(todo);
        todos.add(todo);
    }
}
