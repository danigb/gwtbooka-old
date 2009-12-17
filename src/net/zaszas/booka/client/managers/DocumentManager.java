package net.zaszas.booka.client.managers;

import java.util.List;

import net.zaszas.booka.client.models.Document;
import net.zaszas.booka.client.models.DocumentInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DocumentManager {

    void list(AsyncCallback<List<DocumentInfo>> callback);

    void get(String id, AsyncCallback<Document> callback);

    void create(Document doc, AsyncCallback<Document> callback);

}
