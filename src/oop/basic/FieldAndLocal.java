package oop.basic;

/*
    # 멤버 변수(field, class member variable)
    1. 클래스 블록에 선언된 변수를 의미합니다.
    2. 메모리의 heap 영역에 저장되며, 값을 초기화하지 않아도
     각 데이터타입의 기본값으로 자동 초기화됩니다.
    3. 객체를 가리키고 있는 레퍼런스변수(참조변수)가 사라지거나
     주소값을 잃어버리게 되면, 메모리에서 가비지 컬렉터(gc)에 의해
     자동으로 제거됩니다.

    # 지역 변수 (local variable)
    1. 메서드나 생성자 블록 내부에서 선언된 변수를 의미합니다.
    2. 메모리의 stack 영역에 저장되며, 선언된 블록을 벗어나면
     메모리에서 자동으로 소멸합니다.
    3. 값을 초기화하지 않으면 변수를 사용할 수 없습니다.
*/

public class FieldAndLocal {

    int a; // 필드(멤버 변수) -> 객체 생성 시 자동으로 초기화 됨.

    void printNumber(int c) { // 매개변수
        int b = 10; // 지역 변수 -> 반드시 초기화를 수동으로 해야함.
        System.out.println("필드 a = " + a);
        System.out.println("지역변수 b = " + b);
        System.out.println("매개변수 c = " + c);
    }

    void foo() {
        System.out.println("필드 a = " + a); // 필드는 어느 메서드에서든지 참조가 가능.
//        System.out.println("지역변수 b = " + b); (x) 지역변수라서 안됨.

    }

}
