package tp1_project_affichage.appli;
import tp1_project_affichage.framework.*;
import tp1_project_affichage.thirdParty.*;

public class Client {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IPersonne p;
		Object data;
		IAffichage aff;
		try{
			data= BeanLoader.loadBeanWithAge("bean.txt");
			//IAffichage aff= new AffichageConsole();
			
			// new truc pour éviter static
			 aff= (IAffichage) (new ExtLoader()).loadExtensionv2(IAffichage.class);
			aff.affichage((IPersonne)data);
		}catch(Exception e){
			System.out.println("Error while loading the data file");
		}
		
	}

}
