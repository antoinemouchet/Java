public class Padovan {
    public static int PadovanSuite(int degre) {
        if (degre <= 2) {
            return 1;
        } else {
            return PadovanSuite(degre - 2) + PadovanSuite(degre - 3);
        }
    }

    public static int PadovanSuiteIte(int deg){
        int[] terms = new int[deg+1];

        for (int i = 0; i < deg+1; i++) {
            if(i <= 2){
                terms[i] = 1;
            }
            else{
                terms[i] = terms[i-2] + terms[i-3];
            }
        }

        return terms[deg];
    }

    public static int PadovanSuiteIte2(int deg){
        int nMoins3 = 1;
        int nMoins2 = 1;
        int nMoins1 = 1;
        int sum = 1;

        if (deg <= 2){
            return sum;
        }

        for (int i = 2; i < deg; i++) {
            sum = (nMoins2 + nMoins3);
            nMoins3 = nMoins2;
            nMoins2 = nMoins1;
            nMoins1 = sum;
        }
        return sum;
    }
}
