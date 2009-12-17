package net.zaszas.booka.client.ui.documenteditor;

import com.calclab.suco.client.events.Listener;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

public class Slot extends Composite {

    private static SlotUiBinder uiBinder = GWT.create(SlotUiBinder.class);

    interface Styles extends CssResource {
	String active();
    }

    interface SlotUiBinder extends UiBinder<Widget, Slot> {
    }
    
    public static interface SlotListener {
	public void onAddClip(Slot slot, String position, String type);
    }

    @UiField
    Styles style;

    @UiField
    FlowPanel self;
    @UiField
    FocusPanel slot;

    private final String position;

    private final SlotListener listener;

    public Slot(String position, SlotListener listener) {
	this.position = position;
	this.listener = listener;
	initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("slot")
    public void slotClick(ClickEvent event) {
	if (slot.getWidget() == null) {
	    final ContentSelector selector = new ContentSelector();
	    selector.onContentSelected(new Listener<String>() {
		@Override
		public void onEvent(String type) {
		    slot.remove(selector);
		    listener.onAddClip(Slot.this, position, type);
		}
	    });
	    slot.add(selector);
	}
    }

    @UiHandler("slot")
    public void slotOut(MouseOutEvent event) {
	slot.getElement().removeClassName(style.active());
    }

    @UiHandler("slot")
    public void slotOver(MouseOverEvent event) {
	slot.getElement().addClassName(style.active());
    }

}
