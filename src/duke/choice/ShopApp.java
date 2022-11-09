package duke.choice;

import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;
// import java.util.logging.Level;
// import java.util.logging.Logger;

public class ShopApp {
    public static void main(String[] args) {
        Customer c1 = new Customer("Pinky", 3);

        Clothing[] items = new Clothing[4];
        items[0] = new Clothing("Blue Jacket", 20.9, "M");
        items[1] = new Clothing("Orange T-Shirt", 10.5, "S");
        items[2] = new Clothing("Green Scarf", 5, "S");
        items[3] = new Clothing("Blue T-Shirt", 10.5, "S");

        c1.addItems(items);

        System.out.println("Welcome to Duke Coice Shop");
        System.out.println("Minimum Price is " + Clothing.MIN_PRICE + " and Tax Rate is " + Clothing.TAX_RATE);

        System.out.println("Customer is: " + c1.getName() + ", Size: " + c1.getSize() + ", Total (Tax included): "
                + c1.getTotalClothingCost() + ", Average Clothing Cost: " + c1.getAverageClothingCost());

        Arrays.sort(c1.getItems());
        for (Clothing item : c1.getItems()) {
            System.out.println(item);
        }

        try {
            ItemList list = new ItemList(items);

            Routing routing = Routing.builder().get("/items", list).build();

            ServerConfiguration config = ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();

            WebServer ws = WebServer.create(config, routing);

            ws.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
