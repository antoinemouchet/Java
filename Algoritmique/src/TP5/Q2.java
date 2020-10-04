package TP5;

public class Q2 {
    public static int doublon(int[] tab, int init, int fin){
        int milieu = (init + fin) /2;

        if(tab[milieu] == tab[milieu + 1] || tab[milieu] == tab[milieu - 1]){
            return tab[milieu];
        }
        // If element is not equal to its index, doublon is in first part
        else if (tab[milieu] != milieu){
            return doublon(tab, init, milieu);
        }
        // If element is equal to its index, doublon not found yet
        else{
            return doublon(tab, milieu, fin);
        }
    }
}
