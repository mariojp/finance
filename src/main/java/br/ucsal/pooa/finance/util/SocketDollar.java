package br.ucsal.pooa.finance.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class SocketDollar implements Runnable {

	public static void main(String[] args) throws Exception {

		// socket.close();

		// Web Scrapping por url socket
//		URL url = new URL("https://dolarhoje.com/");
//
//		BufferedReader is = new BufferedReader(new InputStreamReader(url.openStream()));
//		
//		
//		String linha = "";
//		while(  ( linha = is.readLine()) !=null) {
//			if(linha.contains("<input type=\"text\" id=\"nacional\"")) {
//				int tam = "id=\"nacional\" value=\"".length();
//				int inicial = linha.lastIndexOf("id=\"nacional\" value=\"");
//				int ultima = linha.indexOf( "/>", inicial);
//				System.out.println(linha.substring(inicial+tam,ultima-1));
//			}
//				
//		}

		// Pegando dados de Ip e host
//		InetAddress[] addresss = InetAddress.getAllByName("fowler.local");
//		for(InetAddress address : addresss) {
//			System.out.println(address.getHostName());
//			System.out.println(address.getHostAddress());
//		}
//		
//		System.out.println(InetAddress.getByName("ucsal.br").getHostAddress());
	}

	@Override
	public void run() {
		while (true) {
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Socket socket;
			try {
				socket = new Socket("localhost", 4444);
				PrintWriter os = new PrintWriter(socket.getOutputStream());
				BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				os.println("DOLAR:REAL");
				os.flush();
				String linha = "";
				while ((linha = is.readLine()) != null) {
					System.out.println(linha);
				}

				os.println("DOLAR:REAL");
				os.flush();

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
