package ClasseInverseeIterateur.Demo;

import Exceptions.NegativeExponentException;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo {


    public static void main(String[] args){

        System.out.println("Démo sur l'abstraction de l'itération");
        System.out.println("-------------------------------------");
        System.out.println();

        System.out.println("Table de trois");
        System.out.println("--------------");
        System.out.println();

        Trois t=new Trois();

        Iterator<Integer> tt=t.getTableTrois();
        while(tt.hasNext()){
            Integer current=tt.next();
            System.out.println(current);
            if(current>10)break;
        }

        System.out.println("Les polynomes");
        System.out.println("-------------");
        System.out.println();
        PolyIte p=new PolyIte();

        try {
            PolyIte p1 = new PolyIte(4,0);
            PolyIte p2 = new PolyIte(3,1);
            PolyIte p3 = new PolyIte(2,2);
            PolyIte p4 = new PolyIte(-1,3);
            p=p.add(p1);
            p=p.add(p2);
            p=p.add(p3);
            p=p.add(p4);
        } catch (NegativeExponentException e) {
            e.printStackTrace();
        }

        System.out.println(p);
        System.out.println();
        System.out.println("For-each :");
        for (PolyIte monome: p) {
            System.out.println(monome);
        }

        System.out.println("Manière classique");
        // Necessite l'import de java.util.Iterator
        Iterator<PolyIte> i = p.monomes();
        while(i.hasNext()){
            //i.remove();    ;) essayez! L'implémentaiton de l'interface est récupérée
            System.out.println(i.next());

        }

    }
}

