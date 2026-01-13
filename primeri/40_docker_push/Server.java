import java.io.*;
import java.net.*;

public class Server {

    static int PORT=8080;

    public static void main(String[] args) throws Exception {
        System.out.println("Čakam, da me kdo pokliče; port:"+PORT);
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            String req=br.readLine();
            System.out.println(req);
            System.out.println("----");

            pw.println("HTTP/1.1 200 OK");
            pw.println();
            pw.println("Zdravo!");

            socket.close();
        }
    }

}
