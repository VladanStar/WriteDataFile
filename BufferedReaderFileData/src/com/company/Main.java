package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            new Main();
        } catch (IOException ex) {
            System.out.println("Došlo je do greške");
        }
    }

    public void upisiUFajlBrojeve() {
        //Upisivanje brojeva u fajl
        PrintWriter upisUFajl;
        try {
            upisUFajl = new PrintWriter("brojevi.txt");
            for (int i = 1; i <= 10; i++) {
                upisUFajl.println(i);
            }
            upisUFajl.close();
        } catch (FileNotFoundException e) {
            System.out.println("Došlo je do greške");
        }
    }

    public Main() throws IOException {
        upisiUFajlBrojeve();
        int[] array = ucitajBrojeveUNiz();
        upisiNizUFajl(array);

    }

    public void upisiNizUFajl(int[] array){
        PrintWriter upisUFajl;
        try {
            upisUFajl = new PrintWriter("brojevi.txt");
            for (int i = 0; i < array.length; i++) {
                upisUFajl.println(array[i]*5);
            }
            upisUFajl.close();
        } catch (FileNotFoundException e) {
            System.out.println("Došlo je do greške");
        }
    }

    public int[] ucitajBrojeveUNiz() throws IOException {
        int[] array = new int[10];
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("brojevi.txt"));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                array[i] = Integer.parseInt(line);
                i++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Došlo je do greške");
        } catch (IOException ex) {
            System.out.println("Došlo je do greške");
        }
        return array;
    }
}
