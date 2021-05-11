import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Super2 {
    public static void main(String[] args) throws IOException {

        Datos("D:\\sergi\\Documents\\IdeaProjects\\Project-Super-Mercat\\SuperMercat\\src\\Stock.txt");
        Ventas.main();

    }

   /* void menuPrincipal(){
        System.out.println("Gestio de supermercat");
        System.out.println("1. Gestio Stock");
        System.out.println("2.");
    }*/

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
