# Class 2

## Contents
```
-> OOP_Class
    -> firstApplication.java
    -> graphic101.java
        -> graphic101
        -> myCanvas
```

## Application
<hr>

```
-> AWT ( Abstract Window Toolkit )
-> Swing
-> FX
```

## Overloading
<hr>

Overloading is the ability to write a method with the same name but different parameter type and order.

It is generally recommended to overload normal methods, which increases the usability of the class.

Static methods can be overloaded.

Constructors can be overloaded. 2^n constructors can be written for n object properties.

```java
public class write {
    public void write(String s){
        System.out.println(s);
    }

    /*
    public String write(int n){
        return String.valueOf(n);
    }
    If we remove this method from the comment line, Java will throw an error because the name and parameters of the method below are the same.
     */

    public void write(int n){
        System.out.println(n);
    }
    public void write(String s, int n){
        System.out.println(s+n);
    }
}
```

## Abstraction
<hr>

```
-> client requests
    -> object-oriented analysis
        -> object-oriented design ( UML [Unified Modeling Language] )
            -> choice of technology to be used
                -> project creation process
                    -> documentation
                        -> test
                            -> end
```
