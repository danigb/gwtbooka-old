package net.zaszas.booka.client.models;

public class Document extends DocumentInfo {

    public Document(String id, String title, String description) {
	super(id, title, description);
    }

    public Document(Document doc) {
	super(doc);
    }

}
