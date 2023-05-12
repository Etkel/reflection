import java.util.Objects;

public class Goods {

    private String name;
    private double price;
    private int number;


    public Goods(String name, int number, double price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public Goods() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public  void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Double.compare(goods.price, price) == 0 &&
                number == goods.number && Objects.equals(name, goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, number);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
