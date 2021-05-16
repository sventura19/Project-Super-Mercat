import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Ventas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero=0;
        File archivo = null;
        //File txt = new File("Stock.txt");
        FileReader Fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("C:\\Users\\sergi\\Google Drive\\ASIX-1 20-21\\ASIX M03\\UF03\\SuperMercat\\src\\supermercat\\Stock.txt");
            Fr = new FileReader(archivo.toString());
            //Fr = new FileReader(txt.toString());
            br = new BufferedReader(Fr);
            String linea;
            String delimiter = ",";
            //Matriz estática
            String matriz[][] = new String[20][1];
            //Cuenta las líneas y a la vez sería el número de filas
            int numlinea=0;
            //validación si existe línea
            while (((linea = br.readLine()) != null)) {
                //Imprime la línea
                System.out.println("Numero "+numero+linea);
                //Guardar datos de linea en Array
                String a[]=linea.split(delimiter);
                //Bucle para poder ingresar todas las columnas del Array "a" que existan. TODAS.
                for (int l = 0; l < a.length; l++) {
                    //ingresamos los datos de cada columna de "a" a la matriz.
                    //"numlinea" hace de fila, "l" es el numero de la columna.
                    matriz[numlinea][l] = a[l];
                    //Prueba de que los datos están llenando la fila de la matriz.
                    //System.out.print(matriz[numlinea][l]+" ");
                }
                //Incremento de numero de línea.
                numlinea++;
            }
            //Impresión de la matriz
            /*
            System.out.println("MATRIZ");
            System.out.println("------");
            for (int filas = 0; filas < matriz.length; filas++) {
                for (int colum = 0; colum < matriz[filas].length; colum++) {
                    //Imprime las columnas de cada fila
                    System.out.print(matriz[filas][colum]+" ");
                }
                //Imprime uns alto de línea para cada fila
                System.out.println();
            }*/
            /*
            String arr = matriz[1][0];
            System.out.println(""+arr);
            */
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
