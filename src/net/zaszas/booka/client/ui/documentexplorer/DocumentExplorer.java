package net.zaszas.booka.client.ui.documentexplorer;

import java.util.List;

import net.zaszas.booka.client.models.DocumentInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class DocumentExplorer extends Composite {

    private static DocumentExplorerUiBinder uiBinder = GWT.create(DocumentExplorerUiBinder.class);

    @UiField
    FlowPanel list;
    
    interface DocumentExplorerUiBinder extends UiBinder<Widget, DocumentExplorer> {
    }

    public DocumentExplorer() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    public void setList(List<DocumentInfo> infoList) {
	list.clear();
	for (DocumentInfo info : infoList) {
	    list.add(new DocumentInfoUI(info));
	}
    }

}
