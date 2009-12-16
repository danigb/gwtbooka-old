package net.zaszas.booka.client.ui;

import net.zaszas.booka.client.ui.documenteditor.DocumentEditor;
import net.zaszas.booka.client.ui.documentexplorer.DocumentExplorer;
import net.zaszas.booka.client.ui.playground.Playground;

public class BookaUI {
    private final Playground playground;
    private DocumentExplorer documentExplorer;
    private DocumentEditor documentEditor;

    public BookaUI() {
	this.playground = new Playground();
    }

    public Playground getPlayground() {
	return this.playground;
    }

    public DocumentExplorer getDocumentExplorer() {
	if (documentExplorer == null) 
	    this.documentExplorer = new DocumentExplorer();
	return documentExplorer;
    }

    public DocumentEditor getDocumentEditor() {
	if (documentEditor == null)
	    this.documentEditor = new DocumentEditor();
	return documentEditor;
    }

}
