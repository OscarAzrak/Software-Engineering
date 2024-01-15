package part_one;

public class test {
    public static void main(String[] args){
        Composite suitcase = new Composite("Suitcase", 15);
        leaf shirt = new leaf("Shirt", 1);
        Composite mini_bag = new Composite("Mini Bag", 3);
        leaf makeup_brush = new leaf("brush", 1);
        leaf mascara = new leaf("mascara", 2);
        Composite medic = new Composite("Medic", 3);
        leaf alvedon = new leaf("Alvedon", 1);
        leaf skin_lotion = new leaf("Skin Lotion", 1);

        System.out.println("Empty suitcase weight: "+ suitcase.getWeight());
        System.out.println(suitcase);

        System.out.println("Add shirt: ");
        suitcase.add(shirt);
        System.out.println("Suitcase weight: "+ suitcase.getWeight());//Weight should be 16
        System.out.println(suitcase);

        System.out.println("Add mini bag: ");
        suitcase.add(mini_bag);
        System.out.println("Suitcase weight: " + suitcase.getWeight()); //Weight should be 19
        System.out.println(suitcase);

        System.out.println("Add make-up to mini bag");
        mini_bag.add(makeup_brush);
        mini_bag.add(mascara);
        System.out.println("Suitcase weight: "+ suitcase.getWeight()); //Weight should be 22
        System.out.println(suitcase);

        System.out.println("Add medic bag to mini bag: ");
        mini_bag.add(medic);
        System.out.println("Suitcase weight: "+ suitcase.getWeight());//Weight should be 25
        System.out.println(suitcase);

        System.out.println("Add medecine to medic bag: ");
        medic.add(alvedon);
        medic.add(skin_lotion);
        System.out.println("Suitcase weight: " + suitcase.getWeight());//Weight should be 27
        System.out.println(suitcase);

        System.out.println("Delete mascara: ");
        mini_bag.delete(mascara);
        System.out.println("Suitcase weight: "+suitcase.getWeight());//Weight should be 25
        System.out.println(suitcase);


    }
}
