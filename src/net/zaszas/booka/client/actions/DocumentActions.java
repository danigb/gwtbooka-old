package net.zaszas.booka.client.actions;

import java.util.List;

import net.zaszas.booka.client.Router;
import net.zaszas.booka.client.managers.BookaManagers;
import net.zaszas.booka.client.managers.DocumentManager;
import net.zaszas.booka.client.models.Document;
import net.zaszas.booka.client.models.DocumentInfo;
import net.zaszas.booka.client.ui.BookaUI;
import net.zaszas.booka.client.ui.documenteditor.DocumentEditor;
import net.zaszas.booka.client.ui.documentexplorer.DocumentExplorer;
import net.zaszas.booka.client.ui.playground.Playground;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class DocumentActions {

    private final Playground play;
    private final DocumentEditor editor;
    private final DocumentExplorer explorer;
    private final DocumentManager manager;

    public DocumentActions(final BookaUI ui, final BookaManagers managers, Router router) {
	play = ui.getPlayground();
	explorer = ui.getDocumentExplorer();
	editor = ui.getDocumentEditor();
	manager = managers.getDocumentManager();

	router.map("^/docs$", new Action() {
	    @Override
	    public void execute(String token) {
		showDocuments(false);
	    }
	});

	router.map("^/docs/(\\d+)$", new Action() {
	    @Override
	    public void execute(String token) {
		String id = token.substring(6);
		showDocument(id);
	    }
	});
	
	router.map("^/docs/new", new Action() {
	    @Override
	    public void execute(String token) {
		newDocument();
	    }
	});
    }

    private void newDocument() {
	// FIXME
	play.setStatus("Creating new document...");
	Document doc = new Document(null, "Nuevo documento", "Descripción");
	manager.create(doc, new AsyncCallback<Document>() {
	    @Override
	    public void onSuccess(Document result) {
		showDocument(result);
		showDocuments(true);
	    }

	    @Override
	    public void onFailure(Throwable caught) {
		play.setStatus(caught.getLocalizedMessage());
	    }

	});
    }

    private void showDocument(String id) {
	showDocuments(false);
	play.setStatus("Showing document: " + id);
	manager.get(id, new AsyncCallback<Document>() {

	    @Override
	    public void onSuccess(Document doc) {
		showDocument(doc);
		showDocuments(false);
	    }

	    @Override
	    public void onFailure(Throwable caught) {
		play.setStatus(caught.getLocalizedMessage());
	    }
	});
    }

    private void showDocuments(boolean refresh) {
	if (refresh || play.getExplorer() != explorer) {
	    play.setStatus("Retrieving document list...");
	    manager.list(new AsyncCallback<List<DocumentInfo>>() {
		@Override
		public void onSuccess(List<DocumentInfo> result) {
		    play.setStatus("Document list retrieved.");
		    explorer.setList(result);
		    play.setExplorer(explorer);
		}

		@Override
		public void onFailure(Throwable caught) {
		    play.setStatus(caught.getLocalizedMessage());
		}
	    });
	}
    }

    private void showDocument(Document doc) {
	play.setStatus("Showing document" + doc.title);
	editor.setDocument(doc);
	play.setEditor(editor);
    }

}
