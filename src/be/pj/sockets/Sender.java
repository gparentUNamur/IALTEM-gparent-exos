package be.pj.sockets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


public class Sender {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getLocalHost(), 12345);
        s.getOutputStream().write('b');
        System.out.println((char) s.getInputStream().read());
    }
}
