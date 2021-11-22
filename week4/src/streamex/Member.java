package streamex;

public class Member {
    String name;
    int age;
    Travel travelPrice;

    Member(String name, int age) {
        this.name = name;
        this.age = age;
        travelPrice = new Travel(this.age);
    }

    @Override
    public String toString() {
        return "고객이름: " + name + ", 나이: " + age + ", 비용: " + travelPrice;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Travel getTravelPrice() {
        return travelPrice;
    }
}
