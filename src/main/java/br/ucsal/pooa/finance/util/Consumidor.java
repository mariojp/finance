package br.ucsal.pooa.finance.util;

public class Consumidor implements Runnable{

	
	private Pilha pilha;
	
	public Consumidor(Pilha pilha) {
		this.pilha = pilha;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("RODANDO");
			if (!pilha.isEmpty()) {
				System.out.println("REMOVENDO"+pilha.pop());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
