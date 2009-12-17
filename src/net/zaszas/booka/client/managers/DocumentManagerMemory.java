package net.zaszas.booka.client.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.zaszas.booka.client.models.Document;
import net.zaszas.booka.client.models.DocumentInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class DocumentManagerMemory implements DocumentManager {

    private final HashMap<String, Document> list;

    public DocumentManagerMemory() {
	this.list = new HashMap<String, Document>();
	Document document = new Document("1", "Sin título", "Sin descripción");
	add(document);
    }

    private void add(Document document) {
	list.put(document.id, document);
    }
    
    @Override
    public void list(AsyncCallback<List<DocumentInfo>> callback) {
	ArrayList<DocumentInfo> result = new ArrayList<DocumentInfo>();
	for (Document doc : list.values()) {
	    result.add(new DocumentInfo(doc));
	}
	callback.onSuccess(result);
    }

    @Override
    public void get(String id, AsyncCallback<Document> callback) {
	Document doc = list.get(id);
	if (doc != null) {
	    callback.onSuccess(new Document(doc));
	} else {
	    callback.onFailure(new Throwable("Not found"));
	}
    }

    @Override
    public void create(Document doc, AsyncCallback<Document> callback) {
	Document document = new Document(doc);
	document.id = "" + System.currentTimeMillis();
	add(document);
	callback.onSuccess(document);
    }

}
