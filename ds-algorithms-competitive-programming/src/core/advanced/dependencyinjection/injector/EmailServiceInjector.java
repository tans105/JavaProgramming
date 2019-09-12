package core.advanced.dependencyinjection.injector;

import core.advanced.dependencyinjection.consumer.MyDIApplication;
import core.advanced.dependencyinjection.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public MyDIApplication getConsumer() {
		MyDIApplication app = new MyDIApplication();
		app.setService(new EmailServiceImpl());
		return app;
	}

}
