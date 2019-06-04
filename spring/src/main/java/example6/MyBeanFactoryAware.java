package example6;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryAware implements BeanFactoryAware {
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		/* 1 */ System.out.println("FACTORY: " + factory.getClass().getSimpleName());
		/* 2 */ String[] names = ((DefaultListableBeanFactory) factory).getBeanDefinitionNames();
		int i = 1;
		System.out.println("BeanFactoryAware.setBeanFactory() - Application BEAN LIST:");
		for (String name : names) {
			System.out.println("BeanFactoryAware.setBeanFactory() - " + (i++) + ") BeanFactoryAware: name: " + name);
		}

		/* 3 */
		System.out.println("\nBeanFactoryAware.setBeanFactory() - BEANS Annotated with @Configuration:");
		Map<String, Object> map = ((DefaultListableBeanFactory) factory).getBeansWithAnnotation(Configuration.class);
		i = 1;
		Object bean = null;
		for (String key : map.keySet()) {
			bean = map.get(key);
			System.out.println("" + (i++) + ") BeanFactoryAware: Bean name: " + bean.getClass().getSimpleName());
		}
	}
}
