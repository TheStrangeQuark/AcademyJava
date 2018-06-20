package model;

import java.util.Arrays;

public class Persona {

	private String nome;
	private ContoCorrente[] conti;
	
	
	public Persona() {
		conti = new ContoCorrente[0];
	}
	
	public Persona(String nome) {
		if(nome != null) {
			this.nome = nome;
			conti = new ContoCorrente[0];
		} else System.out.println("ERROR");
	}
	
	public Persona(String nome, ContoCorrente[] conti) {
		if (nome != null && conti != null) {
			this.nome = nome;
			this.conti = conti;
		} else System.out.println("ERRORE");
	}
	
	
	public void aggiungiConto(ContoCorrente conto) {
		if (conto != null) {
			conti = Arrays.copyOf(conti, conti.length +1);
			conti[conti.length -1] = conto;
		} else System.out.println("ERRORE");
	}
	
	public void eliminaConto(ContoCorrente conto) {
		if (conto != null) {
			int index = -1;
			for (int i = 0; i < conti.length; i++ ) {
				if (conti[i].equals(conto)) index = i;
			}

			eliminaConto(index);
		} else System.out.println("ERRORE");
	}

	private void eliminaConto(int index) {
		if (index >= 0 && index <= conti.length) {
			for (int i = index; i < conti.length -1; i++) {
				conti[i] = conti[i+1];
			}

			conti = Arrays.copyOf(conti, conti.length -1);
		} else System.out.println("ERORRE");	
	}
	
	public int contiAttivi() {
		return conti.length;
	}
	
	public String getNome() {
		return nome;
	}
	
	public ContoCorrente[] getConti() {
		return conti;
	}

	public String toString() {
		return nome;
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		else if (this == o) return true;
		else if (o instanceof Persona) {
			Persona temp = (Persona) o;
			return this.nome.equals(temp.nome) && Arrays.equals(this.conti, temp.conti); 
		} else return false;
	}
}
