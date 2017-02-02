package tp1_project_affichage.thirdParty;
import tp1_project_affichage.appli.IAffichage;
public class AffichageConsole implements IAffichage {
	
	public void affichage(IPersonne p){
		System.out.println(p.toString());
	}
}
