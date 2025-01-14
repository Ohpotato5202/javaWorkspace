package com.kh.chap02_encapsulation;

public class Student {
	// 필드부
	// 필드 == 멤버변수 == 인스턴스변수
	// 접근제한자 [예약어] 자료형 필드형;
	private String name;
	private int age;
	private double height;
	
	// 생성자부
	
	// 매서드부 (setter/getter)
	/*
	 *  각 기능을 구현하는 부분
	 *  
	 *  접근제한자 반환형 메소드명([매개변수]){
	 *      // 기능구현
	 * }    *
	 * */
	
	// setter메소드
	// 각 필드에 대입하고자 하는 값을 매개변수를 톻해 전달받아 , 필드에 대입시켜주는 기능의 메소드
	// 이 때, setter메소드에는 외부 클래스에서 접근일 가능해야 하기 때문에 public 접근제한자를 사용함.
	
	// 이름값을 기록 및 수정할 수 있는 setter메소드
	public void setName(String name) {  //set 뒤는 대문자로 표기
		/*
		 * 매개변수 : 현재 메소드를 호출할때 전달되는 값을
		 *          받아주기 위한 '변수' 
		 * 
		 * 필드name = 매개변수name;
		 * 이때, this 키워드가 없다면 {} 중괄호 내부에서는 해당영역에서 만들어진 변수가
		 * 접근 우선순위가 더 높기 때문에 name = name으로 호출시 항상 매개변수 name을
		 * 가리키게 된다.
		 * */
		
		this.name = name; // this? 현재 객체의 주소값을 저장하고 있는 변수 //필드 색이 파란색이면 this 사용
	}
	
    // 나이값을 기록 할수 있는 기능의 메소드
	public void setAge(int age) {
		this.age = age;
	}
    // 키값을 기록 할 수 있는 기능의 메소드
	public void setheight(double height) { 
		this.height = height;
	}
	
	// 데이터를 반환해주는 기능의 메소드 : getter 메소드
	// name 필드에 담긴 값을 돌려주는 용도의 메소드
	public String getName() {
		// 반환형을 void가 아닌 다른 자료형으로 작성한경우
		// 반드시 해당 자료형에 맞는 값을 반환(return) 시켜줘야함
		return name; // return 결과값;
	}
	
	// age필드를 반환시켜주는 get함수
	public int getAge() {
		return age;
	}
	
	// height필드를 반환시켜주는 함수
	public double getHeight() {
		return height;
	}
	
	// 모든 필드값을 하나의 문자열로 합쳐서 돌려주는 용도의 메소드
	public String toString() {
		return name+" 님의 나이는 " +age+"살이고, 키는 "+ height +"cm입니다.";
	}
	
}
