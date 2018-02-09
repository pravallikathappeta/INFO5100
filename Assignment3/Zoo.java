public class Zoo {
    public static void main(String[] args){
        Chicken chick1= new Chicken(1,"M",7);
        chick1.fly();
        Animal animal1 = new Animal(12,"M",23);
        animal1.eat();

        Bird bird1= new Bird(3,"f",10);
        bird1.eat();
        bird1.sleep();


    }
}
