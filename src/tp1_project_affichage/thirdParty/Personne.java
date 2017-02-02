package tp1_project_affichage.thirdParty;

public class Personne implements IPersonne {

	private String nom;
	private String ville;
	private int age;
	
	
	public Personne(){
		nom="default";
		ville="default";
		setAge(-1);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString(){
		String retour="";
		
		retour+=" Yo je m'appelle "+nom+" Et j\'habite à "+ville+". Et mon age est "+age+".";
		return retour;
	}
}
