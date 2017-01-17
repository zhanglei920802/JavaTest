package com.ray.java.problem.lib_string;

/**
 * Created by 80107442 on 2017-01-12.
 */
public class PingPong {
    public static synchronized void main(String[] a){
        Thread t = new Thread(()->pong());
        t.run();
        System.out.print( "Ping" );
    }
    static synchronized void pong(){
        System.out.print( "Pong" );
    }
}
