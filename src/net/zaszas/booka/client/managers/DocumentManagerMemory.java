package net.zaszas.booka.client.managers;

import java.util.HashMap;

import net.zaszas.booka.client.models.Document;
import net.zaszas.booka.client.models.DocumentInfo;
import net.zaszas.booka.client.models.DocumentList;

import com.calclab.suco.client.events.Event;
import com.calclab.suco.client.events.Listener;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class DocumentManagerMemory implements DocumentManager {
    private final HashMap<String, Document> list;
    private final Event<DocumentList> documentListEvent;
    private final Event<Document> documentEvent;

    public DocumentManagerMemory() {
	this.list = new HashMap<String, Document>();
	this.documentListEvent = new Event<DocumentList>("documents.list");
	this.documentEvent = new Event<Document>("documents.document");
	
	add(new Document("1", "Sin título", "Sin descripción"));
    }

    private void add(Document document) {
	list.put(document.id, document);
    }
    

    @Override
    public void getDocument(String id) {
	Document doc = list.get(id);
	if (doc != null) {
	    documentEvent.fire(new Document(doc));
	} else {
	}
    }
    
    @Override
    public void onDocumentRetrieved(Listener<Document> listener) {
	documentEvent.add(listener);
    }

    public void create(Document doc, AsyncCallback<Document> callback) {
	Document document = new Document(doc);
	document.id = "" + System.currentTimeMillis();
	add(document);
	callback.onSuccess(document);
    }

    @Override
    public void getList() {
	DocumentList list = new DocumentList();
	for (Document doc : this.list.values()) {
	    list.add(new DocumentInfo(doc));
	}
	documentListEvent.fire(list);
    }

    @Override
    public void onListRetrieved(Listener<DocumentList> listener) {
	documentListEvent.add(listener);
    }

}
