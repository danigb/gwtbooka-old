package net.zaszas.booka.client;

import net.zaszas.booka.client.actions.DocumentActions;
import net.zaszas.booka.client.managers.BookaManagers;
import net.zaszas.booka.client.ui.BookaUI;

import com.google.gwt.core.client.GWT;


public class BookaLogic {


    public BookaLogic(BookaUI ui, BookaManagers managers) {
	GWT.log("Enabling actions...", null);
	Router router = new Router();
	new DocumentActions(ui, managers, router);
	router.start();
    }



}
