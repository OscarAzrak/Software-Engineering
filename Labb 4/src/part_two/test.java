package part_two;

import part_two.Human_fac.human;

public class test {
    public static void main(String[] args){
        human billie = human.create("Billie", "xxxxxx-5600");
        human anna = human.create("Anna", "xxxxxx-6422");
        human magnus = human.create("Magnus","xxxxxx-0113");
        System.out.println(billie);
        System.out.println(anna);
        System.out.println(magnus);
    }
}
