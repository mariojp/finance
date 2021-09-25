package br.ucsal.pooa.finance.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DolarServidor extends ServerSocket implements Runnable {

	
	private String cotacao = "5,33";
	
	public DolarServidor() throws IOException {
		super(4444);
	}

	public void run() {

		try {
			while (true) {
				// espera
				Socket cliente = this.accept();
				System.out.println("Cliente conectado");
				InputStream comandos = cliente.getInputStream();
				OutputStream dados = cliente.getOutputStream();
				BufferedReader is = new BufferedReader(new InputStreamReader(comandos));
				PrintWriter os = new PrintWriter(dados);
				System.out.println(is.readLine());
				
				os.println(cotacao);
				os.flush();
				cliente.close();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Subiu o Servidor");

		// System.out.println("Fechou o Servidor");

	}

}
