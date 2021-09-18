package br.ucsal.pooa.finance.util;

public class Pilha {

	private int[] dados = new int[5];
	private int index = 0;
	
	public synchronized int pop() {
		int i = dados[index];
		index--;
		return i;
	}
	
	public  synchronized void push(int i) {
		index++;
		dados[index] = i;
	}
	
	public int size() {
		return dados.length;
	}
	
	public boolean isFull () {
		return (dados.length == index+1);
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
	
}
