package mine;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class abc {
	public static void main(String[] args[]) throws InstantiationException, IllegalAccessException	
	{
		
		  Class cl = null;
		
		  	try {
				cl = (Class) Class.forName("mine.abc");
			
		  	mine.abc clName = (abc) cl.newInstance();
			Method[] methods = cl.getMethods();
			for(Method a : methods)
			{
				System.out.print(a.toString());
			}
			//Method methodName = findMethods(actionType, methods);
			//methodName.invoke(clName, (Object) model);
		  	} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		   
	}

	private static void method1() {
		System.out.print("ABC");
		
	}
	
	
}

 

