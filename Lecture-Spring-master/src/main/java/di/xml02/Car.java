package di.xml02;

public class Car {

   private Tire tire;
   
   public Car() {
      System.out.println("Car() 호출....");
   }
   
   public Car(Tire tire) {
      this.tire = tire;
      System.out.println("Car(Tire) 호출...");
   }
   
   public Car(Tire tire1, Tire tire2) {
      System.out.println("Car(Tire, Tire) 호출...");
   }
   
   public Car(Tire tire, String str) { //xml 파일의 index에 따라 호출되는 생성자가 다름
      System.out.println("Car(Tire,string)호출..");
      System.out.println("str : " + str);
   }
   
   public Car(String  str, Tire tire) {  //xml 파일의 index에 따라 호출되는 생성자가 다름
	      System.out.println("Car(String,tire)호출..");
	      System.out.println("str : " + str);
	   }
   
   public void prnTireBrand() {
      System.out.println("장착된타이어 : " + tire.getBrand());
   }
//생성자 주입에 대한 것을 하고 싶다.
   
   
   
}