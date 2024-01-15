package part_one;

public class NumberedItem<T> implements Comparable<NumberedItem<T>>{
    private int index;
    private T item;

    /* Logic:
      if number < 0:
        index = 0
      else:
      index ? number
    * */

    public NumberedItem(int number, T i){
        this.index = Math.max(number, 0);
        this.item = i;
    }
    public int getIndex(){
        return this.index;
    }

    public T getItem(){
        return this.item;
    }

    public int compareTo(NumberedItem<T> obj){
        return this.index - obj.getIndex();
    }


    @Override
    public boolean equals(Object obj){
        if(obj instanceof NumberedItem){
            return this.index == ((NumberedItem<T>) obj).getIndex();
        }
        return false;
    }


    public String toString(){
        return ("index: " + this.index + " Value: " + this.item);
    }

}


