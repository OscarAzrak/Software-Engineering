package part_two;

import java.util.*;


public class CustomTreeMap <E extends Comparable<E>>extends TreeMap<Integer, E> implements SparseVec<E>{

    CustomTreeMap(){
        super();
    }
    public static void main(String[] args) {
        VectorA<Integer> testvector = new VectorA<>();
        testvector.add(0, 5000);
        testvector.add(17, 3000);
        testvector.add(21, 3050);
        testvector.add(3, 10000);
        testvector.add(7, 900);

        System.out.println("Test toString");
        System.out.println(testvector);

        //Object[] array = testvector.toArray();
        List<Integer> sortedList = testvector.sortedValues();
        System.out.println("\nTest sorted list");
        System.out.println(sortedList);

        // Test result of toArray()
        Object[] array = testvector.toArray();
        System.out.println("\nTest toArray");
        int i = 0;

        for (Object o : array) {
            System.out.print(o);
            System.out.println(" " + i++);
        }
    }
    @Override
    public void add(E elem) {
        int index = 0;
        for (;true;) {
            if (this.get(index) == null) {
                this.add(index, elem);
                return;
            }
            index++;
        }
    }
    @Override
    public void add(int pos, E elem){
        if(pos<0){
            pos = 0;
        }
        this.put(pos,elem);
    }

    @Override
    public int indexOf(E elem){
        Set<Map.Entry<Integer, E>> mappings = this.entrySet();
        for(Map.Entry<Integer, E> element : mappings){
            if(element.getValue().equals(elem)){
                return element.getKey();
            }
        }
        return -1;
    }
    @Override
    public void removeAt(int pos){
        this.remove(pos);
    }
    @Override
    public void removeElem(E elem){
        int index = this.indexOf(elem);
        this.removeAt(index);
    }

    @Override
    public int size(){
        return super.size();
    }

    @Override
    public int minIndex(){
        if(this.size()==0){
            return -1;
        }
        else{
            return this.firstKey();
        }
    }
    @Override
    public int maxIndex(){
        if(this.size()==0){
            return -1;
        }
        else{
            return this.lastKey();
        }
    }
    @Override
    public E get(int pos){
        return super.get(pos);

    }
    @Override
    public Object[] toArray(){
        Object[] array = new Object[this.maxIndex()+1];
        if(array.length==0){
            return null;
        }
        for (int i = 0; i < this.maxIndex()+1;){
            if(this.get(i) != null){
                array[i] = this.get(i);
            }
            else{
                array[i] = null;
            }
        }
        return array;
    }

    @Override
    public List<E> sortedValues(){
        if(this.size()==0){
            return null;
        }
        List<E> sortedList = new ArrayList<>(this.values());
        Collections.sort(sortedList);
        return sortedList;

    }

    @Override
    public String toString(){
        StringBuilder printString = new StringBuilder(this.size());
        Set<Map.Entry<Integer,E>> mappings = this.entrySet();
        for(Map.Entry<Integer,E> element: mappings){
            printString.append("Key: ");
            printString.append(element.getKey());
            printString.append(" Value: ");
            printString.append(element.getValue());
            printString.append("\n");
        }
        return printString.toString();
    }
}
