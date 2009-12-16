package net.zaszas.booka.client.managers;

public class BookaManagers {

    private DocumentManagerMemory documentManager;

    public DocumentManager getDocumentManager() {
	if (documentManager == null) {
	    this.documentManager = new DocumentManagerMemory();
	}
	return documentManager;
    }

}
