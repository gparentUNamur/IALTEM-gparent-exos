package be.pj.datagram;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
    private static int PORT = 12345;

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
// prepare the data buffer
        byte[] data = new byte[256];
        for (int i = 0; i < 255; i++)
            data[i] = (byte) i;
        System.out.println("Send 256 bytes on port " + PORT + " ...");
// Constructs a datagram packet for sending packets
// of length length to the specified port number on
// the specified host
        DatagramPacket packet = new DatagramPacket(data, data.length,
                InetAddress.getLocalHost(), PORT);
// Sends a datagram packet from this socket. The DatagramPacket
// includes information indicating the data to be sent, its
// length, the IP address of the remote host, and the port number
// on the remote host.
        socket.send(packet);
        System.out.println("Paquet envoyé!");
        socket.close();
    }
}
