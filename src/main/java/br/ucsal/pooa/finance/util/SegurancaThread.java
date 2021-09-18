package br.ucsal.pooa.finance.util;

import br.ucsal.pooa.finance.view.Janela;

public class SegurancaThread extends Thread {
	
	
	@Override
	public void run() {
		System.out.println("Entrei na Thread");
		try {
			Thread.sleep(Janela.SEGUNDOS*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sair do Programa");
		System.exit(0);

	}
}
