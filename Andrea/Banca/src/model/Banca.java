package model;

import java.util.Arrays;

public class Banca {

	private String nome;
	private Persona[] clienti;
	
	public Banca() {
		clienti = new Persona[0];
	}
	
	public Banca(String nome) {
		if(nome != null) {
			this.nome = nome;
			clienti = new Persona[0];
		} else System.out.println("ERROR");
	}
	
	public Banca(String nome, Persona[] clienti) {
		if (nome != null && clienti != null) {
			this.nome = nome;
			this.clienti = clienti;
		} else System.out.println("ERRORE");
	}
	
	public void aggiungiPersona(Persona persona) {
		if (persona != null) {
			clienti = Arrays.copyOf(clienti, clienti.length +1);
			clienti[clienti.length -1] = persona;
		} else System.out.println("ERRORE");
	}
	
	public void eliminaConto(Persona persona) {
		if (persona != null) {
			int index = -1;
			for (int i = 0; i < clienti.length; i++ ) {
				if (clienti[i].equals(persona)) index = i;
			}

			eliminaConto(index);
		} else System.out.println("ERRORE");
	}

	private void eliminaConto(int index) {
		if (index >= 0 && index <= clienti.length) {
			for (int i = index; i < clienti.length -1; i++) {
				clienti[i] = clienti[i+1];
			}

			clienti = Arrays.copyOf(clienti, clienti.length -1);
		} else System.out.println("ERORRE");	
	}
	
	public int contiAttivi() {
		int out = 0;
		for (Persona el : clienti) {
			out += el.contiAttivi();
		}
		return out;
	}
	
	public void rapina() {
		for (Persona cliente : clienti) {
			for (ContoCorrente conto : cliente.getConti()) {
				conto.azzera();
			}
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public Persona[] getClienti() {
		return clienti;
	}
	
	public String toString() {
		return nome;
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		else if (this == o) return true;
		else if (o instanceof Banca) {
			Banca temp = (Banca) o;
			return this.nome.equals(temp.nome) && Arrays.equals(this.clienti, temp.clienti); 
		} else return false;
	}
}
