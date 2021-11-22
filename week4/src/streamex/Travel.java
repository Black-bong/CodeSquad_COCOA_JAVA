package streamex;

public class Travel {
    int price;

    public Travel (int age) {
        if(age >= 15) {
           price = 100;
        } else {
            price = 50;
        }
    }

    @Override
    public String toString() {
        return price + "만원";
    }

    public int getPrice() {
        return price;
    }
}
