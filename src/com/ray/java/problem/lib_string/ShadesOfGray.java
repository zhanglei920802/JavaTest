package com.ray.java.problem.lib_string;

/**
 * Created by 80107442 on 2017-01-12.
 */
public class ShadesOfGray {
    public static void main(String[] args) {
        System.out.println(X.Y/*这里是字段Y*/.Z);//white
        System.out.println(((X.Y/*这里就是Y类了*/) null).Z);
    }

}

class X {
    static class Y {
        static String Z = "Black";
    }

    static C Y = new C();
}

class C {
    String Z = "White";
}
