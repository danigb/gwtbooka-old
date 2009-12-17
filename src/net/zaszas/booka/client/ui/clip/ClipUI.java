package net.zaszas.booka.client.ui.clip;

import net.zaszas.booka.client.models.Clip;

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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class ClipUI extends Composite {

    private static ClipUIUiBinder uiBinder = GWT.create(ClipUIUiBinder.class);

    interface Styles extends CssResource {
	String active();
    }

    public static interface ClipUIListener {

	void editorCancelled(Clip clip, ClipUI clipUI);

	void editorSaved(Clip clip, ClipUI clipUI);
    }

    @UiField
    FlowPanel editorPanel, contentControls;
    @UiField
    HTML contentBody;
    @UiField
    FocusPanel contentPanel;
    @UiField
    Styles style;

    private final ClipUILogic logic;

    interface ClipUIUiBinder extends UiBinder<Widget, ClipUI> {
    }

    public ClipUI(Clip clip, ClipUIListener listener) {
	initWidget(uiBinder.createAndBindUi(this));
	logic = new ClipUILogic(clip, this, listener);
    }

    public void setEditor(String type) {
	logic.setEditor(type);
    }

    void setClipEditor(EditorPanel editor) {
	editorPanel.clear();
	editorPanel.setVisible(false);
	if (editor != null) {
	    editorPanel.add(editor);
	    editorPanel.setVisible(true);
	}
    }

    public void setContent(String html) {
	contentBody.setHTML(html);
	setContentVisible(true);
    }

    void setContentVisible(boolean visible) {
	contentBody.setVisible(visible);
    }

    @UiHandler("contentPanel")
    public void onContentPanelOver(MouseOverEvent e) {
	logic.onOverContent();
    }

    @UiHandler("contentPanel")
    public void onContentPanelOut(MouseOutEvent e) {
	logic.onOutContent();
    }
    
    @UiHandler("contentPanel")
    public void onContentClick(ClickEvent e) {
	logic.onContentClicked();
    }
    
    @UiHandler("edit") 
    public void onContentEdit(ClickEvent e) {
	logic.onEditContent();
    }

    public void setContentControlsVisible(boolean visible) {
	contentControls.setVisible(visible);
    }

    public void setActive(boolean active) {
	if (active) {
	    contentPanel.getElement().addClassName(style.active());
	} else {
	    contentPanel.getElement().removeClassName(style.active());
	}
    }

}
