import example.MyLabel;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        String clazzName = "example.Example1";
        if(args.length > 0){
            clazzName = args[0];
        }

        // получили объект рефлексии к классу clazzName
        Class<?> clazzExample = Class.forName(clazzName);

        // через рефлексию создаем объект класс clazzName
        Object obj = clazzExample.newInstance();

        // получили все методы
        Method[] methods = clazzExample.getMethods();
        for (var method: methods){

            // для каждого метода получили все аннотации
            //Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            boolean annotationPresent = method.isAnnotationPresent(MyLabel.class);

            if(annotationPresent){
                method.invoke(obj);
            }


        }

    }
}
