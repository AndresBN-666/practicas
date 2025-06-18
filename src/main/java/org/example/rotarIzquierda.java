package org.example;

public class rotarIzquierda {
    public static void rotarIzquierda(int[] array, int inicio, int fim){
        if(inicio < 0 || fim >= array.length || inicio > fim)return;
        int indice =array[inicio];
        for(int i = inicio; i< fim ; i ++){
            array[i] = array[i + 1];
        }
        array[fim] = indice;
    }
}
