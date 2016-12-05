package player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import carteManager.Cartes;
import carteModule.*;
import service.CartesSurTable;
import service.Partie;
import service.Process;


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
			break;
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
			DeuxEx de = (DeuxEx)c;
			de.sacrifier(this);
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
	public void choisirUneOperation() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("选择一个操作：0：扔牌，1：抽牌，2：出牌，3：牺牲，4：超能力");
		
		boolean FLAG = false;
		int n = -1;
		while(!FLAG) {
			try {
				n = sc.nextInt();
				FLAG = true;
			}catch(Exception e) {
				System.out.println("非法输入！！！请重新输入！！！");
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
	
	
	
 }














