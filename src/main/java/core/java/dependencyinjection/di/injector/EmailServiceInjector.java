package core.java.dependencyinjection.di.injector;

import core.java.dependencyinjection.di.consumer.MyDIApplication;
import core.java.dependencyinjection.di.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public MyDIApplication getConsumer() {
		MyDIApplication app = new MyDIApplication();
		app.setService(new EmailServiceImpl());
		return app;
	}

}
