package di.xml01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class DriverMain {

   public static void main(String[] args) {
      
      ApplicationContext context = new GenericXmlApplicationContext("di-xml01.xml");
      
      
      
      
      //방법 2 // property를 이용해 setter함수를 실행하지 않아도, 객체 주입이 가능해진다.
      Car car = (Car)context.getBean("car2"); // id값이 car2인 객체를 불러온다. // return형이 object로, 명시적 형변환 필수 
      car.prnTireBrand();
      
      
      
      // 방법1
      /*
      Car car = (Car)context.getBean("car");
      Tire tire = (Tire)context.getBean("tire");
      car.setTire(tire);
      car.prnTireBrand();
      */
      
      
      /*
       * Car car = new Car(); 
       * Tire tire = new HankookTire();
       * 
       * car.setTire(tire); 
       * car.prnTireBrand();
       */
      
   }
}