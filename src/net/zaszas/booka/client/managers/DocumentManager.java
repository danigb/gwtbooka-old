package net.zaszas.booka.client.managers;

import java.util.List;

import net.zaszas.booka.client.models.Document;
import net.zaszas.booka.client.models.DocumentInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DocumentManager {

    void getList(AsyncCallback<List<DocumentInfo>> callback);

    void getDocument(String id, AsyncCallback<Document> callback);

}
