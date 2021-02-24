import java.io.*;
import java.net.*;
import java.util.Locale;

public class UDPServer {

    public static void main(String[] args) throws IOException {

        int porta = 44445;
        DatagramSocket serverSocket = new DatagramSocket(porta);

        byte[] dadosReceber = new byte[1024];
        byte[] dadosEnviar = new byte[1024];

        while (true){
            DatagramPacket pacoteReceber = new DatagramPacket(dadosReceber, dadosReceber.length);
            serverSocket.receive(pacoteReceber);
            String mensagem = new String(pacoteReceber.getData());

            InetAddress endereco = pacoteReceber.getAddress();
            int p = pacoteReceber.getPort();

            String novaMesaggem = mensagem.toUpperCase();
            dadosEnviar = novaMesaggem.getBytes();

            DatagramPacket enviarPacote = new DatagramPacket(dadosEnviar, dadosEnviar.length, endereco, p);

            serverSocket.send(enviarPacote);


        }
    }
}
