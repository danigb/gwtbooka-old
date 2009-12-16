package net.zaszas.booka.client.models;

public class DocumentInfo {
    public  String description;
    public  String title;
    public  String id;

    public DocumentInfo(String id, String title, String description) {
	this.id = id;
	this.title = title;
	this.description = description;
    }

    public DocumentInfo(DocumentInfo info) {
	this.id = info.id;
	this.title = info.title;
	this.description = info.description;
    }

}
