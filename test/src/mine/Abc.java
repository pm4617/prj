package mine;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Abc {
	public static void main(String[] args)	
	{
		
		  Class cl = null;
		  Object[] parameters = { null };
		  	try {
				cl = Class.forName("mine.Abc");
			
		  	mine.Abc clName = (Abc) cl.newInstance();
			Method[] methods = cl.getDeclaredMethods();
			for(Method a : methods)
			{
			//System.out.print("\n" + a.toString() +"\n");
			Method methodName = a;
			//System.out.println(methodName.getName());
			if(methodName.getName() != "main" ) { 
			methodName.setAccessible(true);
			methodName.invoke(clName);
			}
			}
			//= findMethods(actionType, methods);
			//methodName.invoke(clName, (Object) model);
		  	} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
		   
	}

	private static void method1() {
		System.out.print("ABC \n");
		
	}
	
	
	private static void method2() {
		System.out.print("XYZ \n");
		
	}
	
	private static void method3() {
		System.out.print("PQR \n");
		
	}
	
}

 

