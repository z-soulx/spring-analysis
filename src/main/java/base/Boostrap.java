package base;

import base.aop.AopDemo;
import base.transaction.TransactionBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Boostrap {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        SimpleBean bean = context.getBean(SimpleBean.class);
        bean.send();
        context.close();
//        TransactionBean bean = context.getBean(TransactionBean.class);
//        bean.process();
    }
	
}
