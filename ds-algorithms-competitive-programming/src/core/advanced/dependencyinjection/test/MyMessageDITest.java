package core.advanced.dependencyinjection.test;

import core.advanced.dependencyinjection.consumer.Consumer;
import core.advanced.dependencyinjection.injector.EmailServiceInjector;
import core.advanced.dependencyinjection.injector.MessageServiceInjector;
import core.advanced.dependencyinjection.injector.SMSServiceInjector;

public class MyMessageDITest {

	public static void main(String[] args) {
		String msg = "Hi Tanmay";
		String email = "tanmay@abc.com";
		String phone = "4088888888";
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}

}
