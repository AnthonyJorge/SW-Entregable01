package com.example.demo.socket.entregable01;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class server {
	
	/*Eligimos un  PUERTO */
	private final Integer PORT = 25;

	public server() {
		Socket clienteArchivo;
		
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while (true) {
				System.out.println("iniciamos serverSocket");
				System.out.println("Esperamos al cliente");
				clienteArchivo = serverSocket.accept();
				System.out.println("Llego el cliente");
				File archivoDestino = new File("J:/server/peru.jpg");
				FileOutputStream fos = new FileOutputStream(archivoDestino);
				DataInputStream entrada = new DataInputStream(clienteArchivo.getInputStream());
			
			int byteleidos;
			while ((byteleidos = entrada.read())!= -1) {
				fos.write(byteleidos);
				
			}
			fos.close();
			entrada.close();
			
			System.out.println("Finaliza la atencion");
				
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new server();
	}
	
}
