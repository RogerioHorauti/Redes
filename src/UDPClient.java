import java.io.*;
import java.net.*;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		
		//cria cadeia de entrada
		BufferedReader inFromUser =	new BufferedReader(new InputStreamReader(System.in));
		
		//cria socket do cliente
		DatagramSocket clientSocket = new DatagramSocket();
		
		//traduz hostname para endereço IP usando DNS
		InetAddress IPAddress = InetAddress.getByName("hostname");
		
		byte[ ] sendData = new byte[1024];
		byte[ ] receiveData = new byte[1024];
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		
		//cria datagrama com dados a enviar, tamanho, end. IP,	porta
		DatagramPacket sendPacket =	new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		
		//envia datagrama ao servidor
		clientSocket.send(sendPacket);
		
		DatagramPacket receivePacket =	new DatagramPacket(receiveData, receiveData.length);
		
		//lê datagrama	do servidor
		clientSocket.receive(receivePacket);
		
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();
		
	}

}
