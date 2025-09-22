import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1
        Class<String> stringClazz1 = String.class;
        System.out.println(stringClazz1);

        //2
        String s = "qwe";
        Class<? extends String> aClass = s.getClass();

        //3
        Class<?> aClass1 = Class.forName("java.lang.String");

        Method[] declaredMethods = stringClazz1.getDeclaredMethods();
        for (var m:declaredMethods) {
            System.out.println(m);
        }
        System.out.println("------------------------------------");
        Field[] declaredFields = stringClazz1.getDeclaredFields();
        for (var f:declaredFields){
            System.out.println(f);
        }

    }
}
