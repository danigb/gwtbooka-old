package net.zaszas.booka.client.ui.explorer;

import net.zaszas.booka.client.models.DocumentInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

class ExploreDocumentUI extends Composite {

    private static DocumentInfoUIUiBinder uiBinder = GWT.create(DocumentInfoUIUiBinder.class);

    @UiField
    Label title;
    
    @UiField
    SpanElement description, extra;

    private final ExplorerUI explorerUI;

    private final String id;
    
    interface DocumentInfoUIUiBinder extends UiBinder<Widget, ExploreDocumentUI> {
    }

    public ExploreDocumentUI(DocumentInfo info, ExplorerUI explorerUI) {
	this.explorerUI = explorerUI;
	this.id = info.id;
	initWidget(uiBinder.createAndBindUi(this));
	title.setText(info.title);
	description.setInnerText(info.description);
	extra.setInnerText("Este es el id: " + info.id);
    }
    
    @UiHandler("title")
    public void onShow(ClickEvent event) {
	GWT.log("Document clicked " + id, null);
	explorerUI.showDocument(id, this);
    }

}
