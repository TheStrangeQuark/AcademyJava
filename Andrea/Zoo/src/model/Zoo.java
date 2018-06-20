package model;

import java.util.Arrays;

public class Zoo {

	String nome;
	Attrazione[] attrazioni;

	public Zoo() {
		attrazioni = new Attrazione[0];
	}

	public Zoo(String nome) {
		if (!nome.isEmpty()) {
			this.nome = nome;
			attrazioni = new Attrazione[0];
		} else System.out.println("ERRORE");
	}

	public Zoo(Attrazione[] a) {
		if (a != null) {
			this.attrazioni = a;
		} else System.out.println("ERRORE");
	}


	public void add(Attrazione a) {
		if (a != null) {
			attrazioni = Arrays.copyOf(attrazioni, attrazioni.length +1);
			attrazioni[attrazioni.length -1] = a;
		} else System.out.println("ERRORE");
	}

	public void delete(Attrazione a) {
		if (a != null) {
			int index = -1;
			for (int i = 0; i < attrazioni.length; i++ ) {
				if (attrazioni[i].equals(a)) index = i;
			}

			delete(index);
		} else System.out.println("ERRORE");
	}

	public void delete(int index) {
		if (index >= 0 && index <= attrazioni.length) {
			for (int i = index; i < attrazioni.length -1; i++) {
				attrazioni[i] = attrazioni[i+1];
			}

			attrazioni = Arrays.copyOf(attrazioni, attrazioni.length -1);
		} else System.out.println("ERORRE");	
	}

	public boolean find(Attrazione a) {
		if (a != null) {
			for (Attrazione el : attrazioni) {
				if (el.equals(a)) {
					return true;
				}
			}
		} else System.out.println("ERRORE");

		return false;
	}

	public void view() {
		System.out.println(nome);

		for (Attrazione el : attrazioni) {
			System.out.println(el.nome);
		}

		System.out.println();
	}	

	public void transfer(Attrazione a, Zoo dest) {
		if (a != null && dest != null) {
			if (this.find(a)) {
				this.delete(a);
				dest.add(a);
				System.out.println(a.nome + " trasferita da " + this.nome + " a " + dest.nome + "\n");
			}
		} else System.out.println("ERRORE");
	}

	public String toString() {
		return nome;
	}

	public boolean equals(Object o) {
		if (o == null) return false;
		else if (this == o) return true;
		else if (o instanceof Zoo) {
			Zoo temp = (Zoo) o;
			return Arrays.equals(this.attrazioni, temp.attrazioni) && this.nome == temp.nome;
		} else return false;
	}
}
