import java.io.*;
import java.net.*;

public class TCPClient 
{
	public static void main(String argv[ ]) throws Exception
	{
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser =	new BufferedReader(new InputStreamReader(System.in));
		//Socket clientSocket = new Socket("localhost", 6789);
		//Socket clientSocket = new Socket("172.18.22.229", 6789); //thomas
		Socket clientSocket = new Socket("172.18.22.240", 6789); //weslley
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new
				InputStreamReader(clientSocket.getInputStream()));
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}
}
