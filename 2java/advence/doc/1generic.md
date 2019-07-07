# JAVA中的泛型

## 什么是泛型？

泛型就是参数化类型。在创建/使用的时候，传入类型。

## 为什么使用泛型？

适用于多种数据类型执行相同的代码

## 泛型的表示方法

泛型使用`<>`表示

## 泛型的三种方式

泛型类、泛型接口和泛型方法

```java
public class GenericClass<T> {
    private T data;
}

```



```java
public interface GenericInterface<T> {
    //这不是一个泛型方法，只是泛型接口中的一个普通成员方法
    T next();
}

```



```java
public class GenericMethod {

    public <T> T next(T d) {
        return d;
    }
}

```

## 泛型的约束

### 1.不能使用基本类型实例化参数

```
GenericClass<int> doubleGenericClass = new GenericClass<>();//错误的
```

### 2.不能查询类型

```java
//        if(doubleGenericClass instanceof  GenericClass<Double>)//不允许
//        if(doubleGenericClass instanceof  GenericClass<T>)//不允许
//        if(doubleGenericClass instanceof  GenericClass)//允许
```

### 3.泛型类中静态变量类型失效

```java
//静态域或方法中不能引用类型变量
//private static T instance;
//静态方法是泛型方法就行
// private <T> T getInstance() {}
```

### 4.不能实例化参数类型

```java
public class GenericClass<T> {
    private T data;

    public GenericClass(){
        this.data = new T();//错误的
    }

}
```

### 5.不能继承异常/不能捕获泛型实例

不能继承Exception/Throwable

```java
    class Problem<E> extends Exception {}//错误的
    class Problem<E> extends Throwable {}//错误的
```

不能捕获泛型实例

```java
//    public <T extends Throwable> void test(T t) {
//        try {
//
//        } catch (T e) {
//
//        }
//    }
```



```JAVA
  public <T extends Throwable> void test(T t) throws T {
        try {

        } catch (Throwable e) {
            throw t;
        }
    }
```

### 6.泛型的继承关系

```java
public class Employee {
}

public class Worker extends Employee {
}

GenericClass<Employee> employeeGenericClass = new GenericClass<>();
GenericClass<Worker> workerGenericClass = new GenericClass<>();
```

注意：GenericClass<Employee>和GenericClass<Worker>没有任何关系

### 7.通配符

？ extends X  表示类型的上界，类型参数是X的子类

？ super X  表示类型的下界，类型参数是X的超类

### 8.虚拟机怎么实现泛型的

Java语言中的泛型只在程序源码中存在，在编译后的字节码文件中，就已经替换为原来的原生类型（Raw Type，也称为裸类型）了，并且在相应的地方插入了强制转型代码，因此，对于运行期的Java语言来说，ArrayList＜int＞与ArrayList＜String＞就是同一个类，所以泛型技术实际上是Java语言的一颗语法糖，Java语言中的泛型实现方法称为类型擦除，基于这种方法实现的泛型称为伪泛型