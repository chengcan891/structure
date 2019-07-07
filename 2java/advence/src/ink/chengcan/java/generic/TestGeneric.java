package ink.chengcan.java.generic;

public class TestGeneric {

    public static void main(String[] args) {
//        GenericClass<Double> doubleGenericClass = new GenericClass<>();
//        GenericClass<String> stringGenericClass = new GenericClass<>();

//        if(doubleGenericClass instanceof  GenericClass<Double>)//不允许
//        if(doubleGenericClass instanceof  GenericClass<T>)//不允许
//        if(doubleGenericClass instanceof  GenericClass)//允许

//        System.out.println(doubleGenericClass.getClass() == stringGenericClass.getClass());
//        System.out.println(doubleGenericClass.getClass());
//
//        String[] s = new String[]{"1", "2"};
//        GenericClass<String>[] a = new GenericClass[10];//可以
//        GenericClass<String>[] a1 = new GenericClass[]{new GenericClass<String>() {
//        }};

//        GenericClass<Employee> employeeGenericClass = new GenericClass<>();
//        GenericClass<Worker> workerGenericClass = new GenericClass<>();

        GenericClass<? extends Fruit> fruit = new GenericClass<>(new Orange());
        fruit.print();



    }

    //静态域或方法中不能引用类型变量
//    private static T instance;
    //静态方法是泛型方法就行
    // private <T> T getInstance() {}
}
