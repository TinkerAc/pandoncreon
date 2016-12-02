package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import pandoncreon.*;


public class Joueur {
	private ArrayList<CarteAction> cartesEnMain;
	private Divinite carteDivinite;
	private int pointActionJour;
	private int pointActionNeant;
	private int pointActionNuit;
	private int nbPriere;
	private List<Croyant> croyants = new ArrayList<Croyant>();
	private List<GuideSpirituel> guides = new ArrayList<GuideSpirituel>();
	private Process process;
	private Joueur nextJoueur;
	private CartesSurTable CST = CartesSurTable.getCartesSurTable();
	private int numj;
	private static int NombreJ = 0;
	private boolean isDone; //�ж�һȦ��Ϸ���Ƿ��Ѿ���������
	Joueur() {
		setCartesEnMain(new ArrayList<CarteAction>());
		carteDivinite = new Divinite();
		setPointActionJour(0);
		setPointActionNeant(0);
		setPointActionNuit(0);
		nbPriere = 0;
		process = new Process(this);
		this.setNumj(NombreJ);
		NombreJ ++;
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
	
	public void piocher(Cartes cartes) {
		System.out.println("����");
		if(cartesEnMain.size() == 7) {
			return;
		}
		while(cartesEnMain.size() < 7) {
			cartesEnMain.add(cartes.returnCarte());
		}
		
	}
	
	
	/*
	 * ֮����Ҫ�Դ˷�����֣�����������ֱ��װ����Ӧ�Ŀ���������
	 * 
	 * */
	public void utiliser() {
		System.out.println("��ѡ��һ���ƣ�");
		showCards();
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		CarteAction c = cartesEnMain.remove(i); //c ΪҪʹ�õ���
		
		switch(c.getType()) {
		case "Croyant":
			switch(c.getOrigine()) {
			case Carte.JOUR:
				if(this.pointActionJour >= 1) {
					CST.getCroyantPublic().add(c);
					this.pointActionJour -= 1;
				}else {
					cartesEnMain.add(c);
				}
			case Carte.NEANT:
				if(this.pointActionNeant >= 1) {
					CST.getCroyantPublic().add(c);
					this.pointActionNeant -= 1;
				}else {
					cartesEnMain.add(c);
				}
			case Carte.NUIT:
				if(this.pointActionNuit >= 1) {
					CST.getCroyantPublic().add(c);
					this.pointActionNuit -= 1;
				}else {
					cartesEnMain.add(c);
				}
			}
			break;
		case "Guide":
			GuideSpirituel guide = (GuideSpirituel)c;
			
			List<CarteAction> croyants = CST.getCroyantPublic();
			Iterator<CarteAction> it = croyants.iterator();

			
			int iDeCroyant = 0; //��ͽ�����
			while(it.hasNext()) {
				System.out.println(iDeCroyant);
				System.out.println(it.next().toString());
			}
			try {
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
					int n = sc.nextInt();
					if(n >= 0 && n < CST.getCroyantPublic().size()) {
						Croyant ca =(Croyant) CST.getCroyantPublic().remove(n);
						guide.getCroyants().add(ca);
						guide.setNbCroyant(guide.getNbCroyant() + 1);
						System.out.println("��������ɹ���");
					}
				}
				
			}catch(Exception e) {
				System.out.println("�Ƿ�����!!!");
				/*
				 * ��ʱ������ 
				 * �����������װ֮���ٴ���Ƿ�����
				 * 
				 * */
			}
			break;
		case "DeuxEx":
			break;
		case "Apocalypse":
			int rs = Partie.getPartie().compareNbPriere();
			
			break;
		}
		
		
		
	}
	public void sacrifier() {
		System.out.println("����");
		
	}
	public void capaciter() {
		System.out.println("������");
	}
	public int lancerDeCosnologie() {
		Random random = new Random();
		return random.nextInt(3);
	}
	public void choisirUneOperation(int n) {
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
	
	public void process() {
		this.process.start();
	}
	
	
	public void showCards() {
		for(int i = 0; i < cartesEnMain.size(); i++) {
			System.out.println(i);
			System.out.println(cartesEnMain.get(i).toString());
		}
	}
	
	
	
	//---------------------------------
	
	public int getNbPriere() {
		return nbPriere;
	}
	public String getOrigineDivinite() {
		return carteDivinite.getOrigine();
	}

	public int getPointActionJour() {
		return pointActionJour;
	}

	public void setPointActionJour(int pointActionJour) {
		this.pointActionJour = pointActionJour;
	}

	public int getPointActionNeant() {
		return pointActionNeant;
	}

	public void setPointActionNeant(int pointActionNeant) {
		this.pointActionNeant = pointActionNeant;
	}

	public int getPointActionNuit() {
		return pointActionNuit;
	}

	public void setPointActionNuit(int pointActionNuit) {
		this.pointActionNuit = pointActionNuit;
	}

	public Joueur getNextJoueur() {
		return nextJoueur;
	}

	public void setNextJoueur(Joueur nextJoueur) {
		this.nextJoueur = nextJoueur;
	}

	public ArrayList<CarteAction> getCartesEnMain() {
		return cartesEnMain;
	}

	public void setCartesEnMain(ArrayList<CarteAction> cartesEnMain) {
		this.cartesEnMain = cartesEnMain;
	}

	public int getNumj() {
		return numj;
	}

	public void setNumj(int numj) {
		this.numj = numj;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public List<Croyant> getCroyants() {
		return croyants;
	}

	public void setCroyants(List<Croyant> croyants) {
		this.croyants = croyants;
	}

	public List<GuideSpirituel> getGuides() {
		return guides;
	}

	public void setGuides(List<GuideSpirituel> guides) {
		this.guides = guides;
	}
 }














