package net.zaszas.booka.client.managers;

import com.calclab.suco.client.ioc.decorator.Singleton;
import com.calclab.suco.client.ioc.module.AbstractModule;
import com.calclab.suco.client.ioc.module.Factory;

public class BookaManagersModule extends AbstractModule {

    @Override
    protected void onInstall() {
	register(Singleton.class, new Factory<DocumentManager>(DocumentManager.class) {
	    @Override
	    public DocumentManager create() {
		return new DocumentManagerMemory();
	    }
	    
	});
	register(Singleton.class, new Factory<ClipManager>(ClipManager.class) {
	    @Override
	    public ClipManager create() {
		return new ClipManagerMemory();
	    }
	    
	});

    }

}
