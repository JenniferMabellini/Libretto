package Model;

import java.time.LocalDate;

public class TestEsame {

	public static void main(String[] args) {
		Esame tdp= new Esame("03fyz","Tecniche di programmazione", "Fulvio Corno");
		Esame tdp2= new Esame("03fye","Ambient Intelligence", "Fulvio Corno");
		System.out.println(tdp);
		System.out.println(tdp2.equals(tdp));
		tdp.supera(30, LocalDate.now());
		System.out.println(tdp);
		tdp.supera(18, LocalDate.now());
		System.out.println(tdp);
	}

}
