public class ArrayListImpl {
    private int[] arr;
    private final int INITIAL_CAPACITY = 16;
    private int size, capacity;

    public ArrayListImpl(){
        this.arr = new int[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int value){
        if(size < capacity){
            arr[size++] = value;
        }else{
            capacity = 2 * capacity;
            int[] newArr = new int[capacity];
            for(int i = 0; i < size; i++ ){
                newArr[i] = arr[i];
            }
            newArr[size] = value;
            arr = newArr;
        }
    }

    public int remove(int index){
        if(index >= size) throw new IndexOutOfBoundsException("Index not found");
        int removedElement = arr[index];
        for(int i = index; i < size; i++ ){
            arr[i] = arr[i+1];
        }
        size--;
        return removedElement;
    }

    public int get(int index){
        if(index >= size) throw new IndexOutOfBoundsException("Index not found");
        return arr[index];
    }

    public int size(){
        return size;
    }

}
