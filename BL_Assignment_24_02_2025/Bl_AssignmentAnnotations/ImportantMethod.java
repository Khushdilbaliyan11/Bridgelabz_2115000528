import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface importantMethod{
	String level() default "HIGH";
}
class Service{
	@importantMethod
	 public void criticalProcess() {
        System.out.println("Executing critical process...");
    }

    @importantMethod(level = "MEDIUM") 
    public void secondaryTask() {
        System.out.println("Executing secondary task...");
    }

    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}
class ImportantMethod{
	public static void main(String args[]){
		Class<Service> obj=Service.class;
		for(Method method:obj.getDeclaredMethods()){
			if(method.isAnnotationPresent(importantMethod.class)){
				importantMethod annotation=method.getAnnotation(importantMethod.class);
				      System.out.println("Method: " + method.getName() + " | Importance Level: " + annotation.level());
            }
        }
    }
}