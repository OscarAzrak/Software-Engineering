package extra;

import java.util.ArrayList;
import java.util.Iterator;

public class bredden implements Iterator<Component> {
    ArrayList<Component> breddarray = new ArrayList<>();

    bredden(Composite root){
        breddarray.add(root);
        add_depth(root.getItems());
    }

    
    public void add_depth(ArrayList<Component> items){
        for(Component item : items){
            breddarray.add(item);
            if (item.getItems() != null){
                add_depth(item.getItems());
                }
            }
        }
    

    @Override
    public boolean hasNext() {
        if (breddarray.isEmpty()){
            return false;
        }
        else {
            return true;
        }    
    }

    @Override
    public Component next() {
        if (hasNext()){
            Component popped_item = breddarray.get(0);
            breddarray.remove(0);
            return popped_item;
        }
        return null;
    }
}
    

