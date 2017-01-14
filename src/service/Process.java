package service;

import java.util.Scanner;

import player.Joueur;
import ui.Panel_main;

public class Process {
	protected Joueur joueur;
	
	public Process(Joueur j) {
		this.joueur = j;
		
	}
	
	/*
	 *进入
	 * */
	public void start() {
		
		//测试代码 ，用后删除！！！
		System.out.println("joueur" + this.joueur.getNumj());
		joueur.choisirUneOperation();
		joueur.setDone(true);
		pass();
	}
	public synchronized void pass() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				Panel_main.getPM(0).repaint();
			}
			
		};
		new Thread(run).start();
		if(joueur.getNextJoueur().isDone() == false) {
			joueur.getNextJoueur().process();
		}
	}
	
}




















