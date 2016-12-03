package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import carteManager.Cartes;
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
	private boolean isDone; //判断一圈游戏中是否已经操作结束
	Joueur() {
		setCartesEnMain(new ArrayList<CarteAction>());
		//carteDivinite = new Divinite();
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
				System.out.println("请选择要扔掉的牌：");
				int i = sc.nextInt();
				if(i >= 0 && i < cartesEnMain.size()) {
					cartesEnMain.remove(i);
				}else {
					System.out.println("该卡牌不存在！！！请重新输入");
					continue;
				}
				System.out.println("输入任意键继续扔牌，结束扔牌请输入'No'");
				end = sc.next().equals("No");
			}while(!end);
		}catch(Exception e) {
			System.out.println("非法输入!!!请重新输入！！！");
			defausser();
		}
		
	}
	
	public void piocher(Cartes cartes) {
		System.out.println("抽牌");
		if(cartesEnMain.size() == 7) {
			return;
		}
		while(cartesEnMain.size() < 7) {
			cartesEnMain.add(cartes.returnCarte());
		}
		
	}
	
	
	/*
	 * 之后需要对此方法拆分，将四种情况分别封装到对应的卡牌类里面
	 * 
	 * */
	public void utiliser() {
		showPointAction();
		System.out.println("请选择一张牌：");
		showCards();
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		CarteAction c = cartesEnMain.remove(i); //c 为要使用的牌
		
		switch(c.getType()) {
		case "Croyant":
			Croyant cc = (Croyant)c;
			switch(cc.getOrigine()) {
			case Carte.JOUR:
				if(this.pointActionJour >= 1) {
					CST.getCroyantPublic().add(cc);
					this.pointActionJour -= 1;
				}else {
					System.out.println("行动点不足");
					cartesEnMain.add(cc);
				}
				break;
			case Carte.NEANT:
				if(this.pointActionNeant >= 1) {
					CST.getCroyantPublic().add(cc);
					this.pointActionNeant -= 1;
				}else {
					System.out.println("行动点不足");
					cartesEnMain.add(cc);
				}
				break;
			case Carte.NUIT:
				if(this.pointActionNuit >= 1) {
					CST.getCroyantPublic().add(cc);
					this.pointActionNuit -= 1;
				}else {
					System.out.println("行动点不足");
					cartesEnMain.add(cc);
				}
				break;
			default :
				break;
			}
		case "Guide":
			GuideSpirituel guide = (GuideSpirituel)c;
			
			List<CarteAction> croyants = CST.getCroyantPublic();
			Iterator<CarteAction> it = croyants.iterator();

			
			int iDeCroyant = 0; //信徒卡编号
			while(it.hasNext()) {
				System.out.println(iDeCroyant);
				System.out.println(it.next().toString());
			}
			try {
				while(true) {
					if(CST.getCroyantPublic().size() == 0) {
						System.out.println("桌上没有信徒卡！");
						break;
					}
					if(guide.getNbCroyant() == guide.getNbCroyantMax()) {
						System.out.println("信徒卡达到上限！");
						System.out.println("回合结束");
						break;
					}
					System.out.println("请选择要引领的信徒卡: ");
					int n = sc.nextInt();
					if(n >= 0 && n < CST.getCroyantPublic().size()) {
						Croyant ca =(Croyant) CST.getCroyantPublic().remove(n);
						guide.getCroyants().add(ca);
						guide.setNbCroyant(guide.getNbCroyant() + 1);
						System.out.println("精神引领成功！");
					}
				}
				
			}catch(Exception e) {
				System.out.println("非法输入!!!");
				/*
				 * 暂时不处理 
				 * 将精神引领封装之后再处理非法输入
				 * 
				 * */
			}
			break;
		case "DeuxEx":
			break;
		case "Apocalypse":
			Partie.getPartie().ApocalypseProcess(this);
			break;
		}
		
		
		
	}
	public void sacrifier() {
		System.out.println("牺牲");
		
	}
	public void capaciter() {
		System.out.println("超能力");
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
	public void showPointAction() {
		System.out.println("当前白天行动点：" + this.getPointActionJour());
		System.out.println("当前虚无行动点：" + this.getPointActionNeant() );
		System.out.println("当前黑夜行动点：" + this.getPointActionNuit());
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
	
	public void setCarteDivinite(Divinite d) {
		this.carteDivinite = d;
	}
 }














