package net.zaszas.booka.client.ui.documentexplorer;

import net.zaszas.booka.client.models.DocumentInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;

public class DocumentInfoUI extends Composite {

    private static DocumentInfoUIUiBinder uiBinder = GWT.create(DocumentInfoUIUiBinder.class);

    @UiField
    Hyperlink title;
    
    @UiField
    SpanElement description, extra;
    
    interface DocumentInfoUIUiBinder extends UiBinder<Widget, DocumentInfoUI> {
    }

    public DocumentInfoUI(DocumentInfo info) {
	initWidget(uiBinder.createAndBindUi(this));
	title.setText(info.title);
	title.setTargetHistoryToken("/docs/" + info.id);
	description.setInnerText(info.description);
	extra.setInnerText("Este es el id: " + info.id);
    }

}
