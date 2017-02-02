package tp1_project_affichage.Client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SchtroumpfHandler implements InvocationHandler{
	Object target;
	boolean active; // convertion en schtroumpf active ou non
	
	public SchtroumpfHandler(Object target) {
		super();
		this.target = target;
		this.active=true;
	}
	private Object[] convert(Object[] args) {
		List<Object> stockList = new ArrayList<Object>();
		if(args != null) { // foreach bug si args est null
			for (Object obj : args){
				if(obj instanceof String){
					stockList.add("schtroumpf");
				}else{
					stockList.add(obj);
				}
			}
		}
		Object[] args2 = new Object[stockList.size()];
		args2 = stockList.toArray(args2);	
		return args2;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {
			if(method.getName().equals("toggleString")){
				active= (!active);
				return null;
			}else{
				if(active)args= convert(args);
				
				Object ret = method.invoke(target, args);
				
				if(active && (ret instanceof String)){
					return "Schtroumpf";
				}
				return ret;
			}
	}

	

}
