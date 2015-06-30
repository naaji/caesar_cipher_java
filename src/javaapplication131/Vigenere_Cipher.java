/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication131;

import java.util.Scanner;


public class Vigenere_Cipher {

    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static void main(String[] args) {
    
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Please enter your message:");
            char[] arr = input.nextLine().toUpperCase().toCharArray();
            System.out.println("Please enter your keyword:");
            char[] KeyArr = input.nextLine().toUpperCase().toCharArray();
            System.out.println("Encrypted message:");
            encrypt(arr, KeyArr);
            System.out.println();
            input.close();
        }    
    }
    
    public static boolean isLetter(Character x){
        for(int i=0; i<alphabet.length(); i++){
            if(x==alphabet.charAt(i)){
                return true;
            }
        }
        return false;
    }
    
    public static int abdoInt(Character x){
        for(int i=0; i<alphabet.length(); i++){
            if(x==alphabet.charAt(i)){
                return i;
            }
        }
        return 0;
    }
    
    public static int abdoMS(int x){
        while(x>alphabet.length()){
            return abdoMS(x-alphabet.length());
        };
        while(x<0){
                return abdoMS(alphabet.length()+x);
            }        
        return x;
    }
    
    public static void encrypt(char[] a, char[] b){
        int q = 0;
        for(int i=0; i<a.length; i++){
            if(isLetter(a[i])){
                if(q==b.length){
                    q=0;}
                    a[i] = alphabet.charAt(abdoInt(alphabet.charAt(abdoMS(abdoInt(a[i])+abdoInt(b[q])))));
                    q++;
            }
        }
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]);
        }
    }
}