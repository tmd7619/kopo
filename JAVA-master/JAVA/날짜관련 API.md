### 날짜관련 API

- 날짜관련 API 클래스
  - Date : 1.0버전 부터 지원되지만 1.1 부터는 Calendar 사용 권장
    - 이미 과거에 배포되었던 Date()클래스가 있기 때문에, 알알아둘 필요가 있음
  - Calendar
  - SimpleDateFormat



#### Date



#### Calendar

- Calendar에는 구현메소드 getInstance() 가 있다
- 하지만 Calendar클래스는 추상클래스로서, 구현메소드를 사용하기위해  static으로 만들어져있음 (추상클래스는 객체 생성이 불가능하기 때문에)
  - 자식클래스를 만들고, 자식클래스에서 객체생성 후 사용할 수 있긴함 



