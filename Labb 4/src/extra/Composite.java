package extra;

import java.util.ArrayList;
import java.util.Iterator;

public class Composite extends Component implements Iterable<Component> {
    ArrayList<Component> comp_list = new ArrayList<>();

    Composite(String item){
        this.item = item;
    }

    public void add(Component item){
        comp_list.add(item);

    }
    public void delete(Component item){
        comp_list.remove(item);

    }

    public String getItemName(){
        return this.item;
    }



    public ArrayList getItems() {
        return this.comp_list;
    }

    @Override
    public Iterator<Component> iterator() {
        //return new WidthFirstIterator(this);
        return new bredden(this);
    }

}
