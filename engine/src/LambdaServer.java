package src;
import com.sun.net.httpserver.HttpServer;
import src.model.*;
import src.receipt.ReceiptBuilder;
import src.receipt.ReceiptDirector;
import src.receipt.TextReceiptBuilder;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

//Method to declare endpoint and get a receipt from typescript
public class LambdaServer {
    public static void main(String[] args) throws IOException{

        HttpServer server=HttpServer.create(new InetSocketAddress(8080),0); //create port 8080

        server.createContext("/checkout", exchange -> { //give the url path

            //CORS configuration to avoid issues
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");

            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

                    if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {

                        String query = exchange.getRequestURI().getQuery(); //take points from url
                        int points = 0;
                        if (query != null && query.contains("points=")) {
                            points = Integer.parseInt(query.replace("points=", "").trim());
                        }

                        Cart cart = new Cart(); //instanciation
                        cart.addLine(new CartLine(new Product("POO1", "Coca",2.50, Category.DRINKS), 3));
                        cart.addLine(new CartLine(new Product("P002", "Pizza",8.00, Category.FOOD), 1));

                        Fidelity fidelity = new Fidelity(points);

                        Checkout checkout = new Checkout();
                        ReceiptBuilder builder = new TextReceiptBuilder();
                        ReceiptDirector director = new ReceiptDirector(builder);

                        director.makeReceipt(cart, fidelity, checkout);

                        System.out.println("\n--- TICKET REÇU DEPUIS TYPESCRIPT ---"); //display receipt
                        System.out.println(builder.getResult());
                        System.out.println("-------------------------------------\n");

                        checkout.updateCard(cart, fidelity);

                        byte[] ok = "OK".getBytes(StandardCharsets.UTF_8);
                        exchange.sendResponseHeaders(200, ok.length);
                        exchange.getResponseBody().write(ok);
                        exchange.getResponseBody().close();
                    }
        }
        );

        server.setExecutor(null);
        server.start();
        System.out.println("Server listening on port : 'http://localhost:8080/checkout'");

}
}


