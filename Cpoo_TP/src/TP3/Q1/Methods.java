package TP3.Q1;

import Exceptions.NegativeArgumentException;
import Exceptions.NotFoundException;

import java.util.ArrayList;

public class Methods {
    /**
    * @requires n and d positive integers
    * @return gcd of n and d
    * @throws NegativeArgumentException if n or d <= 0
    */
    public static int pgcd(int n, int d) throws NegativeArgumentException{

        // Make sure parameters respect @requires
        if(n <= 0 || d <= 0){
            throw new NegativeArgumentException("Methods.pgcd");
        }

        // Compute GCD using Euler's algorithm
        if(n % d != 0){
            return pgcd(d, n % d);
        }
        return d;
    }

    /**
    * @requires a != null & a.length > 0
    * @return greatest element of a
    */
    public static int greatest(int[] a){
        // Setup max as the lowest integer possible
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if(max < a[i]){
                max = a[i];
            }
        }
        return max;
    }

    /**
    * @requires a != null && a.length > 0 and a array of integers
    * @return sum of elements of a
    */
    public static int sum(int[] a){
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    /**
    * @requires p an integer
    * @return true if p is even, false otherwise
    */
    public static boolean isEven(int p){
        return p % 2 == 0;
    }

    /**
    * @requires p a positive integer
    * @return true if p is prime, false otherwise
    */
    public static boolean isPrime(int p){
        if(p <= 1){
            return false;
        }
        for (int i = 2; i * i < p; i++) {
            if(p % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
    * @requires a and b arrays of integers, a != null && b != null && a.length > 0 && b.length > 0
    * @modifies a
    * @effects each element of a is multiplied by the sum of the elements of b
    */
    public static void combine(int[] a, int[] b){
        int factor = sum(b);

        for (int i = 0; i < a.length; i++) {
            a[i] *= factor;
        }
    }

    /**
    * @requires x: an integer, a: a sorted array of integers && a != null && a.length > 0
    * @throws NotFoundException if x not in a
    * @return index of x inside a
    */
    public static int search(int[] a, int x) throws NotFoundException{
        for (int i = 0; i < a.length; i++) {
            if(a[i] == x){
                return i;
            }
        }
        throw new NotFoundException("Methods.search (x not in a)");
    }
}
