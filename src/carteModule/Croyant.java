package carteModule;


public abstract class Croyant extends CarteAction{

	protected int nbPriere;
	protected GuideSpirituel guide;	  //ָ��guide��ָ��
	
	protected Croyant() {
		super();
		this.type = "Croyant";
	}
	
	public void utiliser() {
		
	}

	public int getNbPriere() {
		return nbPriere;
	}

	public void setNbPriere(int nbPriere) {
		this.nbPriere = nbPriere;
	}

	public GuideSpirituel getGuide() {
		return guide;
	}

	public void setGuide(GuideSpirituel guide) {
		this.guide = guide;
	}
	
}
