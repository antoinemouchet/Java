package ClasseInverseeTest.Classe;

import Exceptions.UnauthorizedOperation;

public class MainTest {
    public static void main(String[] args) {

        // Cas n°1
        CompteCl compte = new CompteCl("BeXXXX", 1200, 1500, true);

        try{
            compte.retirer(-1000);
        } catch (UnauthorizedOperation e){
            System.out.println("cas 1");
                e.printStackTrace();
        }
        System.out.println("cas1" + compte);


        // Cas n°2
        compte = new CompteCl("BeXXXX", 1200, 1500, true);

        try{
            compte.retirer(300);
        } catch (UnauthorizedOperation e){
            System.out.println("cas 2");
            e.printStackTrace();
        }
        System.out.println("cas2" +compte);


        // Cas n°3
        compte = new CompteCl("BeXXXX", 1200, 0, true);

        try{
            compte.retirer(Integer.MAX_VALUE);
        } catch (UnauthorizedOperation e){
            System.out.println("cas 3");
            e.printStackTrace();
        }
        System.out.println("cas3" +compte);


        // Cas n°4
        compte = new CompteCl("BeXXXX", 0, 0, false);

        try{
            compte.retirer(50);
        } catch (UnauthorizedOperation e){
            System.out.println("cas 4");
            e.printStackTrace();
        }
        System.out.println("cas4" +compte);

        // Cas n°5
        compte = new CompteCl("BeXXXX", 1200, 0, false);
        try{
            compte.retirer(300);
        } catch (UnauthorizedOperation e){
            System.out.println("cas 5");
            e.printStackTrace();
        }
        System.out.println("cas5" +compte);

        // Cas n°6
        compte = new CompteCl("BeXXXX", 0, 0, false);
        try{
            compte.retirer(0);
        } catch (UnauthorizedOperation e){
            System.out.println("cas 6");
            e.printStackTrace();
        }
        System.out.println("cas6" +compte);
    }
}
