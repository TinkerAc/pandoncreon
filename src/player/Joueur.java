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
import util.Input;


public class Joueur extends JoueurABS {
	
	
	public Joueur() {
		super();
	}
	
	public void defausser() {
		Scanner sc = new Scanner(System.in);
		boolean end = false;
		try {
			do{
				showCards();
				System.out.println("��ѡ��Ҫ�ӵ����ƣ�");
				int i = sc.nextInt();
				if(i >= 0 && i < cartesEnMain.size()) {
					cartesEnMain.remove(i);
				}else {
					System.out.println("�ÿ��Ʋ����ڣ���������������");
					continue;
				}
				System.out.println("����������������ƣ���������������'No'");
				end = sc.next().equals("No");
			}while(!end);
		}catch(Exception e) {
			System.out.println("�Ƿ�����!!!���������룡����");
			defausser();
		}
		
	}
	
	
	
	/*
	 * ֮����Ҫ�Դ˷�����֣�����������ֱ��װ����Ӧ�Ŀ���������
	 * 
	 * */
	public void utiliser() {
		showPointAction();
		System.out.println("��ѡ��һ���ƣ�");
		showCards();
		Scanner sc = new Scanner(System.in);
		int i = -1;
		boolean FLAG = false;
		while(!FLAG) {
			try{
				i = sc.nextInt();
				if(i >= 0 && i < cartesEnMain.size()) {
					FLAG = true;
				}else {
					System.out.println("�Ҳ����ÿ�Ƭ�����������룡");
					FLAG = false;
				}
			}catch(InputMismatchException e) {
				System.out.println("�Ƿ�����");
				sc.next();
				FLAG = false;
			}
		}
		CarteAction c = cartesEnMain.remove(i); //c ΪҪʹ�õ���
		
		switch(c.getType()) {
		case "Croyant":
			Croyant cc = (Croyant)c;
			poserCroyant(cc);
			break;
		case "Guide":
			GuideSpirituel guide = (GuideSpirituel)c;
			poserGuide(guide);
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
				}else {
					System.out.println("�ж��㲻�㣡����");
					return;
				}
			}
			if(ap.getOrigine() == "neant") {
				if(this.getPointActionNeant() >= 1) {
					this.setPointActionNeant(this.getPointActionNeant() - 1);
				}else {
					System.out.println("�ж��㲻�㣡����");
					return;
				}
			}
			if(ap.getOrigine() == "nuit") {
				if(this.getPointActionNuit() >= 1) {
					this.setPointActionNuit(this.getPointActionNuit() - 1);
				}else {
					System.out.println("�ж��㲻�㣡����");
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
			System.out.println("���" + j);
			System.out.println(g.toString());
			while(i < g.getCroyants().size()) {
				j++;
				c.add(g.getCroyants().get(i));
				System.out.println("���" + j);
				System.out.println(g.getCroyants().get(i).toString());
			}
			j++;
		}
		System.out.println("��ѡ��Ҫ�������ƣ�");
		int i = Input.getInt() - 1;
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
		System.out.println("ѡ��һ��������0�����ƣ�1�����ƣ�2�����ƣ�3��������4��������");
		
		boolean FLAG = false;
		int n = -1;
		while(!FLAG) {
			try {
				n = sc.nextInt();
				FLAG = true;
			}catch(Exception e) {
				System.out.println("�Ƿ����룡�������������룡����");
				sc.next();
				FLAG = false;
			}
		}
		
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
	public void poserGuide(GuideSpirituel guide) {
		List<CarteAction> croyants = CST.getCroyantPublic();
		Iterator<CarteAction> it = croyants.iterator();
		Scanner sc = new Scanner(System.in);
		
		int iDeCroyant = 0; //��ͽ�����
		
		while(it.hasNext()) {
			System.out.println(iDeCroyant);
			System.out.println(it.next().toString());
		}
		while(true) {
			if(CST.getCroyantPublic().size() == 0) {
				System.out.println("����û����ͽ����");
				break;
			}
			if(guide.getNbCroyant() == guide.getNbCroyantMax()) {
				System.out.println("��ͽ���ﵽ���ޣ�");
				System.out.println("�غϽ���");
				break;
			}
			
			System.out.println("��ѡ��Ҫ�������ͽ��: ");
			int n = -1;
			boolean FLAG = false;
			while(!FLAG) {
				try{
					n = sc.nextInt();
					if(n >= 0 && n < CST.getCroyantPublic().size()) {
						FLAG = true;
					}else {
						System.out.println("�Ҳ����ÿ�Ƭ�����������룡");
						sc.next();
						FLAG = false;
					}
				}catch(InputMismatchException e) {
					System.out.println("�Ƿ�����");
					FLAG = false;
				}
			}
			
			Croyant ca =(Croyant) CST.getCroyantPublic().remove(n);
			guide.getCroyants().add(ca);
			guide.setNbCroyant(guide.getNbCroyant() + 1);
			System.out.println("��������ɹ���");
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














