import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8086;

        try (Socket clientSocket = new Socket(host,port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
        {
            out.println("Евгений");
            String resp = in.readLine();
            System.out.println(resp);

            out.println("да");
            String request = in.readLine();
            System.out.println(request);

            String welcome = in.readLine();
            System.out.println(welcome);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


