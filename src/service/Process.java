package service;

import java.util.Scanner;

public class Process {
	private Joueur joueur;
	
	Process(Joueur j) {
		this.joueur = j;
	}
	
	
	/*
	 *进入
	 * */
	public void start() {
		Scanner sc = new Scanner(System.in);
		//测试代码 ，用后删除！！！
		System.out.println("选择一个操作：0：扔牌，1：抽牌，2：用牌，3：牺牲，4：超能力");
		joueur.choisirUneOperation(sc.nextInt());
		pass();
	}
	public void pass() {
		if(joueur.getNextJoueur() != null) {
			joueur.getNextJoueur().process();
		}
	}
	
}




















