package core.advanced.dependencyinjection.injector;

import core.advanced.dependencyinjection.consumer.MyDIApplication;
import core.advanced.dependencyinjection.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public MyDIApplication getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}
