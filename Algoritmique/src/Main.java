import TP5.Q1;
import TP5.Q2;
import TP5.Q7;

public class Main {
    public static void main(String[] args) {
        int[] tab = {0, 3, 4, 5, 10};
        int min = 3;
        int max = 5;
        System.out.println(Q1.Search(tab, 0, tab.length-1, min, max));

        int[] table = {0, 1, 2, 3, 4, 5, 6, 7, 8, 8};

        System.out.println(Q2.doublon(table, 0, table.length - 1));

        int[] a= {3, -4, 6, 2, -5, 9, 8, -9, -2, 8};
        System.out.println(Q7.MaxSumConsecutive(a));

        /*int test = 75;
        Padovan.PadovanSuite(test);*/

    }
}
