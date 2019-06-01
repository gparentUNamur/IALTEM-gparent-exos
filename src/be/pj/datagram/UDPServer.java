package be.pj.datagram;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(12345);
        System.out.println("Receiving in port 12345");

        byte[] buffer = new byte[256];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ds.receive(dp);
        InetAddress fromAddress = dp.getAddress();
        int fromPort = dp.getPort();
        int length = dp.getLength();
        byte[] data = dp.getData();
        ds.close();
        System.out.printf("received %d bytes from %s:%d",
                length, fromAddress, fromPort);
        for (int i = 0; i < length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
