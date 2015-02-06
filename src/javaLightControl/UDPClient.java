package javaLightControl;

import java.io.*;
import java.net.*;

public class UDPClient {

	public static void sendAPacketPrintResponse(DatagramSocket clientSocket, String sentence) throws IOException
	{
		System.out.println("SEND AND RECEIVE");
		System.out.println(sentence);
		 byte[] sendData = new byte[1024];
	     byte[] receiveData = new byte[1024];
	     InetAddress IPAddress = InetAddress.getByName("172.16.0.1");
	     sendData = sentence.getBytes();
	      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 11600);
	      clientSocket.send(sendPacket);
	      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	      clientSocket.receive(receivePacket);
	      String modifiedSentence = new String(receivePacket.getData());
	      System.out.println("FROM SERVER:" + modifiedSentence);
	     
	}
	
	public static void sendPacketOnly(DatagramSocket clientSocket, String sentence) throws IOException
	{
		System.out.println("SEND ONLY");
		 System.out.println(sentence);
		 byte[] sendData = new byte[1024];
	     byte[] receiveData = new byte[1024];
	     InetAddress IPAddress = InetAddress.getByName("172.16.0.1");
	     sendData = sentence.getBytes();
	     DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 11600);
	     clientSocket.send(sendPacket);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	      //BufferedReader inFromUser =
	    	//         new BufferedReader(new InputStreamReader(System.in));
	    	      DatagramSocket clientSocket = new DatagramSocket();
	    	      //http://172.16.0.1/index.shtml
	    	      //Port: 11600
	    	      //InetAddress IPAddress2 = InetAddress.getByAddress("172.16.0.1");
	    	      InetAddress IPAddress = InetAddress.getByName("172.16.0.1");
	    	      byte[] sendData = new byte[1024];
	    	      byte[] receiveData = new byte[1024];
	    	      String ping = "{\"cmd\":\"ping\"}";
	    	      String light_list = "{\"cmd\":\"light_list\"}";
	    	      String light_control_variation1 = "{ \"g\": \"255\", \"model\": \"6\", \"cmd\": \"light_ctrl\", \"b\": \"0\", \"effect\": \"9\", \"bright\": \"100\", \"r\": \"0\", \"sn_list\": [ { \"sn\": “MD1AC44200001086”} ], \"matchValue\": \"0\", \"iswitch\": \"1\" }";

	    	      String light_control_variation2 = "{\"cmd”:\"light_ctrl\",\"model\": \"6\", \"r\":\"70\", \"g\":\"200\", \"b\":\"70\", \"bright\":\"69\", \"effect”:\"9\", \"iswitch\":\"1\", \"matchValue\":\"0\",\"sn_list\":[{\"sn\":\"MD1AC44200001086\"},{\"sn\":\"MD1AC44200001557\"}]}";
	    	      
	    	      String group_list = "{\"cmd\":\"group_list\",\"group_id\":\"All Light\"}";
	    	      
	    	      String set_title1 = "{\"cmd\":\"set_title\", \"sn\":\"MD1AC44200000521\", \"title\":\"TravisLamp\"}";
	    	      String set_title2 = "{\"cmd\":\"set_title\", \"sn\":\"MD1AC44200001086\", \"title\":\"Alberto\"}";

	    	      String light_ctrl_save = "{\"g\":\"1\", \"cmd\":\"light_ctrl_save\", \"b\":\"2\", \"effect\":\"9\", \"bright\":\"66\", \"r\":\"200\", \"sn_list\": [ {\"sn\":\"MD1AC44200000521\"}], \"matchValue\":\"0\", \"switch\":\"1\", \"angle\":\"0.0\"}";

	    	      String light_ctrl_group = "{\"g\": \"34\", \"model\": \"6\", \"cmd\": \"light_ctrl\", \"b\": \"46\", \"effect\": \"8\", \"bright\": \"22\", \"r\": \"0\", \"sn_list\": [ { \"sn\": \"000\" } ], \"matchValue\": \"0\", \"iswitch\": \"1\", \"group1\": \"1\", \"angle\": \"0.0\" }";

	    	      
	    	      String add_light_to_group = "{\"cmd\":\"set_group\",\"sn\":\"MD1AC44200000521\",\"group_id\":\"1\"}";;
	    	      
	    	      sendAPacketPrintResponse(clientSocket, ping);
	    	      
	    	      sendAPacketPrintResponse(clientSocket, light_list);
	    	      	    	          	      
	    	      sendAPacketPrintResponse(clientSocket, group_list);
	    	      
	    	      //sendPacketOnly(clientSocket, sentence6a);
	    	      
	    	      //sendPacketOnly(clientSocket, sentence4);
	    	      
	    	      sendPacketOnly(clientSocket, light_ctrl_save);
	    	      
	    	      sendPacketOnly(clientSocket, light_control_variation2);
	    	      //sendPacketOnly(clientSocket, sentence4);
	    	      //sendPacketOnly(clientSocket, sentence4);
	    	      sendPacketOnly(clientSocket, add_light_to_group);
	    	      
	    	      
	    	      clientSocket.close();
	}

}
