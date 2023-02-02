/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ipc1_s12023_practica1_202203069;


import java.util.Scanner;

/**
 *
 * @author bruce
 */
public class Tester {
    
    public static void main(String[] args) {
    
    int[] array = new int[] {2, 1, 5, 3, 4};
    boolean isSorted = false;

    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] < array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          isSorted = false;
        }
      }
    }

    
    
    }
}
