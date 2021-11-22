package streamex;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("이순신", 40));
        memberList.add(new Member("김유신", 20));
        memberList.add(new Member("홍길동", 13));

        memberList.forEach(System.out::println);
        int totalPrice = memberList.stream().mapToInt(s -> s.getTravelPrice().getPrice()).sum();
        System.out.println(totalPrice + "만원");
        memberList.stream().filter(a -> a.getAge() >= 20).map(c -> c.getName()).filter(c -> c.contains("김")).sorted().forEach(System.out::println);
    }
}