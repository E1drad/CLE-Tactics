package tp1_project_affichage.proxy;

public class Personne implements IPersonne {
	String nom;
	String prenom;
	
	public Personne(){
		nom="defautl";
		prenom="default";
	}
	
	public Personne (String nom, String prenom){
		this.nom=nom;
		this.prenom=prenom;
	}
	
	/* (non-Javadoc)
	 * @see proxy.IPersonne#getNom()
	 */
	@Override
	public String getNom() {
		return nom;
	}
	/* (non-Javadoc)
	 * @see proxy.IPersonne#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}
	/* (non-Javadoc)
	 * @see proxy.IPersonne#getPrenom()
	 */
	@Override
	public String getPrenom() {
		return prenom;
	}
	/* (non-Javadoc)
	 * @see proxy.IPersonne#setPrenom(java.lang.String)
	 */
	@Override
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}

}
