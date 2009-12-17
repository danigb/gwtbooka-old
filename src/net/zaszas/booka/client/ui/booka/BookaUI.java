package net.zaszas.booka.client.ui.booka;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class BookaUI extends Composite {

    private static BookaUIUiBinder uiBinder = GWT.create(BookaUIUiBinder.class);

    interface BookaUIUiBinder extends UiBinder<Widget, BookaUI> {
    }
    
//    @UiField
//    SimplePanel content;

    @UiField
    DockLayoutPanel self;
    
    @UiField
    Label status;

    private Widget center;

    public BookaUI() {
	initWidget(uiBinder.createAndBindUi(this));
	this.center = null;
    }

    public void setContent(Widget component) {
	if (component != this.center) {
	    if (center != null) {
		self.remove(center);
	    }
	    self.add(component);
	    this.center = component;
	}
    }
    
    public void setStatus(String body) {
	GWT.log(body, null);
	status.setText(body);
    }

}
