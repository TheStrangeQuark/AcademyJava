package model;

import java.util.Arrays;

public class Attrazione {

	String nome;
	Animale[] animali;

	public Attrazione() {
		nome = "";
		animali = new Animale[0];
	}

	public Attrazione(String nome) {
		if (!nome.isEmpty()) {
			this.nome = nome;
			animali = new Animale[0];
		} else System.out.println("ERRORE");
	}

	public Attrazione(String nome, Animale[] animali) {
		if (!nome.isEmpty() && animali != null) {
			this.nome = nome;
			this.animali = animali;
		} else System.out.println("ERRORE");
	}


	public void add(Animale a) {
		if (a != null) {
			animali = Arrays.copyOf(animali, animali.length +1);
			animali[animali.length -1] = a;
		} else System.out.println("ERRORE");
	}

	public void add(Animale a, int index) {
		if (a != null && index >= 0 && index <= animali.length) {
			animali = Arrays.copyOf(animali, animali.length +1);

			for (int i = index; i < animali.length -1; i++) {
				animali[i+1] = animali[i];
			}

			animali[index] = a;
		} else System.out.println("ERORRE");	

	}

	public void delete(Animale a) {
		if (a != null) {
			int index = -1;
			for (int i = 0; i < animali.length; i++ ) {
				if (animali[i].equals(a)) index = i;
			}

			delete(index);
		} else System.out.println("ERRORE");
	}

	public void delete(int index) {
		if (index >= 0 && index <= animali.length) {
			for (int i = index; i < animali.length -1; i++) {
				animali[i] = animali[i+1];
			}

			animali = Arrays.copyOf(animali, animali.length -1);
		} else System.out.println("ERORRE");	
	}

	public boolean find(Animale a) {
		if (a != null) {
			for (Animale el : animali) {
				if (el.equals(a)) return true;
			}
		} else System.out.println("ERRORE");
		
		return false;
	}

	public void view() {
		System.out.println(nome);
		for (Animale el : animali) {
			System.out.println(el.toString());
		}
		System.out.println();
	}
	
	public String toString() {
		return nome;
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		else if (this == o) return true;
		else if (o instanceof Attrazione) {
			Attrazione temp = (Attrazione) o;
			return Arrays.equals(this.animali, temp.animali) && this.nome == temp.nome;
		} else return false;
	}
}
