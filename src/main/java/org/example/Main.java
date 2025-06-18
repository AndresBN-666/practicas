package org.example;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void rotar(int[] array, int n){
        int numero = array.length;
        n = n % numero;

        for (int r = 0; r < n; r++) {
            int primer = array[0];

            for (int i = 0 ; i <numero - 1 ; i++ ){
                array[i] = array[i+1];
            }
            array[numero-1] = primer;
        }




    }


  /*  public static void main(String[] args) {

        String str = " Inside Main";
        String subs = str.substring(0, 6);
        System.out.println(subs);
        long n = subs.trim().length();
        System.out.println(n);
  *//*      Scanner sc = new Scanner(System.in);
        int [] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int inicio = sc.nextInt();
        int fim = sc.nextInt();

        rotarIzquierda.rotarIzquierda(arr, inicio, fim);
        //moverSoloPorRango.moverRango(arr, inicio, fim);

        //cambiarArray.reverse(arr);
        //int steps = Integer.parseInt(sc.nextLine());
        //rotar(arr, steps);

        for (int i : arr){
            System.out.print(i + " ");
        }

*//*
    }*/


}