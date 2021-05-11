import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Ventas {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        String continuar;
        String productoComprado = "";
        double precio = 0;
        double totalPagar = 0;
        int numeroProducto;
        int cantidad;
        File archivo = null;
        FileReader Fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("C:\\Users\\sergi\\Google Drive\\ASIX-1 20-21\\ASIX M03\\UF03\\SuperMercat\\src\\supermercat\\Stock.txt");
            Fr = new FileReader(archivo.toString());
            br = new BufferedReader(Fr);
            String linea;
            String delimiter = ",";
            //Matriz estática
            String matriz[][] = new String[10][1];
            //Cuenta las líneas y a la vez sería el número de filas
            int numlinea=0;
            //validación si existe línea
            while (((linea = br.readLine()) != null)) {
                //Imprime la línea
                System.out.println(linea);
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
            System.out.println("MATRIZ");
            System.out.println("------");
            for (int filas = 0; filas < matriz.length; filas++) {
                for (int colum = 0; colum < matriz[filas].length; colum++) {
                    //Imprime las columnas de cada fila
                    System.out.print(matriz[filas][colum]+" ");
                }
                //Imprime uns alto de línea para cada fila
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
       /* do {
            //el numero del articulo hace referencia ala posicion del nombre del producto
            System.out.print("Igrese el numero del articulo que desea comprar: ");
            numeroProducto = Integer.parseInt(sc.nextLine());

            System.out.print("Igrese la cantidad que desea comprar: ");
            cantidad = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < 10; i++) {
                productoComprado = nombreProducto[numeroProducto - 1];
                //le precio hace lo mismo con el numero del porducto
                precio = precioProducto[numeroProducto - 1];
            }
            totalPagar = cantidad * precio;
            System.out.println("compro el articulo " + productoComprado + " total pagar " + totalPagar);
            System.out.print("Desea comprar otro producto (S/N): ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        System.out.println("Gracia por su compra");*/
    }
}
