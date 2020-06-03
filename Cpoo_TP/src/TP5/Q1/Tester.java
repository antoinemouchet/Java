package TP5.Q1;

public class Tester {
    /*public static void test4(){
        Compteur0 myC = new Compteur1();

        myC.incr();
        myC.mult();
        myC.decr();
    }*/

    public static void test5(){
        Compteur1 myC = new Compteur2();

        myC.incr();
        ((Compteur2) myC).mult();
        myC.decr();
    }

    public static void main(String[] args) {
        test5();
    }
}
