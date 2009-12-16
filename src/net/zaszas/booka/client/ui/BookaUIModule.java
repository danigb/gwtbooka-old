package net.zaszas.booka.client.ui;

import net.zaszas.booka.client.ui.playground.Playground;

import com.calclab.suco.client.ioc.Provider;
import com.calclab.suco.client.ioc.decorator.Singleton;
import com.calclab.suco.client.ioc.module.AbstractModule;

public class BookaUIModule extends AbstractModule{

    @Override
    protected void onInstall() {
	register(Singleton.class, Playground.class, new Provider<Playground>() {
	    @Override
	    public Playground get() {
		return new Playground();
	    }
	});
    }
}
