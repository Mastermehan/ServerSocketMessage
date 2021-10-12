import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;

public class Server {
    public static void main(String[] args)  {
        System.out.println("Сервер запущен");
        int port = 8086;

        while (true){
            try (
            ServerSocket serverSocket = new ServerSocket(port);//порт можете выбрать любой в доступном диапазоне 0-65536.
            // Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
            {
                System.out.println("New connection accepted");

                out.println(String.format("Как твое имя?", clientSocket.getPort()));
                String name = in.readLine();

                out.println(String.format("Тебе больше 18? (да/нет)", clientSocket.getPort()));
                String response = in.readLine();

                 switch (response) {
                    case "да" -> MessageFormat.format("Добро пожаловать в зону для взрослых, {0}. " +
                            "Хорошего отдыха или хорошего рабочего дня!", name, clientSocket.getPort());
                    default -> MessageFormat.format("Добро пожаловать в раздел для детей {0}. " +
                            "Давайте поиграем!", name, clientSocket.getPort());
                 };
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}

