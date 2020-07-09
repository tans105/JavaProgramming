package core.java.dependencyinjection.di.injector;

import core.java.dependencyinjection.di.consumer.MyDIApplication;
import core.java.dependencyinjection.di.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public MyDIApplication getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}
