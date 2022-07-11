package exercicio_aula_143.order.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exercicio_aula_143.order.entitites.Client;
import exercicio_aula_143.order.entitites.Order;
import exercicio_aula_143.order.entitites.OrderItem;
import exercicio_aula_143.order.entitites.Product;
import exercicio_aula_143.order.enums.OrderStatus;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name:");
        String name = in.nextLine();
        System.out.print("E-mail:");
        String email = in.nextLine();
        System.out.print("Birth date:");
        Date birthDate = spdf.parse(in.next());

        Client client = new Client(name, email, birthDate);
        
        System.out.println();

        System.out.println("Enter order data:");
        System.out.print("Status:");
        OrderStatus status = OrderStatus.valueOf(in.next());
        System.out.print("How many items to this order?");
        Integer quantityOrder = in.nextInt();

        Order order = new Order(new Date(), status, client);

        for(int i=1; i<=quantityOrder; i++){
            System.out.println("Enter " + i + " item data:");
            System.out.print("Product name:");
            in.nextLine();
            String productName = in.nextLine();
            System.out.print("Price:");
            Double price = in.nextDouble();
            System.out.print("Quantity:");
            Integer quantity = in.nextInt();

            Product p = new Product(productName, price);
            OrderItem item = new OrderItem(quantity, p.getPrice(), p);

            order.addItem(item);
        }

        System.out.println(order.toString());
        
        in.close();
    }
}
