package TCP_UDP.uppgift3a;

import java.io.IOException;
import java.net.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainSender {
    Path myPath = Paths.get("src/TCP_UDP/uppgift3a/quotes.txt");
    List<String> qouteList = new ArrayList<>();
    String tempLine = "";
    int counter = 0;
    public mainSender() throws IOException, InterruptedException {
        try{
            Scanner scanner = new Scanner(myPath);
            while (scanner.hasNext()){
                tempLine = scanner.nextLine();
                qouteList.add(tempLine);
                //System.out.println(qouteList.get(0));
        }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        InetAddress toAdress = InetAddress.getLocalHost();
        int toPort = 55555;
        DatagramSocket socket = new DatagramSocket();
        while (true){
            System.out.println("Sending Data....");
            byte[] data = qouteList.get(counter).getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdress, toPort);
            socket.send(packet);
            counter = (counter + 1) % 6; //Number of qoutes sent
            Thread.sleep(5000);
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException { mainSender m = new mainSender(); }
}
