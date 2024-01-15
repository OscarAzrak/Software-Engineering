package extra;
import java.util.ArrayList;

abstract class Component {
    String item;
    public abstract String getItemName();
    public abstract ArrayList<Component> getItems();
}
