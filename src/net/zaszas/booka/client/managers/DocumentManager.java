package net.zaszas.booka.client.managers;

import net.zaszas.booka.client.models.Document;
import net.zaszas.booka.client.models.DocumentList;

import com.calclab.suco.client.events.Listener;



public interface DocumentManager {
    void getList();

    void onListRetrieved(Listener<DocumentList> listener);

    void getDocument(String id);
    
    void onDocumentRetrieved(Listener<Document> listener);
}
