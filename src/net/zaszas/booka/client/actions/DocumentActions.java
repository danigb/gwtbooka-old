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

	router.map("^archives$", new Action() {
	    @Override
	    public void execute(String token) {
		showArchives();
	    }
	});

	router.map("^docs/(\\d+)$", new Action() {
	    @Override
	    public void execute(String token) {
		String id = token.substring(5);
		showDocument(id);
	    }
	});
    }

    private void showDocument(String id) {
	play.setStatus("Showing document: " + id);
	manager.getDocument(id, new AsyncCallback<Document>() {
	    
	    @Override
	    public void onSuccess(Document doc) {
		play.setStatus("Showing document" + doc.title);
		editor.setDocument(doc);
		play.setEditor(editor);
	    }
	    
	    @Override
	    public void onFailure(Throwable caught) {
		
	    }
	});
    }

    private void showArchives() {

	play.setStatus("Retrieving document list...");
	manager.getList(new AsyncCallback<List<DocumentInfo>>() {
	    @Override
	    public void onSuccess(List<DocumentInfo> result) {
		play.setStatus("Document list retrieved.");
		explorer.setList(result);
		play.setExplorer(explorer);
	    }

	    @Override
	    public void onFailure(Throwable caught) {
	    }
	});
    }


}
