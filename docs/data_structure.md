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

# Set

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


