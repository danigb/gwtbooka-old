package net.zaszas.booka.client.ui.explorer;

import net.zaszas.booka.client.models.DocumentInfo;
import net.zaszas.booka.client.models.DocumentList;

import com.calclab.suco.client.events.Event;
import com.calclab.suco.client.events.Listener;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ExplorerUI extends Composite {

    private static ExplorerUiBinder uiBinder = GWT.create(ExplorerUiBinder.class);

    @UiField
    FlowPanel list;

    private final Event<String> showDocumentEvent;
    
    interface ExplorerUiBinder extends UiBinder<Widget, ExplorerUI> {
    }

    public ExplorerUI() {
	initWidget(uiBinder.createAndBindUi(this));
	this.showDocumentEvent = new Event<String>("explorer.showDocument");
    }

    public void setList(DocumentList docList) {
	list.clear();
	for (DocumentInfo info : docList.get()) {
	    list.add(new ExploreDocumentUI(info, this));
	}
    }

    public void onShowDocument(Listener<String> listener) {
	showDocumentEvent.add(listener);
    }
    
    public void showDocument(String id, ExploreDocumentUI exploreDocumentUI) {
	showDocumentEvent.fire(id);
    }

}
