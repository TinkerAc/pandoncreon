package player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import carteModule.Apocalypse;
import carteModule.Carte;
import carteModule.CarteAction;
import carteModule.Croyant;
import carteModule.DeuxEx;
import carteModule.GuideSpirituel;
import service.Partie;

public class JoueurAI extends Joueur {

	public JoueurAI() {
		super();
	}
		
	@Override
	public void defausser() {
		System.out.println("joueurAI" + this.numj + " a d®¶fauss®¶ ses cartes");
		this.getCartesEnMain().clear();
	}

	
	public void utiliser(CarteAction c) throws Exception {
//		Iterator<CarteAction> it = this.cartesEnMain.iterator();
//		while(it.hasNext()) {
//			CarteAction c = (CarteAction)it.next();
			switch(c.getOrigine()) {
			case "jour":
				if(this.getPointActionJour() > 0) {

					if(c.getType() == "Croyant") {
						this.poserCroyant((Croyant) c);
						System.out.println("joueurAI" + this.numj + " a pos®¶ un croyant");
						System.out.println(c.toString());
					}
					if(c.getType() == "Guide") {
						if(CST.getCroyantPublic().size() == 0){
							defausser();
							return;
						}
						if(CST.getCroyantPublic().size() > 0) {
							this.poserGuide((GuideSpirituel)c);
							System.out.println("joueurAI" + this.numj + " a pos®¶ un Guide");
							System.out.println(c.toString());
							
						}else {
//							continue;
						}
					}
					/*if(c.getType() == "DeuxEx") {
						DeuxEx de = (DeuxEx)c;
						de.sacrifier(this);
					}*/
					if(c.getType() == "Apocalypse") {
						Apocalypse ap = (Apocalypse)c;
						pointActionJour--;
						ap.setJoueur(null);
						Partie.getPartie().ApocalypseProcess(this, ap);
					}
					
				}
				else{
					System.out.println("Point d'Action n'est pas suffisant, ®¶chouant d'utiliser une carte");
				}
				break;
			case "neant":
				if(this.getPointActionNeant() > 0) {

					if(c.getType() == "Croyant") {
						this.poserCroyant((Croyant) c);
						System.out.println("joueurAI" + this.numj + " a pos®¶ un croyant");
						System.out.println(c.toString());
					}
					if(c.getType() == "Guide") {
						if(CST.getCroyantPublic().size() == 0){
							defausser();
							return;
						}
						if(CST.getCroyantPublic().size() > 0) {
							this.poserGuide((GuideSpirituel)c);
							System.out.println("joueurAI" + this.numj + " a pos®¶ un guide");
							System.out.println(c.toString());
						}else {
//							continue;
						}
					}
					/*if(c.getType() == "DeuxEx") {
						DeuxEx de = (DeuxEx)c;
						de.sacrifier(this);
					}*/
					if(c.getType() == "Apocalypse") {
						Apocalypse ap = (Apocalypse)c;
						pointActionNeant--;
						ap.setJoueur(null);
						Partie.getPartie().ApocalypseProcess(this, ap);
					}
					
				}
				else{
					System.out.println("Point d'Action n'est pas suffisant, ®¶chouant d'utiliser une carte");
				}
				break;
			case "nuit":
				if(this.getPointActionNuit() > 0) {

					if(c.getType() == "Croyant") {
						this.poserCroyant((Croyant) c);
						System.out.println("joueurAI" + this.numj + " a pos®¶ un croyant");
						System.out.println(c.toString());
					}
					if(c.getType() == "Guide") {
						if(CST.getCroyantPublic().size() == 0){
							defausser();
							return;
						}
						if(CST.getCroyantPublic().size() > 0) {
							this.poserGuide((GuideSpirituel)c);
							System.out.println("joueurAI" + this.numj + " a pos®¶ un Guide");
							System.out.println(c.toString());
						}else {
//							continue;
						}
					}
					/*if(c.getType() == "DeuxEx") {
						DeuxEx de = (DeuxEx)c;
						de.sacrifier(this);
					}*/
					if(c.getType() == "Apocalypse") {
						Apocalypse ap = (Apocalypse)c;
						pointActionNuit--;
						ap.setJoueur(null);
						Partie.getPartie().ApocalypseProcess(this, ap);
					}
					
				}
				else{
					System.out.println("Point d'Action n'est pas suffisant, ®¶chouant d'utiliser une carte");
				}
				break;
			}
			if(c.getType().equals("Apocalypse")){
				Apocalypse ap = (Apocalypse)c;
				System.out.println("joueurAI" + this.numj + " a pos®¶ un Apocalypse");
				Partie.getPartie().ApocalypseProcess(this, ap);
			}
//		}
	}

