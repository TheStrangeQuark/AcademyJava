package model;

public class ContoCorrente {

	private double saldo;
	private static int contiAttivi = 0;
	
	public ContoCorrente() {
		contiAttivi++;
	}
	
	public ContoCorrente(double saldo) {
		if (saldo >= 0) {
			contiAttivi++;
			this.saldo = saldo;
		}
		else System.out.println("ERRORE");
	}
	
	public void prelievo(double importo) {
		if (saldo - importo >= 0) {
			saldo -= importo;
			getSaldo();
		} else System.out.println("ERRORE");
	}
	
	public void versamento(double importo) {
		if (importo >= 0) {
			saldo += importo;
			getSaldo();
		} else System.out.println("ERRORE");
	}
	
	public double calcolaInteressi(int anni, double interesse) {
		if (anni > 0 && interesse > 0) {
			return (saldo * interesse * anni) / 100;
		} else {
			System.out.println("ERRORE");
			return -1;
		}
	}
	
	public void azzera() {
		saldo = 0;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public static int getContiAttivi() {
		return contiAttivi;
	}
	
	public String toString() {
		return Double.toString(saldo);
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		else if (this == o) return true;
		else if (o instanceof ContoCorrente) {
			ContoCorrente temp = (ContoCorrente) o;
			return this.saldo == temp.saldo;
		} else return false;
	}
}
