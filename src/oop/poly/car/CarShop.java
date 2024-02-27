package oop.poly.car;

public class CarShop {

    public void carPrice(Car c) {
        if(c instanceof  Sonata) {
            System.out.println("소나타의 가격은 3000만 원 입니다.");

        } else if(c instanceof Tesla) {
            System.out.println("테슬라의 가격은 8000만 원 입니다.");

        } else if(c instanceof Porsche) {
            System.out.println("포르쉐의 가격은 2억 원 입니다.");
        }
    }
}
