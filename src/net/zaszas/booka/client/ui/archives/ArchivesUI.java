package net.zaszas.booka.client.ui.archives;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ArchivesUI extends Composite {

    private static ArchivesUIUiBinder uiBinder = GWT.create(ArchivesUIUiBinder.class);

    interface ArchivesUIUiBinder extends UiBinder<Widget, ArchivesUI> {
    }
    
    @UiField
    DockLayoutPanel self;
    
    @UiField
    SimplePanel explorer, tools, content;
    

    public ArchivesUI() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    public void setContent(Widget widget) {
	content.clear();
	content.setWidget(widget);
    }

    public void setExplorer(Widget widget) {
	explorer.clear();
	explorer.setWidget(widget);
	self.forceLayout();
    }

}
