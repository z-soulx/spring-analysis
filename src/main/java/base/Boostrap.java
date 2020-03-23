package base;

import base.aop.AopDemo;
import base.transaction.TransactionBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Boostrap {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
           //设置环境轮廓
//        context.getEnvironment().setActiveProfiles("dev");
        //测 占位符替换
        System.setProperty("spring", "classpath");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("${spring}:config.xml");

		SimpleBean bean = context.getBean(SimpleBean.class);
        bean.send();
        context.close();
//		TransactionBean bean = context.getBean(TransactionBean.class);
//        bean.process();
    }
	
}
