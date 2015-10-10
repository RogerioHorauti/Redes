import java.net.*;

public class UDPServer 
{
	public static void main(String args[]) throws Exception
	{
		//cria socket de datagrama na porta 9876
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[ ] receiveData = new byte[1024];
		byte[ ] sendData = new byte[1024];
		while(true)
		{
			//cria espaço para datagrama recebido
			DatagramPacket receivePacket =	new DatagramPacket(receiveData, receiveData.length);
			
			//recebe datagrama
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			
			//obtém end. IP # porta do emissor
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			
			String capitalizedSentence = sentence.toUpperCase();
			sendData = capitalizedSentence.getBytes();
			
			//cria datagrama p/	enviar ao cliente
			DatagramPacket sendPacket =	new DatagramPacket(sendData, sendData.length, IPAddress, port);
			
			//escreve datagrama	no socket
			serverSocket.send(sendPacket);
			
		}
	}
}
