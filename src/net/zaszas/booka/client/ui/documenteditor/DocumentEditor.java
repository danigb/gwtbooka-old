package net.zaszas.booka.client.ui.documenteditor;

import net.zaszas.booka.client.models.Document;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DocumentEditor extends Composite {

    private static DocumentEditorUiBinder uiBinder = GWT.create(DocumentEditorUiBinder.class);

    interface DocumentEditorUiBinder extends UiBinder<Widget, DocumentEditor> {
    }

    public DocumentEditor() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    public void setDocument(Document doc) {
	
    }

}
