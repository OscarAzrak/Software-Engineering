package part_one;

import java.util.ArrayList;

public class Composite extends Component {
    ArrayList<Component> comp_list = new ArrayList<>(); //
    Composite(String item, int weight){
        this.item = item;
        this.weight = weight;
    }

    public void add(Component items){
        comp_list.add(items);

    }
    public void delete(Component items){
        comp_list.remove(items);

    }
    @Override
    public int getWeight(){
        int total_weight = this.weight;
        for(Component item: comp_list){
            total_weight+= item.getWeight();
        }
        return total_weight;

    }

    @Override
    public String toString(){
        String[] items = new String[(int)comp_list.size()];
        String returnmany = this.item + "\nitems in" + this.item + ":\n";
        for (Component component : comp_list) {
            returnmany += component.toString() + "\n";
        }
        return returnmany;
    }

}
