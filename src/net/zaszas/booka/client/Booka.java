package net.zaszas.booka.client;

import net.zaszas.booka.client.managers.BookaManagersModule;
import net.zaszas.booka.client.ui.BookaUIModule;
import net.zaszas.booka.client.ui.booka.BookaUI;

import com.calclab.suco.client.Suco;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Booka implements EntryPoint {
    @Override
    public void onModuleLoad() {

	Suco.install(new BookaManagersModule());
	Suco.install(new BookaUIModule());
	
	RootLayoutPanel.get().add(Suco.get(BookaUI.class));
    }
}