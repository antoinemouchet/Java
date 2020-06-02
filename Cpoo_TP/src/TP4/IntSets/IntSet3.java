package TP4.IntSets;

import Exceptions.EmptyException;

import java.util.ArrayList;
import java.util.List;

/**
 * @overview Les IntSets sont des ensembles non bornés d'entiers.
 * Ils sont mutables.
 * De manière générale, un IntSet est défini comme {x1, xi,...,xn}
 * avec 0 < i <= n et n = size où size = cardinalité de l'IntSet
 * @invariant size toujours positif
 */
public class IntSet3 {

    private boolean[] els;
    private List<Integer> otherEls;
    private int sz;

    /**
     * FA(c): {c.otherEls[i].intValue | 0 <= i < c.otherEls.size()}
     * &&
     * {j | 0 <= j < 100 && c.els[j]}
     */

    /**
     * IR(c): c.els != null && c.otherEls != null && c.els.length == 100 &&
     * for all integer i, 0 <= i < c.otherEls.size(), c.otherEls[i] is an Integer &&
     * for all integer i, 0 <= i < c.otherEls.size(), c.otherEls[i] is not in range [0,99] &&
     * for all integer i,j, 0 <= i <= j < c.otherEls.size(), i != j => c.otherEls[i] != c.otherEls[j] &&
     * c.sz = c.otherEls.size() + (count of true entries in c.els)
     */

    /**
     * @effects initialise this à l'ensemble vide.
     * this.sz = 0 et this.els = liste de booléens.
     */
    public IntSet3(){
        els = new boolean[100];
        otherEls = new ArrayList<>();
        sz = 0;
    }

    /**
     * @effects initialise this en fonction des valeurs présentes dans c.
     * Constructeur par copie
     */
    public IntSet3(IntSet3 c){
        sz = c.sz;
        els = new boolean[100];
        otherEls = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            if(c.els[i]){
                els[i] = true;
            }
        }

        for (Integer i : otherEls) {
            otherEls.add(i);
        }
    }

    /**
    * @modifies this
    * @effects this_post = this U {x}
    */
    public void insert(int x){
        if(!isIn(x)){
            if(x >= 0 && x <= 99){
                els[x] = true;
            }
            else{
                otherEls.add(x);
            }
            sz++;
        }
    }

    /**
     * @modifies this
     * @effects this_post = this \ {x}
     */
    public void remove(int x){
        if(isIn(x)){
            sz--;
            if(x >= 0 && x <= 99){
                els[x] = false;
            }
            else{
                otherEls.remove((Object) x);
            }
        }
    }


    /**
     * @return true if x appartient à this, renvoie false sinon
     */
    public boolean isIn(int x){
        if(x >= 0 && x <= 99){
            return els[x];
        }
        else
            return otherEls.contains(x);
    }

    /**
     * @return la cardinalité de this.
     */
    public int size(){
        return sz;
    }

    /**
     * @return x tq x appartient à this.
     * @throws EmptyException si this = {}.
     */
    public int choose() throws EmptyException{
        if(sz == 0){
            throw new EmptyException("IntSet3.choose() - Empty IntSet");
        }
        else{
            if(otherEls.size() != 0){
                return otherEls.get(0);
            }
            else{
                for (int i = 0; i < 100; i++) {
                    if(els[i]){
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    public boolean repOK()  {
        if(els == null)return false;
        if(otherEls == null)return false;
        if(els.length!=100)return false;
        IntSet3 tmp = new IntSet3();
        for (Object o: otherEls) {
            if (! (o instanceof Integer))return false;
            int n = (Integer)o;
            if (n >= 0 && n <= 99)return false;
            if(tmp.isIn(n))return false;
            tmp.insert(n);
        }
        int compteurTableau=0;
        for(int i=0;i<=99;i++){
            if(els[i])compteurTableau++;
        }
        if(compteurTableau+otherEls.size() != sz)return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (sz == 0 ) {
            sb.append("IntSet : {}");
        }
        else {
            sb.append("IntSet : {");
            for(int i=0;i<=99;i++){
                if(els[i])sb.append(i+",");;
            }
            for(Integer i : this.otherEls) {
                sb.append(i+",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("}");
        }
        return sb.toString();
    }
}
