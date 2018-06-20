package model;

public class Animale {

	public String nome;
	public String specie;
	public int eta;
	
	public Animale() {
		
	}
	
	public Animale(String nome, String specie, int eta) {
		if (!nome.isEmpty() && !specie.isEmpty() && eta >= 0) {
			this.nome = nome;
			this.specie = specie;
			this.eta = eta;
		} else System.out.println("ERRORE");
	}
	
	
	public String toString() {
		return nome + " " + specie + " " + eta + "\n";
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		else if (this == o) return true;
		else if (o instanceof Animale) {
			Animale temp = (Animale) o;
			return this.nome.equals(temp.nome) && this.specie.equals(temp.specie) && this.eta == temp.eta;
		} else return false;
	}
}
