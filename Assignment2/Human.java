//PART-A(Q1)
package com.pavi;

public class Human {
    String name;
    int age;
    int height;
    String eyeColor;
    public Human(){

    }
    public void speak(){
        System.out.println("My name is"+name);
        System.out.println("I am "+ height +"inches tall");
        System.out.println("i am"+age+"years old");
        System.out.println("My eye color is"+ eyeColor);
    }
    public void eat(){
        System.out.println("I love eating!");
    }
    public void walk(){
        System.out.println("I hate walking!");
    }
    public void work(){
        System.out.println("I am not working! I am a student!");
    }
}

