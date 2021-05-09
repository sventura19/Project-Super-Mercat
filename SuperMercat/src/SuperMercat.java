import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SuperMercat {
    public static void main (String [] args) throws IOException {

        Datos("Stock.txt");
        segon.saluda();
        //leerStock();
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