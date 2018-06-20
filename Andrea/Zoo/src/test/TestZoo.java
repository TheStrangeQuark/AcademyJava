package test;

import java.util.Scanner;

import model.Animale;
import model.Attrazione;
import model.Zoo;

public class TestZoo {

	public static void main(String[] args) {

		Attrazione at1 = new Attrazione("Attrazione 1");
		at1.add(new Animale("Pluto", "Cane", 3));
		at1.add(new Animale("Paperino", "Papero", 4));
		at1.add(new Animale("Topolino", "Topo", 5), 1);

		Attrazione at2 = new Attrazione("Attrazione 2");
		at2.add(new Animale("Topolino", "Topo", 2));
		at2.add(new Animale("Archimede", "Aquila", 7));

		Attrazione at3 = new Attrazione("Attrazione 3");
		at3.add(new Animale("Minni", "Topo", 3));
		at3.add(new Animale("Gastone", "Papero", 8));

		Zoo z1 = new Zoo("Zoo 1");
		z1.add(at1);
		z1.add(at2);

		Zoo z2 = new Zoo("Zoo 2");		
		z2.add(at3);

		z1.view();
		z2.view();

		z1.transfer(at1, z2);

		z1.view();
		z2.view();


		Scanner in = new Scanner(System.in);

		int cmd;

		do {
			System.out.println("Selezionare l'operazione desiderata...");
			System.out.println("1- Acquistare biglietti\n2- Acquistare cibo e bevande\n0- Esci\n\n");
			cmd = in.nextInt();

			switch (cmd) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 0:
					
					break;
				default:
			}

		} while (cmd != 0);

	}	
}
