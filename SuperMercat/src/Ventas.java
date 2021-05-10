import java.util.Scanner;
public class Ventas {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        //arry donde guardo la informacion
        String[] nombreProducto = {"Arroz", "Pizza", "Jugo", "Fideo", "Carne", "Pollo", "Pescado", "Harina", "Cebolla", "Atun"};
        double[] precioProducto = {12.3, 10, 7.21, 10.5, 15.9, 11.12, 13.7, 8.32, 2.99, 9.67};

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
