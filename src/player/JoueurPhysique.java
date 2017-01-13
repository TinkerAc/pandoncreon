package player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import carteManager.Cartes;
import carteModule.*;
import service.CartesSurTable;
import service.Partie;
import service.Process;
import util.AideGUI;
import util.Input;


public class JoueurPhysique extends Joueur {
	
	
	public JoueurPhysique() {
		super();
	}
	
	public void defausser() {
//		Scanner sc = new Scanner(System.in);
		boolean end = false;
		try {
			do{
				if(cartesEnMain.size() == 0){
					System.out.println("Vous n'avez pas de cartes en main");
					return;
				}
				showCards();
				System.out.println("choisir une carte que vous vouler défausser:");
//				int i = sc.nextInt();
				int i = AideGUI.getInstance().lireInt();
				if(i >= 0 && i < cartesEnMain.size()) {
					CarteAction ca = cartesEnMain.get(i);
					cartesEnMain.remove(ca);
				}else {
					System.out.println("Cette carte n'existe pas! Choisir une autre carte.");
					continue;
				}
				System.out.println("importer '14' pour terminer, importer les autres pour continuer à défausser");
				end = (AideGUI.getInstance().lireInt() == 14);
			}while(!end);
		}catch(Exception e) {
			System.out.println("input illégal, importer encore une fois!");
			defausser();
		}
		
	}
	
	
	
	/*
	 * 之后需要对此方法拆分，将四种情况分别封装到对应的卡牌类里面
	 * 
	 * */
	public void utiliser() {
		showPointAction();
		System.out.println("choisir une carte:");
		showCards();
//		Scanner sc = new Scanner(System.in);
		int i = -1;
		boolean FLAG = false;
		while(!FLAG) {
//			try{
//				i = sc.nextInt();
//				if(i >= 0 && i < cartesEnMain.size()) {
//					FLAG = true;
//				}else {
//					System.out.println("Cette carte ne peut pas être choisie, importer un autre nombre entier:");
//					FLAG = false;
//				}
//			}catch(InputMismatchException e) {
//				System.out.println("input illégal");
//				sc.next();
//				FLAG = false;
//			}
			i = AideGUI.getInstance().lireInt();
			if(i >= 0 && i < cartesEnMain.size()) {
				FLAG = true;
			}else {
				System.out.println("Cette carte ne peut pas être choisie, importer un autre nombre entier:");
				FLAG = false;
			}
		}
		CarteAction c = cartesEnMain.get(i);//c 为要使用的牌
		
		switch(c.getType()) {
		case "Croyant":
			Croyant cc = (Croyant)c;
			poserCroyant(cc);
			cartesEnMain.remove(c);
			c.setJoueur(null);
			break;
		case "Guide":
			GuideSpirituel guide = (GuideSpirituel)c;
			poserGuide(guide);
			cartesEnMain.remove(c);
			break;
		case "DeuxEx":
			DeuxEx de = (DeuxEx)c;
			de.sacrifier(this);
			break;
		case "Apocalypse":
			Apocalypse ap = (Apocalypse)c;
			if(ap.getOrigine() == "jour") {
				if(this.getPointActionJour() >= 1) {
					this.setPointActionJour(this.getPointActionJour() - 1);
					cartesEnMain.remove(c);
					c.setJoueur(null);
				}else {
					System.out.println("Point d'Action n'est pas suffisant");
					return;
				}
			}
			if(ap.getOrigine() == "neant") {
				if(this.getPointActionNeant() >= 1) {
					this.setPointActionNeant(this.getPointActionNeant() - 1);
					cartesEnMain.remove(c);
					c.setJoueur(null);
				}else {
					System.out.println("Point d'Action n'est pas suffisant");
					return;
				}
			}
			if(ap.getOrigine() == "nuit") {
				if(this.getPointActionNuit() >= 1) {
					this.setPointActionNuit(this.getPointActionNuit() - 1);
					cartesEnMain.remove(c);
					c.setJoueur(null);
				}else {
					System.out.println("Point d'Action n'est pas suffisant");
					return;
				}
			}
			Partie.getPartie().ApocalypseProcess(this);
			break;
		}
		
		
		
	}
	public void sacrifier() {
		ArrayList<CarteAction> c = new ArrayList<CarteAction>(); 
		Iterator<GuideSpirituel> it = this.guides.iterator();
		int j = 1;
		while(it.hasNext()) {
			GuideSpirituel g = it.next();
			c.add(g);
			int i = 0;
			System.out.println("numéro" + j);
			System.out.println(g.toString());
			while(i < g.getCroyants().size()) {
				j++;
				c.add(g.getCroyants().get(i));
				System.out.println("numéro" + j);
				System.out.println(g.getCroyants().get(i).toString());
			}
			j++;
		}
		System.out.println("choisir une carte:");
//		int i = Input.getInt() - 1;
		int i = AideGUI.getInstance().lireInt() - 1;
		if(c.get(i).getType() == "croyant") {
			
			c.get(i).sacrifier(this);
			
		}else {
			this.sacrifierGuide((GuideSpirituel)c.get(i));
		}
	}
	
