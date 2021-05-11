import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

public class Super {
    public static void main(String[] args) {
        menuPrincipal();
        String [][] stock = new String [1000][3];
        while (stock != null);
        rellenaStock(stock);
    }
    public static void menuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        int opció = 0;
        do {
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
        while (opció > 4 || opció < 0);
        System.out.println("no és una opció correcta, escull entre");
    }
    public static void mostraMenuStock() {
        Scanner entrada = new Scanner(System.in);
        int opció = 0;
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
            mostraStock();
        } else if (opció == 3) {
            menuPrincipal();
        }
    }
    public static void menuAfegir(){
        Scanner entrada = new Scanner (System.in);
        String producte="";
        System.out.println("******************* SUPERMERCAT *********************");
        System.out.println(" ");
        System.out.println("----------------  Afegir productes  -----------------");
        System.out.println(" ");
        System.out.println("    Codi          Nom del producte         Preu      ");
        System.out.println("   ------       -------------------       ------     ");

        try{
            FileWriter fw = new FileWriter("/Users/eduardoroldan/IdeaProjects/Project-Super-Mercat/SuperMercat/src/Stock.txt",true);
            fw.write(producte);
            fw.close();
        }
        catch(IOException ex){
            System.out.println("fitxer no trobat");
        }

    }
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
         //   començaTicket();
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
    public static void rellenaStock(String[][]stock){
        String palabra="";
        int x=0;
        int y=0;
        try(Scanner entradaStock = new Scanner (new File("/Users/eduardoroldan/IdeaProjects/Project-Super-Mercat/SuperMercat/src/Stock.txt"))){
        while(entradaStock.hasNext()){
            palabra=entradaStock.next();
            stock[x][y]=palabra;
            y++;
            if(y==3){
                x++;
                y=0;
            }
        }
        }
        catch(FileNotFoundException e){
            System.out.println(e);

        }
        String producte="";
        for (int n = 0; n < stock.length; n++){
            for (int j = 0; j < stock[n].length; j++){
               // stock[n][j]=;
            }
        }
    }
    public static void mostraStock(){
        int volver;
        Scanner entrada = new Scanner(System.in);
        File stock = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            stock = new File("Stock.txt");
            fr = new FileReader("/Users/eduardoroldan/IdeaProjects/Project-Super-Mercat/SuperMercat/src/Stock.txt");
            br = new BufferedReader(fr);
            String mostraStock;
            while ((mostraStock = br.readLine()) != null)
                System.out.println(mostraStock);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println("per tornar, prem 4");
        volver=entrada.nextInt();
        mostraMenuStock();
    }

    /*public static void mostraAfegir(){
        String producte="";
        try{
            FileWriter fw = new FileWriter("/Users/eduardoroldan/IdeaProjects/Project-Super-Mercat/SuperMercat/src/Stock.txt",true);
            fw.write(producte);
            fw.close();
        }
        catch(IOException ex){
            System.out.println("fitxer no trobat");
        }

    }
*/
}

