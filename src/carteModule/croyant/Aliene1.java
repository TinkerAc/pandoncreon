package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;
import service.Partie;
import util.Input;
public class Aliene1 extends Croyant {

	public Aliene1() {
		super();
		this.nbPriere = 2;
		this.nom = "Ali��n��";
		this.origine = Carte.NEANT;
		this.description = "Emp��che une Divinit�� poss��dant le Dogme Nature ou Mystique de sacrifier une de ses cartes de Croyants durant ce tour.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Joueur> jsPourChoisir = new ArrayList<Joueur>();
		
		Iterator<Joueur> it = js.iterator();
		
		
		while(it.hasNext()) {
			Joueur j = it.next();
			String origine = j.getOrigineDivinite();
			if(origine == Carte.NATURE
					 || origine == Carte.MYSTIQUE) {
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




