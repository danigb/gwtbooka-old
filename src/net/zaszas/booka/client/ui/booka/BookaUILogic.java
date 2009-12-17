package net.zaszas.booka.client.ui.booka;

import net.zaszas.booka.client.ui.archives.ArchivesUI;

import com.calclab.suco.client.ioc.Provider;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class BookaUILogic  {

    public BookaUILogic(final BookaUI ui, final Provider<ArchivesUI> archivesProvider) {
	
	ui.setContent(archivesProvider.get());
	
	History.addValueChangeHandler(new ValueChangeHandler<String>() {
	    @Override
	    public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		ui.setStatus("Token: " + token);
		if (token.matches("^/archives")) {
		    ui.setStatus("Opening archives...");
		    ui.setContent(archivesProvider.get());
		}
	    }
	});
	
	History.fireCurrentHistoryState();
    }


}
