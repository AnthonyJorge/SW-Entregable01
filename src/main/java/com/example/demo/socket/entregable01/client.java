package com.example.demo.socket.entregable01;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	
	private final Integer PORT = 25;
	private final String IP ="localhost";
	
	public client() {
		try {
			Socket clienteSocker = new Socket(IP,PORT);
			System.out.println("iniciando comunicacion");
			
			File fileorigen = new File("J:/client/peru.jpg");
			FileInputStream fis = new FileInputStream(fileorigen);
			DataOutputStream salida = new DataOutputStream(clienteSocker.getOutputStream());
		
				int byteLeidos;
				while ((byteLeidos = fis.read()) !=-1) {
					salida.write(byteLeidos);
				}
				fis.close();
				salida.close();
		
				System.out.println("Finaliza comunicacion");
				
				clienteSocker.close();
				
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
	public static void main(String[] args) {
		new client();
	}

}
