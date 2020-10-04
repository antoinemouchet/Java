package Examens;

import java.util.*;

public class Q4 {
    /* Representation of a box */
    static class Box implements Comparable<Box>{

        // h --> height, w --> width,
        // d --> depth
        int h, w, d, volume;

        // for simplicity of solution,
        // always keep w <= d

        /*Constructor to initialise object*/
        public Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
        }

        /*To sort the box array on the basis
        of volume in decreasing order of volume */
        @Override
        public int compareTo(Box o) {
            return o.volume -this.volume;
        }

        @Override
        public String toString() {
            return "h=" + h + ", w=" + w + ", d=" + d + ", volume=" + volume + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Box box = (Box) o;
            return h == box.h &&
                    w == box.w &&
                    d == box.d &&
                    volume == box.volume;
        }

        @Override
        public int hashCode() {
            return Objects.hash(h, w, d, volume);
        }
    }

    static boolean inside(Box a, Box b){
        if(a.h < b.h && a.d < b.d && a.w < b.w)
            return true;
        return false;
    }

    static boolean alreadyIn(Box a, Box[] total){
        // Get all rotations of the box
        Box[] rot = new Box[6];
        rot[0] = new Box(a.h, Math.max(a.w,a.d), Math.min(a.w,a.d));
        /* First rotation of box*/
        rot[1] = new Box(a.w, Math.max(a.h,a.d), Math.min(a.h,a.d));
        /* Second rotation of box*/
        rot[2] = new Box(a.d, Math.max(a.w,a.h), Math.min(a.w,a.h));
        /* Third rotation of box*/
        rot[3] = new Box(a.h, Math.min(a.w,a.d), Math.max(a.w,a.d));

        /* Fourth rotation of box*/
        rot[4] = new Box(a.w, Math.min(a.h,a.d), Math.max(a.h,a.d));

        /* Fifth rotation of box*/
        rot[5] = new Box(a.d, Math.min(a.w,a.h), Math.max(a.w,a.h));

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < total.length; j++) {
                if(total[j].equals(a)){
                    return true;
                }
            }
        }
        return false;
    }

    static int maxBoxesIn(Box arr[]){

        int n = arr.length;
        Box[] rotations = new Box[n*6];

            /* New Array of boxes is created - considering all 3 possible rotations,
            with width always greater than equal
            to width */
        for(int i = 0;i < n;i++){
            Box box = arr[i];

            /* Orignal Box*/
            rotations[6*i] = new Box(box.h, Math.max(box.w,box.d), Math.min(box.w,box.d));

            /* First rotation of box*/
            rotations[6*i + 1] = new Box(box.w, Math.max(box.h,box.d), Math.min(box.h,box.d));

            /* Second rotation of box*/
            rotations[6*i + 2] = new Box(box.d, Math.max(box.w,box.h), Math.min(box.w,box.h));

            /* Third rotation of box*/
            rotations[6*i + 3] = new Box(box.h, Math.min(box.w,box.d), Math.max(box.w,box.d));

            /* Fourth rotation of box*/
            rotations[6*i + 4] = new Box(box.w, Math.min(box.h,box.d), Math.max(box.h,box.d));

            /* Fifth rotation of box*/
            rotations[6*i + 5] = new Box(box.d, Math.min(box.w,box.h), Math.max(box.w,box.h));
        }

            /* Calculating base volume of
            each of the boxes.*/
        for(int i = 0; i < rotations.length; i++)
            rotations[i].volume = rotations[i].w * rotations[i].d * rotations[i].h;

        // Sort boxes in decreasing volumes order
        Arrays.sort(rotations);

        int maxNbInside[] = new int[rotations.length];
        int i, j, max = 0;

        //Find longest decreasing subsequence (LDS)
        for (i = 0; i < rotations.length; i++)
            maxNbInside[i] = 0;

        // Compute the boxes
        for (i = 0; i < rotations.length; i++) {
            Box[] emballage = new Box[rotations.length];
            int place = 0;

            for (j = i; j < rotations.length; j++) {

                if (inside(rotations[j], rotations[i])) {
                    if(place != 0){
                        if(!alreadyIn(rotations[j], emballage)) {
                            System.out.println(rotations[j]);
                            maxNbInside[i]++;
                            emballage[place] = rotations[j];
                            place++;
                        }
                    }
                    else {
                        System.out.println("Test n°" + i + " " + rotations[j]);
                        maxNbInside[i]++;
                        emballage[place] = rotations[j];
                        place++;
                    }
                }
            }
        }

        // Select the maximum
        // of all the LDS values
        for (i = 0; i < maxNbInside.length; i++)
            if (max < maxNbInside[i])
                max = maxNbInside[i];


        return max;
    }


    public static void main(String[] args) {

        Box[] arr = new Box[7];
        arr[0] = new Box(1, 3, 12);
        arr[1] = new Box(4 , 3, 7);
        arr[2] = new Box(6, 3, 2);
        arr[3] = new Box(9, 9, 9);
        arr[4] = new Box(2,4,13);
        arr[5] = new Box(4,6,8);
        arr[6] = new Box(4,8,5);

        System.out.println(" Max number of boxes:" + maxBoxesIn(arr));
    }

}
