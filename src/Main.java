import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        HackMachine hackMachine = new HackMachine();

        Goods goods = new Goods();

        var clazz = goods.getClass();

        try {
            System.out.println(hackMachine.restoreClassMetainf(clazz));
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Error");
        }

        try {
            hackMachine.uRHacked(goods);
            var fields = clazz.getDeclaredFields();
            Field.setAccessible(fields,true);
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i].getType() + " " + fields[i].get(goods));
            }
        } catch (IllegalAccessException e) {
            System.out.println("Not Hacked");
        }

    }
}