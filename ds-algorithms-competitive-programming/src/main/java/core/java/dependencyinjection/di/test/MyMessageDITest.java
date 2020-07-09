package core.java.dependencyinjection.di.test;

import core.java.dependencyinjection.di.consumer.Consumer;
import core.java.dependencyinjection.di.injector.EmailServiceInjector;
import core.java.dependencyinjection.di.injector.MessageServiceInjector;
import core.java.dependencyinjection.di.injector.SMSServiceInjector;

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
