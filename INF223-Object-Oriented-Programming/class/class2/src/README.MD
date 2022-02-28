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

İsmi aynı olan ancak parametre türü ve sırası farklı olan metot yazabilme kabiliyetidir.

Normal metotların overload edilmesi genelde tavsiye edilir, bu durum class'ın kullanılabilirliğini arttırır.

Static metotlar overload edilebilir.

Constructor'lar overload edilebilir. n adet nesne özelliği için 2^n adet constructor yazılabilir.

```
public class yaziYazma {
    public void yaziYaz(String s){
        System.out.println(s);
    }

    /*
    public String yaziYaz(int n){
        return String.valueOf(n);
    }
    Bu metodu yorum satırından çıkartırsak, Java aşağıdaki metotla ismi ve parametreleri aynı olduğu için hata verecektir.
     */

    public void yaziYaz(int n){
        System.out.println(n);
    }
    public void yaziYaz(String s, int n){
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