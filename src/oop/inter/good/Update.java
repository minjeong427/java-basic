package oop.inter.good;

public class Update implements IUserService {

    @Override
    public void execute() {
        System.out.println("회원정보 수정 요청이 들어옴!");
        System.out.println("수정 정보를 받아서 데이터베이스에서 수정 조치...");
    }
}
