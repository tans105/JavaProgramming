package core.advanced.dependencyinjection.test;

import core.advanced.dependencyinjection.consumer.Consumer;
import core.advanced.dependencyinjection.consumer.MyDIApplication;
import core.advanced.dependencyinjection.injector.MessageServiceInjector;
import core.advanced.dependencyinjection.service.MessageService;
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
