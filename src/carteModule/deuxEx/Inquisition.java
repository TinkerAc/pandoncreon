package carteModule.deuxEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import carteModule.Croyant;
import carteModule.DeuxEx;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;

public class Inquisition extends DeuxEx {

	public Inquisition(){
		super();
		this.nom = "Inquisition";
		this.origine = "sans Origine";
		this.description = "Choisissez un des Guides Spirituels d'un autre joueur, et l'un des votres. Lancez le d¨¦ de Cosmogonie. Sur Jour, le Guide adverse est sacrifi¨¦, sur Nuit le votre est sacrifi¨¦, sur N¨¦ant rien ne se passe.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		System.out.println("choisir un Guide Spirituel de vous:");
		Iterator<GuideSpirituel> it = this.joueur.getGuides().iterator();
		int count = 0;
		while(it.hasNext()){
			System.out.println(count + ":");
			System.out.println(it.next().toString());
		}
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		GuideSpirituel gs = this.joueur.getGuides().get(n1);
		Iterator<GuideSpirituel> it2;
		int count2;
		System.out.println("choisir un Guide Spirituel d'un autre joueur:");
		for(int i = 0; i < js.size(); i++) {
			if(i != js.indexOf(this.joueur)) {
				System.out.println("joueur" + i + ":");
				it2 = js.get(i).getGuides().iterator();
				count2 = 0;
				while(it2.hasNext()){
					System.out.println("Guide Spirituel " + count2 + ":");
					System.out.println(it2.next().toString());
				}
			}
		}
		System.out.println("choisir un joueur:");
		int n2 = sc.nextInt();
		System.out.println("choisir un Guide Spirituel:");
		int n3 = sc.nextInt();
		GuideSpirituel gs2 = js.get(n2).getGuides().get(n3);
		int point = this.joueur.lancerDeCosnologie();
		if(point == 0){
			gs.sacrifier(joueur);
			this.joueur.getGuides().remove(gs);
			this.joueur.getCartesEnMain().remove(this);
		}
		if(point == 2){
			gs2.sacrifier(joueur);
			js.get(n2).getGuides().remove(gs2);
			this.joueur.getCartesEnMain().remove(this);
		}
		if(point == 1){
			this.joueur.getCartesEnMain().remove(this);
		}
	}

}
