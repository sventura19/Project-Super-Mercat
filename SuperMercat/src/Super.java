import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Super {
    /* he decidido poner el menú principal como una función ya que, creo que es más cómodo poder manipular el código
    desde una función y mantener el main solamente con ello.
     */
    public static void main(String[] args) {
        menuPrincipal();
    }
    public static void menuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        int opció = 0;
            System.out.println("******************* SUPERMERCAT *********************");
            System.out.println(" ");
            System.out.println("------------------ Menú principal -------------------");
            System.out.println(" ");
            System.out.println("----------------- Escull una opció ------------------");
            System.out.println(" ");
            System.out.println("                    1. Stock                         ");
            System.out.println("                    2. Vendes                        ");
            System.out.println("                    3. Ajuda                         ");
            System.out.println("                    4. Sortida                       ");
            System.out.println(" ");
            System.out.println("-----------------------------------------------------");
            opció = entrada.nextInt();
            /*
            dentro del menú he añadido una opción extra de ayuda, en caso de que el usuario no tenga claro el qué hace cada opción.
            * todo hecho con condicionales para comodidad.
             */
            if (opció == 1) {
                mostraMenuStock();
            } else if (opció == 2) {
                mostraMenuVendes();
            } else if (opció == 3) {
                mostraAjuda();
            } else if (opció == 4) {
                System.exit(0);
            }
    }
    /*
    en la función mostraMenuStock he montado la primera parte ya preparada para registrar y almacenar los productos
    se crea la matriz para almacenar y mostrar los productos. Ésta misma parte se utilizará para el código de ventas y la
    generación del ticket.
     */
    public static void mostraMenuStock() {
        Scanner entrada = new Scanner(System.in);
        String[][] stock = new String[1000][3];
        String palabra = "";
        int x = 0;
        int y = 0;
        try (Scanner entradaStock = new Scanner(new File("/Users/eduardoroldan/IdeaProjects/Project-Super-Mercat/SuperMercat/src/Stock.txt"))) {
            while (entradaStock.hasNext()) {
                palabra = entradaStock.next();
                stock[x][y] = palabra;
                y++;
                if (y == 3) {
                    x++;
                    y = 0;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        int opció = 0;
        do {
            System.out.println("******************* SUPERMERCAT *********************");
            System.out.println(" ");
            System.out.println("---------------------  Stock  -----------------------");
            System.out.println(" ");
            System.out.println("----------------- Escull una opció ------------------");
            System.out.println(" ");
            System.out.println("                    1. Afegir                        ");
            System.out.println("                    2. Consultar                     ");
            System.out.println("                    3. Sortir                        ");
            System.out.println(" ");
            System.out.println("-----------------------------------------------------");
            opció = entrada.nextInt();
            if (opció == 1) {
                menuAfegir();
            } else if (opció == 2) {
                mostraArrayStock(stock, x);
            } else if (opció == 3) {
                menuPrincipal();
            }
        }
        while (opció != 3);
    }
    public static void menuAfegir(){
        Scanner entrada = new Scanner (System.in);
        String producte="";
            System.out.println("******************* SUPERMERCAT *********************");
            System.out.println(" ");
            System.out.println("----------------  Afegir productes  -----------------");
            System.out.println(" ");
            System.out.println("Codi - Nom del producte - Preu");
            producte = entrada.nextLine();
        try{
            FileWriter fw = new FileWriter("/Users/eduardoroldan/IdeaProjects/Project-Super-Mercat/SuperMercat/src/Stock.txt",true);
            fw.write(producte);
            fw.write("\r\n");
            fw.close();
        }
        catch(IOException ex){
            System.out.println("fitxer no trobat");
        }
    }
    public static void mostraArrayStock(String[][]stock, int x){
        System.out.println("******************* SUPERMERCAT *********************");
        System.out.println(" ");
        System.out.println("----------------  Afegir productes  -----------------");
        System.out.println(" ");
        System.out.println("Codi           Nom del producte         Preu      ");
        System.out.println("-----         ------------------       ------      ");
        for (int n =0; n < x; n++){
            for (int j =0; j < 3; j++){
                System.out.printf("%-20s",stock[n][j]);
            }
            System.out.println("");
        }
        System.out.println(" ");
        System.out.println("------------------------------------------------------");
        System.out.println(" ");
    }
    /*
    el código lo hemos pasado fuera del código principal porque ponerlo aquí saturaría y sería más lioso de entender.
    lo llamo a través de otro archivo.
     */
    public static void mostraMenuVendes(){
        Scanner entrada = new Scanner (System.in);
        int opció=0;
        System.out.println("******************* SUPERMERCAT *********************");
        System.out.println(" ");
        System.out.println("---------------------  Vendes  ----------------------");
        System.out.println(" ");
        System.out.println("----------------- Escull una opció ------------------");
        System.out.println(" ");
        System.out.println("               1. Començar la compra                 ");
        System.out.println("               2.       Sortir                       ");
        System.out.println(" ");
        System.out.println("-----------------------------------------------------");
        opció=entrada.nextInt();
        if(opció == 1){
            ventasEdu.mostraMenuCompra();
        }
        else if (opció == 2){
            menuPrincipal();
        }
    }
    public static void mostraAjuda(){
        Scanner entrada = new Scanner(System.in);
        int opció;
        System.out.println("******************* SUPERMERCAT *********************");
        System.out.println(" ");
        System.out.println("---------------------- Ajuda ------------------------");
        System.out.println(" ");
        System.out.println("    1. Gestió de stock, control del stock, afegir    ");
        System.out.println("    2. Procés de venda i generació de tiquet         ");
        System.out.println("    3.            Pistes per orientar                ");
        System.out.println("                    4. Torna                         ");
        System.out.println(" ");
        System.out.println("-----------------------------------------------------");
        System.out.print("");
        opció=entrada.nextInt();
        if (opció == 4){
            menuPrincipal();
        }
    }
}

