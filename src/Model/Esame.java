package Model;
import java.time.LocalDate;

/** oggetto semplice ad un singolo esame
 * POJO : plain old java object -> oggetto che all'interno ha dei:
 * 1)dati privati
 * 2)proprietà
 * 3)costruttore
 * 4)metodi getter e setter
 * 5) metodi di servizio (equals, toString, hashCode, [compareTo])
 * @author Jennifer
 *
 */
public class Esame {
private String codice;
private String titolo;
private String docente;
// private String Docente docente;
private boolean superato;
private int voto;
private LocalDate dataSuperamento;
/**
 * nuovo Esame, non ancora superato
 * @param codice codice dell'esame
 * @param titolo denominazione del corso
 * @param docente docente nome e cognome relativo al docente d'insegnamento
 */
public Esame(String codice, String titolo, String docente) {
	//quando faccio il costruttore mi devo domandare i dati utili che mi servono per costruirlo
	this.codice = codice;
	this.titolo = titolo;
	this.docente = docente;
	this.superato= false;
}
//modificate dall'esterno: setter
//Lette dall'esterno: getter
public String getCodice() {
	return codice;
}
public void setCodice(String codice) {
	this.codice = codice;
}
public String getTitolo() {
	return titolo;
}
public void setTitolo(String titolo) {
	this.titolo = titolo;
}
public String getDocente() {
	return docente;
}
public void setDocente(String docente) {
	this.docente = docente;
}
public boolean isSuperato() {
	return superato;
}
public void setSuperato(boolean superato) {
	this.superato = superato;
}
/** ù
 * restituisce il voto solo se l'esame è stato superato altrimentieccez
 * @return
 */
public int getVoto() {
	if(this.superato)
	return voto;
	else
		throw new IllegalStateException("Esame"+this.codice+"già superato");
}
private void setVoto(int voto) {
	this.voto = voto;
}
public LocalDate getDataSuperamento() {
	if(this.superato)
	return dataSuperamento;
	throw new IllegalStateException("Esame"+this.codice+"già superato");
}
//private: li chiamo solo io se mi servono. infatti ho costruito un metodo apposta
private void setDataSuperamento(LocalDate dataSuperamento) {
	this.dataSuperamento = dataSuperamento;
}
@Override
public String toString() {
	return "Esame codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
			+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codice == null) ? 0 : codice.hashCode());
	return result;
}
//mi serve equals perche una volta inserito un oggetto di una qualsiasi collections, non so piu trovarlo
//che cosa rende uguale e che cosa rende diverso i due elementi inseriti
//se i due oggetti hanno lo stesso indirizzo di memoria sono considerati uguali definendo equals
//due esami sono uguali se hanno lo stesso codice (chiave primaria)
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Esame other = (Esame) obj;
	if (codice == null) {
		if (other.codice != null)
			return false;
	} else if (!codice.equals(other.codice))
		return false;
	return true;
}
/** 
 * se l'esame non è ancora stato superato lo considera superato con il voto e la data considerati
 * se è stato superato genera un eccezione
 * 
 * @param voto
 * @param data
 */
public void supera(int voto, LocalDate data)
{ if(!this.superato)
{
	this.superato= true;
this.voto= voto;
this.dataSuperamento=data;}
else
{
	//l'oggetto interno è un ostacolo: a seconda che sia superato o meno ha senso chiamare alcuni metodi
	throw new IllegalStateException("Esame"+this.codice+"già superato");
	//quando l'utente vuole registare un voto dell'esame superato chiama il metodo supero
	}
	}

}
