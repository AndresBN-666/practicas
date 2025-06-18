package org.example;

public class moverSoloPorRango {
    public static void moverRango(int[] array, int start, int end) {

        if(start < 0 || end > array.length || start > end) return;
        int last = array[end];
        for(int i = end ; i < start; i--) {
            array[i] = array[i -1];
        }
        array[start] = last;
    }

}
