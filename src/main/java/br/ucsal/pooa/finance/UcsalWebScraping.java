package br.ucsal.pooa.finance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UcsalWebScraping {

	public static void main(String[] args) throws Exception {
		//Web Scrapping por url socket
		URL url = new URL("http://noosfero.ucsal.br/institucional/noticias/feed");

		BufferedReader is = new BufferedReader(new InputStreamReader(url.openStream()));
		
		
		String linha = "";
		while(  ( linha = is.readLine()) !=null) {
				System.out.println(linha);
			
				
		}
	}
}
