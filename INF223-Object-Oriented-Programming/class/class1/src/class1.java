/*

Java Fields of Usage

    -> Console Programs
    -> Applex
    -> Application
        -> AWT ( Abstract Window Toolkit )
        -> Swing
        -> FX


Access Modifiers

    -> public       Accessible within class, within package, outside package by subclass only, outside package
    -> protected    Accessible within class, within package, outside package by subclass only
    -> friendly     Accessible within class, within package
    -> private      Accessible within class


Software Development Procedure

    -> client requests
        -> object-oriented analysis
            -> object-oriented design ( UML [Unified Modeling Language] )
                -> choice of technology to be used
                    -> project creation process
                        -> documentation
                            -> test
                                -> end


Class Build

    class ...{
        1) Properties
        2) Constructors
        3) Methods
    }


JVM & RAM [Java Virtual Machine & Random Access Memory]

         RAM
    _____________
    |           |
    |///////////|
    |///////////| -> Space left by the RAM to the JVM's control for Java programs
    |///////////|    JVM automatically splits the shaded region
    |           |
    |           |
    |    JVM    |
    |___________|


OOP

    -> Encapsulation
        -> Class Basis
            -> friendly
            -> public
        -> Method Basis
            -> public
            -> protected
            -> friendly
            -> private
        -> Properties Basis
    -> Abstraction
    -> Inheritance
    -> Polymorphism


Compilation in Java

    x.java ---> x.class ---> Java Runtime Environment & Java Virtual Machine ---> Operating System ---> Microprocessor

*/

public class class1 {

    static void loopExample(int recurrence){

        StringBuffer myString = new StringBuffer();
        myString.append("Hello");


        for(int i = 0; i <recurrence; i++){
            System.out.println(myString);
        }
    }

    public static void main(String[] args){
        loopExample(5);
    }
}