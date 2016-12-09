package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;
import service.Partie;
import util.Input;

public class Aliene2 extends Croyant {
	
	public Aliene2() {
		super();
		this.nbPriere = 2;
		this.nom = "Ali��n��";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{Carte.CHAOS,Carte.HUMAIN,Carte.SYMBOLES};
		this.description = "Emp��che une Divinit�� poss��dant le Dogme Chaos ou Mystique de sacrifier un de ses Guides Spirituels ";
		
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Joueur> jsPourChoisir = new ArrayList<Joueur>();
		
		Iterator<Joueur> it = js.iterator();
		
		
		while(it.hasNext()) {
			Joueur j = it.next();
			String origine = j.getOrigineDivinite();
			if(origine == Carte.HUMAIN
					 || origine == Carte.SYMBOLES) {
				jsPourChoisir.add(j);
				System.out.println("��ѡ��ң�" + j.getNumj());
			}
		}
		
		System.out.println("��ѡ��һ����ң�");
		while(true) {
			int i = Input.getInt();
			boolean isExist = false;
			for(int j = 0; j < jsPourChoisir.size(); j++) {
				if(i == jsPourChoisir.get(j).getNumj()) {
					isExist = true;
				}
			}
			if(isExist == true) {
				js.get(i).setEnableSacrifier(false);
				break;
			}else {
				System.out.println("����Ҳ���ѡ������������ѡ�񣡣���");
			}
		}
		
		
	}

}
