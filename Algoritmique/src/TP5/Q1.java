package TP5;

public class Q1 {
    public static boolean Search(int[] tab, int init, int fin, int a, int b){
        int milieu = init + (fin - init)/2;

        if(fin - init <= 2){
            return false;
        }

        // Element is between limits
        if(tab[milieu] > a && tab[milieu] < b){
            return true;
        }

        // Second part of the array
        else if (tab[milieu] <= a){
            return Search(tab, milieu, fin, a, b);
        }

        // First part of the array
        else if(tab[milieu] >= b) {
            return Search(tab, init, milieu, a, b);
        }
        return false;
    }
}
