package extra;

import java.util.Iterator;

public class iteratorTest {
    public static void main(String[] args) {

        Composite bag = new Composite("Första väskan, root");
        Leaf item = new Leaf("Första saken, nivå 1");
        Leaf item2 = new Leaf("Andra saken, nivå 1");

        Composite bag2 = new Composite("Andra väskan nivå 2 start");
        Leaf item3 = new Leaf("Första saken, nivå 2");
        Leaf item4 = new Leaf("Andra saken, nivå 2");
        Leaf item5 = new Leaf("Tredje saken, nivå 2");

        Composite bag3 = new Composite("Tredje väskan start nivå 3");
        Leaf item6 = new Leaf("Första saken, nivå 3");


        bag.add(item);
        bag.add(bag2);
        bag.add(item2);
        bag2.add(item3);
        bag2.add(item4);
        bag2.add(item5);
        bag2.add(bag3);
        bag3.add(item6);

        System.out.println("Starting Iterator");

        Iterator<Component> itr_tester = bag.iterator();
        while (itr_tester.hasNext()){
            Component node = itr_tester.next();
            System.out.println(node.getItemName());
        }

        System.out.println("\nItertor finished, printing with foreach loop");

        for (Component itemInBag : bag){
            System.out.println(itemInBag.getItemName());
        }
    }
}
