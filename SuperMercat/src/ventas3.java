/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author sergi
 */
public class ventas3 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("D:\\sergi\\Documents\\IdeaProjects\\Project-Super-Mercat\\SuperMercat\\src\\Stock.txt");
        File file2= new File("D:\\sergi\\Documents\\IdeaProjects\\Project-Super-Mercat\\SuperMercat\\src\\Stock2.txt");
        int n=-1;
        String lineaA, cont;
        int opcion;
        BufferedReader reader=new BufferedReader(new FileReader(file2));
        lineaA=reader.readLine();
        String[] arry = lineaA.split("\t");

        try {

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                n++;
                String line = sc.nextLine();
                System.out.println("Linea: "+n+" = "+line);
            }
                Scanner leer = new Scanner(System.in);
                System.out.println("-----------------------------------------------");
                System.out.print("Seleccione una opcion 0-9: ");
                opcion=leer.nextInt();
                System.out.println("-----------------------------------------------");
                System.out.println("La opcion "+opcion+" contiene la cadena: "+arry[opcion]);
                System.out.println("-----------------------------------------------");
                System.out.print("¿Desea continuar? (S/N)");
                cont =leer.next();
                if (cont.equalsIgnoreCase("s"))
                    main(null);
                else
                    System.exit(0);
                
                }catch (FileNotFoundException ex) {
                System.out.println("No s'ha pogut trobar el fitxer: Stock.txt");
                System.out.println(ex);
        }
                catch (Exception e) {
                System.out.print("Opcion no valida: " +"\n");
                System.out.println("-----------------------------------------------");
                main(null);
                }
    
    }
}