package tp4;

import exceptions.NotFoundException;

public class Main {

    public static void main(String[] args) {
        Compute c=new Compute();

        c.compute();

        //c.computeBis();
        // Cette ligne de code plante le programme
        // Exception indiquée dans le terminale

        try {
            c.computeTer(); //gestion par le code appelant (Main)
        } catch (NotFoundException e) {
            e.printStackTrace();
            // Exception indiquée dans le terminal également mais le programme termine correctement
        }


    }




}
