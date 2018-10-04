package com.cloudbees.manticore;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String a = null;
        System.out.println(a.toString());
        System.out.println( "Hello World!" );

        try {
            a = "Hello";
        } catch (Exception e) {}
    }
}
