import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPCliente {

    public static void main(String[] args) throws Exception {

        /*ENVIAR MENSAGEM*/

        //Cria variável de leitura
        BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));
        //Cria socket Cliente
        DatagramSocket clienteSocket = new DatagramSocket();
        //Cria host
        InetAddress endereco = InetAddress.getByName("localhost");
        //Cria porta
        int porta = 44445;
        //Cria mensangem com limete de tamanho
        byte[] dadosEnviar = new byte[1024];
        //Lé mensagem do teclado
        String mensagem = entradaUsuario.readLine();
        //Prepara mensagem
        dadosEnviar = mensagem.getBytes();
        DatagramPacket pacoteEnviar = new DatagramPacket(dadosEnviar, dadosEnviar.length, endereco, porta);
        //Envia mensagem
        clienteSocket.send(pacoteEnviar);

        /*RECEBE MENSAGEM*/

        //Cria mensagem com limete de tamanho
        byte[] dadosReceber = new byte[1024];
        //Prepara mensagem para receber dados do servidor
        DatagramPacket pacoteReceber = new DatagramPacket(dadosReceber, dadosReceber.length);
        //Recebe mensagem
        clienteSocket.receive(pacoteReceber);

        String novaMensagem = new String(pacoteReceber.getData());
        System.out.println("Mensagem do servidor: " + novaMensagem);

        //Fecha conexão
        clienteSocket.close();


    }
}
