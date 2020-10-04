package TP7;

public class BagPack {
    private double quantity[];
    private double value[];
    private double max;
    private double butin[];
    private double butinValue;

    public double getButinValue() {
        if(butin == null){
            generateButin();
        }
        return butinValue;
    }

    private void generateButin(){
        double capacity = max;
        int i = 0;
        butinValue = 0;

        // Fill bag
        while (i < quantity.length && capacity > 0){
            butin[i] = Math.min(quantity[i], capacity);
            butinValue += butin[i] * value[i];
            capacity -= butin[i];
            i++;
        }

        // Fill the rest of the array with 0 since we don't take those items if bag is full
        while (i < quantity.length){
            butin[i] = 0;
        }
    }
}
