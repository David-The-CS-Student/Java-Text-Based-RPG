package generics;

import java.util.Arrays;

public class Array<T> {

    private T[] array;

    private int count = 0;

    public Array(int size){

        array = (T[]) new Object[size];
    }


    public void add(T obj){


          try {
              array[this.count] = obj;

              count++;

          }catch(ArrayIndexOutOfBoundsException err){

              System.out.println(err.getMessage());
          }

    }

    public void remove(int index){

        try {

            for (int arrayIndex = index; arrayIndex < count - 1; arrayIndex++) {

                this.array[arrayIndex] = this.array[arrayIndex + 1];

            }

            this.count--;

        }catch(ArrayIndexOutOfBoundsException err){

            System.out.println(err.getMessage());

        }


    }


    public T getObject(int index){

        return array[index];
    }

    public void setObject(T obj, int index){

        array[index] = obj;
    }

    public int getCount(){
        return this.count;
    }
    public int getCapacity(){

        return this.array.length;
    }

    public T[] toArray(){

        T[] result = (T[]) new Object[this.count];
        for(int index = 0; index < this.count; index++)
        {
            result[index] = array[index];
        }

        return result;
    }
}
