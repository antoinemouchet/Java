import java.util.Arrays;

public class Solution {
    public static Box[] solve(Box[] in){

        // Cas de base
        if(in.length <= 1) return in;

        // Trier les boites pour assurer la programmation dynamique
        Arrays.sort(in);

        // Nombre max de boites à l'intérieur de i
        int[] number = new int[in.length];

        // Meilleur boite juste à l'intérieur de i
        int[] prev = new int[in.length];

        for (int i = 0; i < in.length; i++) {
            // Meilleure boite à l'intérieure (i par convention)
            int m = i;
            // Quelle boite est la meilleure à l'intérieur de i?
            for (int j = 0; j < i; j++) {
                if(number[j] > number[m] && in[j].fitsIn(in[i])){
                    m = j;
                }
            }
            // 1 parce que i
            number[i] = number[m] + 1;
            prev[i] = m;
        }

        // Selection de la meilleure serie
        int m = 0;
        for (int i = 1; i < in.length; i++) {
            if(number[i] > number[m])
                m = i;
        }

        // Construction de la meilleure solution en recursion
        Box[] s = new Box[number[m]];
        for (int i = number[m] - 1; i >= 0 ; i--) {
            s[i] = in[m];
            m = prev[m];
        }
        return s;
    }
}
