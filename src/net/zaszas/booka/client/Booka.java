package net.zaszas.booka.client;

import net.zaszas.booka.client.managers.BookaManagers;
import net.zaszas.booka.client.ui.BookaUI;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Booka implements EntryPoint {
    @Override
    public void onModuleLoad() {
	BookaManagers managers = new BookaManagers();
	BookaUI ui = new BookaUI();
	new BookaLogic(ui, managers);
	RootLayoutPanel.get().add(ui.getPlayground());

    }
}