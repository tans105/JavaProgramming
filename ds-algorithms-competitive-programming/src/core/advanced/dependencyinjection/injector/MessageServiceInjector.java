package core.advanced.dependencyinjection.injector;

import core.advanced.dependencyinjection.consumer.Consumer;
import core.advanced.dependencyinjection.consumer.MyDIApplication;

public interface MessageServiceInjector {

	public Consumer getConsumer();
}
