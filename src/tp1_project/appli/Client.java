package tp1_project.appli;
import tp1_project.framework.*;
import  tp1_project.thirdParty.*;
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object data;
		try{
			data= BeanLoader.loadBeanWithAge("bean.txt");
			System.out.println(data.toString());
		}catch (Exception e){
			System.out.println("Error while loading the data file");
		}
		
		

	}

}
