package util;

public class AideGUI {
	public int msg;
	
	private static AideGUI ag;
	
	
	private AideGUI(){
		msg=123;
	}
	
	public static AideGUI getInstance(){
		if(ag == null){
			ag = new AideGUI();
		}
		return ag;
	}
	
	public synchronized void deposerInt(int msg) throws InterruptedException{
		while(this.msg!=123){
			
				
				wait();
			
		
		}
		this.msg=msg;
		System.out.println("input:  "+msg+"..........................");
		notifyAll();
	}
	
	public synchronized int lireInt(){
		while(this.msg==123){
			try {
			
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		int msgRecu=msg;
		msg=123;


		return msgRecu;
	}
}
