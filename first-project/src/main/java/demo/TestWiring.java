package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestWiring {
	public static void main(String args[]) {
		ApplicationContext context = new FileSystemXmlApplicationContext("config/knight-wiring.xml");		
		Knight knight = (Knight) context.getBean("knight2");
		knight.embarkOnQuest();
	}
}
