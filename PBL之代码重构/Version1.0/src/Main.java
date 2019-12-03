import mv.*;
import cu.Customer;
import re.*;
public class Main{
  public static void main(String[] args) {
     /*Movie m1=new Movie("Jack",2);
     Movie m2=new Movie("Rose",1);
     Movie m3=new Movie("Boss",0);
     Rental r1=new Rental(m1,5);
     Rental r2=new Rental(m2,6);
     Rental r3=new Rental(m3,4);
     Customer c1=new Customer("LiLei");
     c1. addRental(r1) ;
     c1. addRental(r2);
     c1. addRental(r3);
     System. out . print("×âÓÃÇåµ¥£º"+"\n"+c1.statement());
  */
      Customer c1=new Customer("LiMing");
      c1. addRental(new Rental(new Movie("Jack",2),6));
      //c1. addRental(new Rental(new Movie("Rose" ,1),5));
      //c1. addRental(new Rental(new Movie("Bos",0),4));
      System. out.print(c1. statement());
  }
}