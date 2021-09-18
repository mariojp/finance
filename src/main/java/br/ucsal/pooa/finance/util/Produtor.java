package br.ucsal.pooa.finance.util;

public class Produtor implements Runnable {

	private Pilha pilha;
	
	public Produtor(Pilha pilha) {
		this.pilha = pilha;
	}
	
	
	@Override
	public void run() {
		while(true) {
			System.out.println("RODANDO");
			if (!pilha.isFull()) {
				System.out.println("INSERINDO");
				pilha.push((int) (Math.random()*100) );
				
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
