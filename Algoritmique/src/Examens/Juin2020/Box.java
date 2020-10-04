public class Box{

    double[] b;
    //@invariant (\forall int i; 0 <= i & i < b.length; b[i] > 0);

    public boolean fitsIn(Box a){
        // Boucle sur toutes les dimensions
        for (int i = 0; i < this.b.length; i++) {
            // Si une dimension est plus grande, alors la boite ne peut pas tenir à l'intérieur
            if(this.b[i] > a.b[i])
                return false;
        }
        return true;
    }
}
