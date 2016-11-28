# Data Structure

# datetime

```
Calendar c = Calendar.getInstance();
```

# string, number

Convert [^1]

```java
String.valueOf(1000)
```

Make a random

```java
// create a random number from 0 to 99
(new Random()).nextInt(100)
```

[^1]: [How to convert from int to String?](http://stackoverflow.com/questions/4105331/how-to-convert-from-int-to-string)

# Collection

## Arrays

Arrays in Java are also objects. They need to be declared and then created. In order to declare a variable that will hold an array of integers, we use the following syntax:

```java
int[] arr;
```

Notice there is no size, since we didn't create the array yet.

```java
arr = new int[10];
```

This will create a new array with the size of 10. We can check the size by printing the array's length:

```java
System.out.println(arr.length);
```

We can access the array and set values:

```java
arr[0] = 4;
arr[1] = arr[0] + 5;
```

Java arrays are 0 based, which means the first element in an array is accessed at index 0 (e.g: arr[0], which accesses the first element). Also, as an example, an array of size 5 will only go up to index 4 due to it being 0 based.

```java
int[] arr = new int[5]
//accesses and sets the first element
arr[0] = 4;
```

We can also create an array with values in the same line:

```java
int[] arr = {1, 2, 3, 4, 5};
```

Don't try to print the array without a loop, it will print something nasty like [I@f7e6a96.

## Set

```java

import java.util.HashSet;
import java.util.Set;

public class HelloWorld{

     public static void main(String []args){
         Set<Dog> dogs = new  HashSet<Dog>();
         Dog dog1 = new Dog("a", 1);
         Dog dog2 = new Dog("a", 2);
         Dog dog3 = new Dog("a", 1);
         Dog dog4 = new Dog("b", 1);
         dogs.add( dog1);
         dogs.add( dog2);
         dogs.add( dog3);
         dogs.add( dog4);
        System.out.println(dogs.size());
     }
}

// 3
```

```java
public class Dog {
    public String name;
    public int age;
    public int value;
    public Dog(String name, int age){
        this.name = name;
        this.age = age;
        value = (this.name + String.valueOf(this.age)).hashCode();
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Dog && ((Dog) obj).value == this.value);
    }
}
```

## List [^1]

```
List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
```

[^1]: [Initialization of an ArrayList in one line](http://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line)

