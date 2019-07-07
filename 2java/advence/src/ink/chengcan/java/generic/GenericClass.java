package ink.chengcan.java.generic;

public class GenericClass<T extends Fruit> implements Fruit {

    private T data;

    public GenericClass(T data) {
        this.data = data;
    }

    public void print() {
        data.print();
    }
}
