package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

class ReflectionItem{
    private String name;
    private final int point;

    public ReflectionItem() {
        name = "test";
        point = 10;
    }

    ReflectionItem(String name, int point) {
        this.name = name;
        this.point = point;
    }
}
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> itemClass = Class.forName("reflection.ReflectionItem");
        ReflectionItem.class.getName();
        System.out.println(itemClass);
        Class<?> person = Class.forName("collections.Person");
        System.out.println(person);
        Constructor<?>[] constructors = person.getConstructors();
        System.out.println(Arrays.toString(constructors));
        System.out.println(Arrays.toString(itemClass.getConstructors()));
        System.out.println(Arrays.toString(itemClass.getDeclaredConstructors()));
        //utworzenie obiektu przez refleksję
        ReflectionItem instance = (ReflectionItem) itemClass.getConstructor().newInstance();
        //dostep do pól
        Field[] declaredFields = itemClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
        Field firstField = itemClass.getDeclaredField("name");
        //uzyskanie dostepu do zabezpieczonych i prywatnych pól
        firstField.setAccessible(true);
        //instancja do obiektu
        String name = (String) firstField.get(instance);
        System.out.println(name);
    }
}
