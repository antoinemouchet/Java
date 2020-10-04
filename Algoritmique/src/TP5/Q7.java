package TP5;

public class Q7 {
    public static int MaxSumConsecutive(int[] tab){
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < tab.length; i++) {
            sum += tab[i];

            if(max < sum){
                max = sum;
            }

            if (sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}
