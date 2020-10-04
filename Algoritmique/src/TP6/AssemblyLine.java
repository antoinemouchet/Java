package TP6;

/**
 * This class represents a set of M assembly lines, each with N machines. Each machine has a coordinate M(i, j) where i
 * is the index of the machine (between [0; N[) and j is the index of the assembly line (between [0; M[). The time took
 * by a machine M(i, j) to complete its task is designated by t(i,j). The time took to move a product at machine M(i, j)
 * to the next machine but on another line M(i + 1, j') is designated by d(i, j, j').
 */
public class AssemblyLine {
    /**
     * The time needed by each machine to complete its task.
     * Inv: time [0..N-1, 0..M-1] contains values >= 0.
     */
    private int[][]taskTime;

    /**
     * The time needed to move from machine M(i, j) to machine M(i+1, j2) == move[i][j][j2]
     * Inv: move[0..N-2, 0..M-1, 0..M-1] contains values >= 0 and
     * forall j in [0, M[ : move [0..N-2, j, j] == 0
     */
    private int [][][] moveTime;

    /**
     * Returns the time took by machine at index machineIdx in assemble line lineIdx to complete its task.
     * @requires machineIdx in [0, N[ and lineIdx in [0, M[
     * @ensures return == t(machineIdx, lineIdx)
     * @throws IndexOutOfBoundsException if one of the given parameter is out of the bonds.
     */
    public int getTaskTime(int machineIdx, int lineIdx){
        return taskTime[machineIdx][lineIdx];
    }

    /**
     * Returns the time took to move a product from machine at index machineIdx in assemble line sourceLineIdx
     * to machine at index machineIdx + 1 in assembly line destLineIdx
     * @requires machineIdx in [0, N[ and sourceLineIdx in [0, M[ and destLineIdx in [0, M[
     * @ensures return == d(machineIdx, sourceLineIdx, destLineIdx)
     * @throws IndexOutOfBoundsException if one of the given parameter is out of the bonds.
     */
    public int getMoveTime(int machineIdx, int sourceLineIdx, int destLineIdx) {
        return moveTime[machineIdx][sourceLineIdx][destLineIdx];
    }

    /**
     * Returns the minimal time took by the assembly lines to perform the nbTasks first tasks.
     * @requires nbTasks in [1, N] and lineIdx in [0, M[
     * @ensures return = T*(nbTasks, lineIdx + 1)
     * @throws IndexOutOfBoundsException if lineIdx is out of bounds
     * @throws IllegalArgumentException if nbTasks is not between 1 and N.
     */
    public int minimalTime(int nbTasks, int lineIdx){
        int min = 0;
        int machineIdx = nbTasks - 1;

        if (nbTasks == 1){
            return getTaskTime(0, lineIdx);
        }
        else {

            min = minimalTime(nbTasks - 1, 0) + getMoveTime(machineIdx - 1, 0, lineIdx );

            for (int k = 1; k < taskTime.length; k++) {

                int tmp = minimalTime(nbTasks - 1, k) + getMoveTime(machineIdx - 1, k, lineIdx );

                if(tmp < min){
                    min = tmp;
                }
            }
        }
        return min + getTaskTime(machineIdx, lineIdx);
    }

    /**
     * Returns the optimal time took by the assembly line to build a complete product.
     * @ensures return = T*(N, k) such as there exists no l in [0, M[ : T*(N, l) < T*(N, k)
     */
    public int optimalTime(){
        int min = minimalTime(taskTime[0].length,0);

        for (int j = 1; j < taskTime.length; j++) {
            int tmp = minimalTime(taskTime[j].length, j);

            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

}

