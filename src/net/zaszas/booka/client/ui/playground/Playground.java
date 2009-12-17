package net.zaszas.booka.client.ui.playground;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class Playground extends Composite {

    private static PlaygroundUiBinder uiBinder = GWT.create(PlaygroundUiBinder.class);

    interface PlaygroundUiBinder extends UiBinder<Widget, Playground> {
    }

    @UiField
    Label status;
    @UiField
    LayoutPanel explorer, content, tools;

    public Playground() {
	initWidget(uiBinder.createAndBindUi(this));
	new PlaygroundLogic(this);
    }

    public void setExplorer(Widget widget) {
	explorer.clear();
	explorer.add(widget);
    }

    public void setStatus(String body) {
	status.setText(body);
    }

    public void setEditor(Widget editor) {
	content.clear();
	content.add(editor);
    }
    
    public Widget getEditor() {
	return content.getWidgetCount() > 0 ? content.getWidget(0) : null;
    }

    public Widget getExplorer() {
	return explorer.getWidgetCount() > 0 ? explorer.getWidget(0) : null;
    }

}
