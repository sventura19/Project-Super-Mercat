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
public class ventasA {
    public static void main(String[] args) {
        mostraMenuCompra();
    }
    public static void mostraMenuCompra() {
        int codi = 0;
        int quantitat = 0;
        Scanner entrada = new Scanner(System.in);
        String[][] stock = new String[1000][3];
        int[][] dadesTicket = new int[1000][2];
        int numeroLinea = 0;
        String palabra = "";
        int x = 0;
        int y = 0;
        try (Scanner entradaStock = new Scanner(new File("D:\\sergi\\Documents\\IdeaProjects\\Project-Super-Mercat\\SuperMercat\\src\\Stock.txt"))) {
            while (entradaStock.hasNext()) {
                palabra = entradaStock.next();
                stock[x][y] = palabra;
                y++;
                if (y == 3) {
                    x++;
                    y = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("error inesperat");
            System.out.println(e);
        }
        do {
            System.out.println("******************* SUPERMERCAT *********************");
            System.out.println(" ");
            System.out.println("---------------------  Vendes  ----------------------");
            System.out.println(" ");
            System.out.println("---------------------- Compra -----------------------");
            System.out.println(" ");
            System.out.println("            Introdueix el ID del producte            ");
            System.out.println("           -------------------------------           ");
            codi = entrada.nextInt();
            if (codi == -1){
                System.out.println("Processant tiquet...");
                System.out.println(" ");
                break;
            }
            System.out.println("               Introdueix la quantitat               ");
            System.out.println("              -------------------------              ");
            quantitat = entrada.nextInt();
            llenarTicket(codi, quantitat, dadesTicket, numeroLinea);
            numeroLinea++;

        }
        while (codi != -1);
        System.out.println("**************************** SUPERMERCAT ******************************");
        System.out.println(" ");
        System.out.println("------------------------------ Tiquet ---------------------------------");
        System.out.println(" ");
        System.out.println("NomProducte    Preu/Untitat       Quantitat          Preu Total  ");
        System.out.println("------------  --------------     -----------       --------------");
        String nomProducte;
        double preuUnitat;
        int quantia;
        double preuTotal;
        double suma=0;
        int codi2;
        String [] dadesProducteVect = new String [3];
        //stock: Codi, nomProducte, preuUnitat
        //dadesTicket: codi, quantitat
        for (int n =0; n < numeroLinea; n++) {
            codi2 = dadesTicket[n][0];
            quantia = dadesTicket[n][1];
            dadesProducteVect = buscaLinea(codi2, stock, x);
            nomProducte = dadesProducteVect[1];
            preuUnitat = Double.parseDouble(dadesProducteVect[2]);
            preuTotal = quantia * preuUnitat;
            suma += preuTotal;
            System.out.printf("%-17s %-19.2f %-15d %-10.2f \n",nomProducte,preuUnitat,quantia,preuTotal);
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("                Preu Total -------------------->      %.2f",suma);
        System.out.println(" ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                       Tornar al menu principal?");
        System.out.println("               1.si                                2. no");
        System.out.println("-------------------------------------------------------------------------");

        int opció = entrada.nextInt();
        if(opció == 1){
            Super.menuPrincipal();
        }
        if (opció == 2){
            System.out.println("             Grácies per utilitzar el nostre servei :)");
            System.out.println("----------------------------------------------------------------------");
            System.exit(0);
        }

    }
    public static void llenarTicket(int codi, int quantitat, int [][] ticket,int contador){
        ticket[contador][0] = codi;
        ticket[contador][1] = quantitat;
    }
    public static String [] buscaLinea(int codi, String [][] stock, int x){
        String [] vect = {"null","null","null"};
        for (int n =0; n < x; n++){
            int codiLinea = Integer.parseInt(stock[n][0]);
            if (codi == codiLinea){
                return stock[n];
            }
        }
        return vect;
    }
}