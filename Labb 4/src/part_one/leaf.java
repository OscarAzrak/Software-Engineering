package part_one;

public class leaf extends Component{
    leaf(String item, int weight){
        this.item = item;
        this.weight = weight;
    }
    @Override
    public int getWeight(){
        return this.weight;
    }

    @Override
    public String toString(){
        return this.item;
    }
}
