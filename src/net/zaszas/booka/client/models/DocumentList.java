package net.zaszas.booka.client.models;

import java.util.ArrayList;

public class DocumentList {
    private final ArrayList<DocumentInfo> list;

    public DocumentList() {
	this.list = new ArrayList<DocumentInfo>();
    }
    
    public void add(DocumentInfo document) {
	list.add(document);
    }

    public ArrayList<DocumentInfo> get() {
	return list;
    }

}
