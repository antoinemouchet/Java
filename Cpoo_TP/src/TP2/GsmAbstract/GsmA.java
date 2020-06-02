package TP2.GsmAbstract;

/**
 * @overview Class that defines a GSM object with a brand and a locked status
 * GSM is mutable
 * A GSM is defined by <marque, verrou> such as:
 * @specfield marque: String
 * @specfield verrou: boolean
 */
public class GsmA {
    final private String brand;
    private boolean locked;

    /**
     * FA(c) = <c.brand, c.locked>
     */

    /**
     * Construtor of GSM object
     * @param brand
     */
    public GsmA(String brand) {
        this.brand = brand;
    }

    /** Getters */

    public String brand() {
        return brand;
    }

    public boolean isLocked( ) {
        return locked;
    }

    /** Mutators for lock value */
    public void lock( ) {
        this.locked = true;
    }

    public void unlock( ) {
        this.locked = false;
    }


    public String toString() {
        return "The brand of my gsm is: "+brand();
    }

}



