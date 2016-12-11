package player;

import java.util.Iterator;

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
		System.out.println("���" + this.numj + "������...");
		this.getCartesEnMain().clear();
	}

	@Override
	public void utiliser() {
		Iterator<CarteAction> it = this.cartesEnMain.iterator();
		while(it.hasNext()) {
			CarteAction c = (CarteAction)it.next();
			switch(c.getOrigine()) {
			case "jour":
				if(this.getPointActionJour() > 0) {
					this.setPointActionJour(this.getPointActionJour() - 1);
					if(c.getType() == "croyant") {
						this.poserCroyant((Croyant) c);
						System.out.println("���" + this.numj + "poser��һ��croyant");
						System.out.println(c.toString());
					}
					if(c.getType() == "guide") {
						if(CST.getCroyantPublic().size() > 0) {
							this.poserGuide((GuideSpirituel)c);
							
						}else {
							continue;
						}
					}
					/*if(c.getType() == "DeuxEx") {
						DeuxEx de = (DeuxEx)c;
						de.sacrifier(this);
					}*/
					if(c.getType() == "Apocalypse") {
						Apocalypse ap = (Apocalypse)c;
						Partie.getPartie().ApocalypseProcess(this);
					}
					
				}
				break;
			case "neant":
				if(this.getPointActionNeant() > 0) {
					this.setPointActionNeant(this.getPointActionNeant() - 1);
					if(c.getType() == "croyant") {
						this.poserCroyant((Croyant) c);
						System.out.println("���" + this.numj + "poser��һ��croyant");
						System.out.println(c.toString());
					}
					if(c.getType() == "guide") {
						if(CST.getCroyantPublic().size() > 0) {
							this.poserGuide((GuideSpirituel)c);
							System.out.println("���" + this.numj + "poser��һ��guide");
							System.out.println(c.toString());
						}else {
							continue;
						}
					}
					/*if(c.getType() == "DeuxEx") {
						DeuxEx de = (DeuxEx)c;
						de.sacrifier(this);
					}*/
					if(c.getType() == "Apocalypse") {
						Apocalypse ap = (Apocalypse)c;
						Partie.getPartie().ApocalypseProcess(this);
					}
					
				}
				break;
			case "nuit":
				if(this.getPointActionNuit() > 0) {
					this.setPointActionNuit(this.getPointActionNuit() - 1);
					if(c.getType() == "croyant") {
						this.poserCroyant((Croyant) c);
						System.out.println("���" + this.numj + "poser��һ��croyant");
						System.out.println(c.toString());
					}
					if(c.getType() == "guide") {
						if(CST.getCroyantPublic().size() > 0) {
							this.poserGuide((GuideSpirituel)c);
						}else {
							continue;
						}
					}
					/*if(c.getType() == "DeuxEx") {
						DeuxEx de = (DeuxEx)c;
						de.sacrifier(this);
					}*/
					if(c.getType() == "Apocalypse") {
						Apocalypse ap = (Apocalypse)c;
						Partie.getPartie().ApocalypseProcess(this);
					}
					
				}
				break;
			}
			
		}
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
		if(this.getPointActionJour() > 0 || this.getPointActionNeant() > 0 || this.getPointActionNuit() > 0) {
			utiliser();
			return;
		}else {
			defausser();
			return;
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
				System.out.println("�ж��㲻��");
				cartesEnMain.add(cc);
			}
			break;
		case Carte.NEANT:
			if(this.pointActionNeant >= 1) {
				CST.getCroyantPublic().add(cc);
				this.pointActionNeant -= 1;
			}else {
				System.out.println("�ж��㲻��");
				cartesEnMain.add(cc);
			}
			break;
		
		case Carte.NUIT:
			if(this.pointActionNuit >= 1) {
				CST.getCroyantPublic().add(cc);
				this.pointActionNuit -= 1;
			}else {
				System.out.println("�ж��㲻��");
				cartesEnMain.add(cc);
			}
			break;
		default :
			break;
		}
	}

	@Override
	public void poserGuide(GuideSpirituel g) {
		
	}

	@Override
	public void sacrifierCroyant() {
		
	}


	@Override
	public void sacrifierGuide(GuideSpirituel g) {
		
	}
	
	
}
