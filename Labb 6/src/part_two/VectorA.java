package part_two;

import java.util.*;

public class VectorA <E extends Comparable<E>> implements SparseVec<E>{
    private TreeMap<Integer, E> vecTree = new TreeMap<Integer, E>();
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
        System.out.println("\nTest sorted list");
        List<Integer> sortedList = testvector.sortedValues();
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
    //plstsen i vectorn är tom, lägg in E elem i den platsen
    @Override
    public void add(E elem) {
        int index = 0;
        for (;true;) {//while true, skriv om kanske
            if (this.get(index) == null) {
                this.add(index, elem);
                return;
            }
            index++;
        }
    }

    //Om indexet är mindre än noll, lägg 0, annars lägg indexet i vecTree
    @Override
    public void add(int pos, E elem){
        if(pos<0){
            pos = 0;
        }
        this.vecTree.put(pos,elem);
    }
    //returnar indexet av elementet
    @Override
    public int indexOf(E elem){
        Set<Map.Entry<Integer, E>> mappings = this.vecTree.entrySet();
        for(Map.Entry<Integer, E> element : mappings){ //loopar igneom varje element i vecTree tills rätt index hittas
            if(element.getValue().equals(elem)){
                return element.getKey(); //returnar då rätta elements index
            }
        }
        return -1;
    }
    //removar indexet från vecTree
    @Override
    public void removeAt(int pos){
        this.vecTree.remove(pos);
    }
    //removar element från VecTree
    @Override
    public void removeElem(E elem){
        int index = this.indexOf(elem);
        this.removeAt(index);
    }

    @Override
    public int size(){
        return this.vecTree.size();
    }

    @Override
    public int minIndex(){
        if(this.vecTree.size()==0){
            return -1;
        }
        else{
            return this.vecTree.firstKey();
        }
    }
    @Override
    public int maxIndex(){
        if(this.vecTree.size()==0){
            return -1;
        }
        else{
            return this.vecTree.lastKey();
        }
    }

    @Override
    public E get(int pos){
        return this.vecTree.get(pos);

    }
    // return the SparseVector as a regular array with value null at unused indexes
    @Override
    public Object[] toArray(){
        Object[] array = new Object[this.maxIndex()+1];

        if(array.length==0){
            return null;
        }
        for (int i = 0; i < this.maxIndex()+1;i++){
            if(this.get(i) != null){
                array[i] = this.get(i);
            }
            else{
                array[i] = null;
            }
        }
        return array;
    }
    //return a List of the values of the Vector in sorted order
    @Override
    public List<E> sortedValues(){
        if(this.size()==0){
            return null;
        }
        List<E> sortedList = new ArrayList<>(vecTree.values());
        Collections.sort(sortedList);
        return sortedList;

    }
    // one line per element with index and value, sorted by index
    @Override
    public String toString(){
        StringBuilder printString = new StringBuilder(this.size());
        Set<Map.Entry<Integer,E>> mappings = this.vecTree.entrySet();
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
