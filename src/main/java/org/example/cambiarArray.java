package org.example;

public class cambiarArray {

    public static void reverse(int[] array){
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            i++;
            j--;
        }
    }
}
