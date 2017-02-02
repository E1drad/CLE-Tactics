package tp1_project_affichage.Client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Normalement fait dans le framework
public class LogHandler implements InvocationHandler {
	Object target;
	public LogHandler(Object target) {
	super();
	this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(method.getName()+" use on "+target);
		return null;
	}

}
