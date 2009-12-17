package net.zaszas.booka.client.ui.document;

import com.calclab.suco.client.events.Listener;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ContentSelector extends Composite implements ClickHandler {

    private static ContentSelectorUiBinder uiBinder = GWT.create(ContentSelectorUiBinder.class);

    interface ContentSelectorUiBinder extends UiBinder<Widget, ContentSelector> {
    }

    @UiField
    Label close;
    Label text, video;

    @UiField
    FlowPanel selectors;
    private Listener<String> currentListener;

    public ContentSelector() {
	initWidget(uiBinder.createAndBindUi(this));
	currentListener = null;
    }

    // FIXME: cuidado, sólo uno
    public void onContentSelected(Listener<String> listener) {
	this.currentListener = listener;
    }

    @UiHandler("close")
    public void onClose(ClickEvent e) {
	selected(e, null);
    }

    private void selected(ClickEvent e, String selected) {
	e.stopPropagation();
	if (currentListener != null) {
	    currentListener.onEvent(selected);
	    currentListener = null;
	}
    }

    @UiHandler("text")
    public void addText(ClickEvent e) {
	selected(e, "text");
    }

    @UiHandler("video")
    public void addVideo(ClickEvent e) {
	selected(e, "video");
    }

    @Override
    public void onClick(ClickEvent event) {
	Window.alert("" + event.getSource());
    }

}
