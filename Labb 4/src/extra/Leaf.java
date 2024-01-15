package extra;
import java.util.ArrayList;


public class Leaf extends Component{
    Leaf(String item){
        this.item = item;
    }

    @Override
    public String getItemName(){
        return this.item;
    }

    @Override
    public ArrayList<Component> getItems() {
        return null;
    }
}
