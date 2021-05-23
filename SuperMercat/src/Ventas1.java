/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author sergi
 */
public class Ventas1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //arry donde guardo la informacion
        String[] nombreProducto = {"Arroz", "Pizza", "Jugo", "Fideo", "Carne", "Pollo", "Pescado", "Harina", "Cebolla", "Atun"};
        double[] precioProducto = {12, 10, 7, 10, 15, 11, 13, 8, 2, 9};

        String continuar;
        String productoComprado = "";
        double precio = 0;
        double totalPagar = 0;
        int numeroProducto;
        int cantidad;

        do {
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
        System.out.println("Gracia por su compra");
    }

}
