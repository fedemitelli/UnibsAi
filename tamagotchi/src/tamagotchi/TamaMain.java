package tamagotchi;
import mylib.*;
/**
 * La classe permette l'interazione tra utente e Tamagotchi.
 * Si richiede il nome del Tamagotchi all'utente tramite il metodo
 * {@link mylib.InputDati#leggiStringaNonVuota(String string)} 
 * Il nome poi viene utilizzato per istanziare una classe di tipo Tamagotchi {@link Tamagotchi}.
 * Viene creato un template di un menu grazie alla classe MyMenu {@link mylib.MyMenu}
 * Il menu viene utilizzato per far compiere 3 azioni all'utente:
 * -Inserire il numero di carezze: legge un numero da tastiera e richiama il metod
 * -Inserire il numero di biscotti
 * -Uscita dal programma
 * Il menu continua a comparire a meno che non si selezioni la voce uscita o il tamagotchi muoia.
 * 
 * @author Federico Mitelli
 * @author Fabio Ghidini
 *
 */
public class TamaMain {
	private final static String [] VOCI={"Dai carezze", "Dai biscotti"};
	private final static String TITOLO="Scegli:";
	
	/**
	 * Il metodo chiede all'utente che nome vuol dare al tamagotchi
	 * e istanzia il nuovo oggetto tama  
	 * @return tama Oggetto Tamagotchi creato dal metodo.
	 */
	public static Tamagotchi creaTamagotchi(){
		String nome;
		nome=InputDati.leggiStringaNonVuota("Ciao! Come mi vuoi chiamare?");
		
		Tamagotchi tama=new Tamagotchi(nome);
		return tama;
	}
	
	public static void main(String[] args) throws Exception{
		int scelta=1;
		double carezze, biscotti;
		Tamagotchi tama=creaTamagotchi();
		
		MyMenu menu=new MyMenu(TITOLO, VOCI);
		
		
		
		while(scelta!=0)
		{
			System.out.println(tama);
			scelta=menu.scegli();
			switch(scelta)
			{
			case 1: carezze=InputDati.leggiDouble("Inserisci il numero di carezze: ");
					tama.riceviCarezze(carezze);
					break;
			case 2: biscotti=InputDati.leggiDouble("Inserisci il numero di biscotti: ");
					tama.riceviBiscotti(biscotti);
					break;
			default:break;
			}
			if(tama.sonoMorto()==true) {
				System.out.println(tama);
				scelta=0;
			}
			
		}
	}
}
