class Animal{
	public void makeSound(){
		System.out.println("Make sound");
	}
}
class Dog extends Animal{
	 public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class AnimalMain {
    public static void main(String[] args) {
        Animal myDog = new Dog(); 
        myDog.makeSound(); 
    }
}