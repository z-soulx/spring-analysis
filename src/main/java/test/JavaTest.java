package test;

import base.Student;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author skywalker
 */
public class JavaTest {

    private class MyList extends ArrayList {

        @Override
        public String get(int index) {
            return "";
        }
    }

    public static void main(String[] args) {
        /**
         * https://stackoverflow.com/questions/27013542/getdeclaredmethods-behaving-differently-in-java-7-vs-java-8
         * 本身子类已经继承了父类的getingredient方法返回的是objec，
         * 而子类中又定义了一个返回ArrayList的getingredient方法，
         * 如果你调用子类的getingredient方法，它应该执行哪个方法？
         * 所以实际上市一个类中两个重名的方法，
         * 这样getdeclaredMethods返会两个getingredient就不奇怪了。否者定义的时候就会出错。
         */
        for (Method method : MyList.class.getDeclaredMethods()) {
            System.out.println("name: " + method.getName() + ", return: " + method.getReturnType());
        }
    }

    @Test
    public void classpath() {
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test
    public void findClass() throws IOException {
        Enumeration<URL> base = JavaTest.class.getClassLoader().getResources("base/*");
        while (base.hasMoreElements()) {
            System.out.println(base.nextElement().toString());
        }
    }

    @Test
    public void intro() throws IntrospectionException {
        BeanInfo info = Introspector.getBeanInfo(Student.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getReadMethod());
            System.out.println(pd.getWriteMethod());
        }
    }

    @Test
    public void split() {
        String str = "1\t2\taug\tfri\t14.7\t66\t2.7\t0\t0";
        String[] arr = str.split("\t");
        System.out.println(Arrays.toString(arr));
        System.out.println(arr);
        System.out.println("月份: " + arr[2]);
        System.out.println("天气: " + arr[4]);
    }

}
