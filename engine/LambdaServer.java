import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

//Method to declare endpoint and
public class LambdaServer {
    public static void main(String[] args) throws IOException{

        HttpServer server=HttpServer.create(new InetSocketAddress(8080),0);

        server.createContext("/checkout", exchange -> {

            //CORS configuration to avoid issues
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");

            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            //get JSON body send by TypeScript
            InputStream is = exchange.getRequestBody();
            String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println("JSON received from TypeScript : " + body);

            //give an answer to TypeScript to confirm the parcel
            sendResponse(exchange, "JSON received from backend!");
        });

        server.setExecutor(null);
        server.start();
        System.out.println("Server listening on port : 'http://localhost:8080/checkout'");
    }

    //send response method from HttpServer
    private static void sendResponse(HttpExchange exchange, String response) throws IOException {
        byte[] bytes = response.getBytes("UTF-8");
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}


