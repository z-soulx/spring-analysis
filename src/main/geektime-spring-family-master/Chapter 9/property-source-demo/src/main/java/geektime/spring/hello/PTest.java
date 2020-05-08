package geektime.spring.hello;

/**
 * @program: spring
 * @description:
 * 会加载进cach，但是必须要写自动配置的类来才会生成这些实例。
 * @author: soulx
 * @create: 2020-05-08 20:30
 **/
public class PTest implements Test {
    @Override
    public void say() {
        System.out.println("test");
    }
}