	@Override
	public void sacrifier() {
		
	}

	@Override
	public void capaciter() {
		
	}

	@Override
	public void choisirUneOperation() {
		if(this.cartesEnMain.size() < 7) {
			piocher(Partie.getPartie().getCartes());
			return;
		}
		ArrayList<CarteAction> ca = this.getCartesEnMain();
		Iterator<CarteAction> it = ca.iterator();
		while(it.hasNext()){
			CarteAction c = it.next();
			if((this.getCarteDivinite().getOrigine().equals("crepuscule") || this.getCarteDivinite().getOrigine().equals("aube")) && (!c.getType().equals("DeuxEx") && (c.getOrigine().equals("neant") || c.getOrigine().equals("sansOrigine")))){
				try {
					utiliser(c);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			else if((c.getOrigine().equals(this.getCarteDivinite().getOrigine()) || c.getOrigine().equals("sans Origine")) && (!c.getType().equals("DeuxEx"))){
				try {
					utiliser(c);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
		
		defausser();
		return;
	}

	@Override
	public void poserCroyant(Croyant cc) {
		switch(cc.getOrigine()) {
		case Carte.JOUR:
			if(this.pointActionJour >= 1) {
				CST.getCroyantPublic().add(cc);
				this.pointActionJour -= 1;
				cartesEnMain.remove(cc);
				cc.setJoueur(null);
				System.out.println("poser Croyant a r®¶ussi");
			}else {
				System.out.println("Point d'Action n'est pas suffisant");
//				cartesEnMain.add(cc);
			}
			break;
		case Carte.NEANT:
			if(this.pointActionNeant >= 1) {
				CST.getCroyantPublic().add(cc);
				this.pointActionNeant -= 1;
				cartesEnMain.remove(cc);
				cc.setJoueur(null);
				System.out.println("poser Croyant a r®¶ussi");
			}else {
				System.out.println("Point d'Action n'est pas suffisant");
//				cartesEnMain.add(cc);
			}
			break;
		
		case Carte.NUIT:
			if(this.pointActionNuit >= 1) {
				CST.getCroyantPublic().add(cc);
				this.pointActionNuit -= 1;
				cartesEnMain.remove(cc);
				cc.setJoueur(null);
				System.out.println("poser Croyant a r®¶ussi");
			}else {
				System.out.println("Point d'Action n'est pas suffisant");
//				cartesEnMain.add(cc);
			}
			break;
		default :
			break;
		}
	}

	@Override
	public void poserGuide(GuideSpirituel guide) {
		List<CarteAction> croyants = CST.getCroyantPublic();
		Iterator<CarteAction> it = croyants.iterator();
		Scanner sc = new Scanner(System.in);
		
		int iDeCroyant = 0; //–≈ÕΩø®±‡∫≈
		
		while(it.hasNext()) {
			System.out.println(iDeCroyant);
			System.out.println(it.next().toString());
		}
		while(true) {
			if(CST.getCroyantPublic().size() == 0) {
				System.out.println("Il n'y a pas de Croyants au milieu de la table!");
				this.cartesEnMain.remove(guide);
				break;
			}
			if(guide.getNbCroyant() == guide.getNbCroyantMax()) {
				System.out.println("Le nombre de Croyants atteint le max!");
				System.out.println("Le tour de ce joueur termine");
				this.cartesEnMain.remove(guide);
				break;
			}
			
			Croyant ca =(Croyant) CST.getCroyantPublic().remove(0);
			guide.getCroyants().add(ca);
			guide.setNbCroyant(guide.getNbCroyant() + 1);
			this.getCroyants().add(ca);
			ca.setJoueur(this);
			nbPriere += ca.getNbPriere();
			System.out.println("Guide Spirituel a r®¶ussi!");
		}
		this.getGuides().add(guide);
	}

	@Override
	public void sacrifierCroyant() {
		
	}


	@Override
	public void sacrifierGuide(GuideSpirituel g) {
		
	}

	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}
	
	
}