	public void capaciter() {
		this.carteDivinite.capacite(Partie.getPartie());
	}
	
	public int lancerDeCosnologie() {
		Random random = new Random();
		return random.nextInt(3);
	}
	public void choisirUneOperation() {
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("choisir une opération: 0:défausser cartes 1:piocher cartes 2:utiliser carte 3:sacrifier carte 4:utiliser capacité");
		System.out.println("choisir une opération: défausser cartes; piocher cartes; utiliser carte; sacrifier carte; utiliser capacité");
		
		int n = AideGUI.getInstance().lireInt();
		
		switch (n) {
		case 0:
			defausser();
			break;
		case 1:
			piocher(Partie.getPartie().getCartes());
			break;
		case 2:
			utiliser();
			break;
		case 3:
			sacrifier();
			break;
		case 4:
			capaciter();
			break;
		default:
			//
			break;
		}
	}

	@Override
	public void poserCroyant(Croyant cc) {
		switch(cc.getOrigine()) {
		case Carte.JOUR:
			if(this.pointActionJour >= 1) {
				CST.getCroyantPublic().add(cc);
				this.pointActionJour -= 1;
			}else {
				System.out.println("Point d'Action n'est pas suffisant");
				cartesEnMain.add(cc);
				cc.setJoueur(this);
			}
			break;
		case Carte.NEANT:
			if(this.pointActionNeant >= 1) {
				CST.getCroyantPublic().add(cc);
				this.pointActionNeant -= 1;
			}else {
				System.out.println("Point d'Action n'est pas suffisant");
				cartesEnMain.add(cc);
				cc.setJoueur(this);
			}
			break;
		
		case Carte.NUIT:
			if(this.pointActionNuit >= 1) {
				CST.getCroyantPublic().add(cc);
				this.pointActionNuit -= 1;
			}else {
				System.out.println("Point d'Action n'est pas suffisant");
				cartesEnMain.add(cc);
				cc.setJoueur(this);
			}
			break;
		default :
			break;
		}
		
		
	}

	@Override
	public void poserGuide(GuideSpirituel guide) {
//		Scanner sc = new Scanner(System.in);
		this.getGuides().add(guide);
		
		while(true) {
			List<CarteAction> croyants = CST.getCroyantPublic();
			Iterator<CarteAction> it = croyants.iterator();
			
			int iDeCroyant = 0; //信徒卡编号
			
			while(it.hasNext()) {
				System.out.println(iDeCroyant);
				System.out.println(it.next().toString());
				iDeCroyant++;
			}
		
			if(CST.getCroyantPublic().size() == 0) {
				System.out.println("Il n'y a pas de Croyants au milieu de la table!");
				break;
			}
			if(guide.getNbCroyant() == guide.getNbCroyantMax()) {
				System.out.println("Le nombre de Croyants atteint le max!");
				System.out.println("Le tour de ce joueur termine");
				break;
			}
			
			System.out.println("choisir un Croyant:");
			int n = -1;
			boolean FLAG = false;
			while(!FLAG) {
//				try{
//					n = sc.nextInt();
//					if(n >= 0 && n < CST.getCroyantPublic().size()) {
//						FLAG = true;
//					}else {
//						System.out.println("Ce Croyant ne peut pas être choisi, choisir un autre nombre entier:");
//						sc.next();
//						FLAG = false;
//					}
//				}catch(InputMismatchException e) {
//					System.out.println("input illégal");
//					sc.next();
//					FLAG = false;
//				}
				n = AideGUI.getInstance().lireInt();
				if(n >= 0 && n < CST.getCroyantPublic().size()) {
					FLAG = true;
				}
			}
			
			Croyant ca =(Croyant) CST.getCroyantPublic().remove(n);
			getCroyants().add(ca);
			nbPriere = nbPriere + ca.getNbPriere();
			ca.setJoueur(this);
			guide.getCroyants().add(ca);
			guide.setNbCroyant(guide.getNbCroyant() + 1);
			System.out.println("Guide Spirituel a réussi!");
		}
	}

	@Override
	public void sacrifierCroyant() {
		
	}

	@Override
	public void sacrifierGuide(GuideSpirituel g) {
		g.sacrifier(this);
	}

	
 }














