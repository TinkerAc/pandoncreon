package pandoncreon;

public class Carte {
	
	public static final String JOUR = "jour";
	public static final String NEANT = "neant";
	public static final String NUIT = "nuit";
 	
	
	protected String type;
	protected String origine;
	protected String nom;
	protected String description;
	protected String [] dogmes;

	public String getType() {
		return this.type;
	}
	
	public String getOrigine() {
		return this.origine;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("----------------------------------------------------------------------\n");
		sb.append("|TYPE: " + this.type + '\n');
		sb.append("|NOM: "+ this.nom + '\n');
		sb.append("|ORIGINE:" + this.origine + '\n');
		sb.append("|DESCRIPTION: " + this.description + '\n');
		sb.append("----------------------------------------------------------------------" + '\n');
		return sb.toString();
	}
}










