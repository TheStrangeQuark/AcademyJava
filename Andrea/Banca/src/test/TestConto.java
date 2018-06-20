package test;

import model.Banca;
import model.ContoCorrente;
import model.Persona;

public class TestConto {

	public static void main(String[] args) {

		Persona cliente1 = new Persona("Mario Rossi");
		cliente1.aggiungiConto(new ContoCorrente(5000));
		
		Persona cliente2 = new Persona("Giuseppe Verdi");
		cliente2.aggiungiConto(new ContoCorrente(2000));
		cliente2.aggiungiConto(new ContoCorrente(4000));
		
		Persona cliente3 = new Persona("Sara Bianchi");
		cliente3.aggiungiConto(new ContoCorrente(10000));
		
		
		Banca banca1 = new Banca("BPM");
		banca1.aggiungiPersona(cliente1);
		
		Banca banca2 = new Banca("ISP");
		banca2.aggiungiPersona(cliente2);
		banca2.aggiungiPersona(cliente3);
	}
}
