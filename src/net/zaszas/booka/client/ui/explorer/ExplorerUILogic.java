package net.zaszas.booka.client.ui.explorer;

import net.zaszas.booka.client.managers.DocumentManager;
import net.zaszas.booka.client.models.DocumentList;

import com.calclab.suco.client.events.Listener;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class ExplorerUILogic {

    private final DocumentManager manager;
    private String currentArchive;
    private String currentDocument;

    public ExplorerUILogic(final ExplorerUI ui, final DocumentManager manager) {
	this.manager = manager;

	ui.onShowDocument(new Listener<String>() {
	    @Override
	    public void onEvent(String id) {
		String token = History.getToken();
		String[] items = token.split("/");
		// items[0] == '' > true always
		if (items.length >= 3 && items.length <= 5) {
		    token = "/" + items[1] + '/' + items[2] + "/docs/" + id;
		    History.newItem(token);
		} else if (items.length == 6) {
		    GWT.log("Big path", null);
		} else {
		    GWT.log("Unrecognized path", null);
		}
	    }
	});

	manager.onListRetrieved(new Listener<DocumentList>() {
	    @Override
	    public void onEvent(DocumentList list) {
		GWT.log("Setting document list...", null);
		ui.setList(list);
	    }
	});

	History.addValueChangeHandler(new ValueChangeHandler<String>() {
	    @Override
	    public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		
		if (token.matches("^/archives$")) {
		    ui.setVisible(true);
		    History.newItem("/archives/all");
		}
		
		if (token.matches("^/archives/all.*")) {
		    getArchives(token);
		}
		
		if (token.matches(".*/docs/.*")) {
		    openDocument(token);
		}
	    }

	});
    }

    private void getArchives(String token) {
	String value = token.substring("/archives/".length());
	if (currentArchive != value) {
	    this.currentArchive = value;
	    manager.getList();
	}
    }

    private void openDocument(String token) {
	int index = token.indexOf("/docs/") + "/docs/".length();
	String documentId = token.substring(index);
	if (currentDocument != documentId) {
	    this.currentDocument = documentId;
	    manager.getDocument(documentId);
	}
    }
}
