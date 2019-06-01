package be.pj.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server listen on port 12345");

        while (true) {
            Socket s = serverSocket.accept();
            System.out.println("New client connected " + s.getInetAddress() + ":" + s.getPort());
            char in = (char) s.getInputStream().read();
            System.out.println(in);
//            s.getOutputStream().write(in);
        }
    }
}
