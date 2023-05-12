import java.lang.reflect.*;
import java.util.Arrays;

public class HackMachine {

    public String restoreClassMetainf(Class clazz) throws InstantiationException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();

        sb.append("\n" + "Class: ").append(Modifier.toString(clazz.getModifiers())).
                append(" ").append(clazz.getName()).append(" extends ").
                append(clazz.getSuperclass()).append(" implements ").
                append(Arrays.toString(clazz.getInterfaces()));

        sb.append("\n\nFields\n\n");
        var fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Object obj = clazz.newInstance();
            field.setAccessible(true);
            sb.append(Modifier.toString(field.getModifiers())).
                    append(" ").append(field.getType()).append(" ").
                    append(field.getName()).append(" = ").append(field.get(obj)).
                    append("\n");
        }

        sb.append("\nConstructors\n\n");
        var constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            sb.append(Modifier.toString(constructor.getModifiers())).append(" ").
                    append(constructor.getName()).append(" ").
                    append(Arrays.toString(constructor.getParameters())).append("\n");
        }

        sb.append("\nMethods\n\n");
        var methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            sb.append(Modifier.toString(method.getModifiers())).append(" ").
                    append(method.getName()).append(" ").
                    append(Arrays.toString(method.getParameters())).append("\n");
        }
        return sb.toString();
    }

    public void uRHacked (Object obj) throws IllegalAccessException {
        var a = obj.getClass();
        Field[] fields = a.getDeclaredFields();
        Field.setAccessible(fields,true);
        for (int i = 0; i < a.getDeclaredFields().length; i ++) {
            if (fields[i].getType().getTypeName().equals(String.class.getTypeName())) {
                fields[i].set(obj, "You're hacked. Send 10 btc to 34kNXokGAdmLvsJFFZdrkn27PPtvYLXDYS");
            }
        }
    }
}
