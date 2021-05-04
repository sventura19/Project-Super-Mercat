import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class SuperMercat {
    public static void main(String[] args) throws IOException {

        Datos("D:\\sergi\\Documents\\IdeaProjects\\XML\\Supermercat\\src\\Stock.txt");
        segon.saluda();
        //leerStock();
    }

    void menuPrincipal(){
        System.out.println("Gestio de supermercat");
        System.out.println("1. Gestio Stock");
        System.out.println("2.");
    }
/*
    static void leerStock(){
        Scanner e = new Scanner(System.in);

        String p;

            p = e.next();
            System.out.println(p);

            p = e.next();
            System.out.println(p);

            p = e.next();
            System.out.println(p);

        while (p.equals("-1"));
    }

     */

    public static void Datos(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }
}