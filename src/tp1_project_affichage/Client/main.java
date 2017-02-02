package tp1_project_affichage.Client;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import tp1_project_affichage.proxy.IPersonne;
import tp1_project_affichage.proxy.Personne;

public class main {

	IPersonne interPers;
	
	// Normalement fait dans le framewor
	private static Object proxifyLog(Object p) {
		return Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), new LogHandler(p));
	}
	
	private static Object proxifySchtroumpf(Object p){
		return Proxy.newProxyInstance(p.getClass().getClassLoader(), concat(p.getClass().getInterfaces(),SchtroumpfMode.class), new SchtroumpfHandler(p));

	}
	
	private static Class<?>[] concat(Class<?>[] interfaces,
			Class<?>... class1) {
		List<Object> stockList = new ArrayList<Object>();
		
		for (Class<?> cl : interfaces){
			stockList.add(cl);
		}
		
		for (Class<?> cl : class1){
			stockList.add(cl);
		}
		
		Class<?>[] stockArr = new Class<?>[stockList.size()];
		stockArr = stockList.toArray(stockArr);	
		return stockArr;
	}

	public static void main(String[] args) {
	IPersonne p =new Personne("yolo","truc");
	IPersonne p2  =new Personne();
	p=(IPersonne) proxifySchtroumpf(p);
	System.out.println(p.toString());
	((SchtroumpfMode)p).toggleString();
	System.out.println(p.toString());
	System.out.println(p.getNom());
	
	System.out.println("on test le log");

	p2=(IPersonne) proxifyLog(p2);
	System.out.println(p2.toString());

	}

	

}
