
public class MyClass {
	
	public static void main(String[] args) {
		if (args.length != 0) {
			String sentence ="";
			
			// Add all arguments to display sentence
			for (int i = 0; i < args.length; i++) {
				sentence += " ";
				sentence += args[i];
			}
			
			System.out.println("Hello " + sentence + " !");
		}
		else {
			System.out.println("Hello World");
		}
		
	}
}
