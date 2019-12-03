import cu.*;
import mv.*;
import re.*;

public class Main{
	public static void main(String[] args) {
		/*Movie m1=new Movie("Jack",2);
		Movie m1=new Movie("Jack",2);
		Movie m1=new Movie("Jack",2);
		*/
		Customer c1=new Customer("LiMING");
		c1.addRental(new Rental(new Movie("jack",2),6));
		System.out.print(c1.statement());
	}
}