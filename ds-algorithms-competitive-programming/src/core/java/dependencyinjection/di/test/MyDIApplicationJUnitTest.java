package core.java.dependencyinjection.di.test;

import core.java.dependencyinjection.di.consumer.Consumer;
import core.java.dependencyinjection.di.consumer.MyDIApplication;
import core.java.dependencyinjection.di.injector.MessageServiceInjector;
import core.java.dependencyinjection.di.service.MessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MyDIApplicationJUnitTest {

	private MessageServiceInjector injector;
	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {

			@Override
			public MyDIApplication getConsumer() {
				//mock the message service
				return new MyDIApplication(new MessageService() {

					@Override
					public void sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");

					}
				});
			}
		};
	}
	
	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
	}
	
	@After
	public void tear(){
		injector = null;
	}

}
