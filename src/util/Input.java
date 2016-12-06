package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	public static int getInt() {
		Scanner sc = new Scanner(System.in);
		int n = -1;
		boolean FLAG = false; 
		while(!FLAG) {
			try {
				n = sc.nextInt();
				FLAG = true;
			}catch(InputMismatchException e) {
				System.out.println("非法输入！！请重新输入！！");
				sc.next();
				FLAG = false;
			}
		}
		return n;
	}
	
}
