package net.zaszas.booka.client.ui.clip;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class EditorPanel extends Composite {

    private static EditorPanelUiBinder uiBinder = GWT.create(EditorPanelUiBinder.class);

    interface EditorPanelUiBinder extends UiBinder<Widget, EditorPanel> {
    }

    public static interface EditorPanelListener {
	void onSaveEditor(ClipEditor editor);
	void onCancelEditor(ClipEditor editor);
    }
    
    @UiField
    FlowPanel self;
    
    @UiField
    Label save, cancel;
    
    private final EditorPanelListener listener;

    private final ClipEditor editor;
    
    public EditorPanel(ClipEditor editor, EditorPanelListener listener) {
	this.editor = editor;
	this.listener = listener;
	initWidget(uiBinder.createAndBindUi(this));
	self.insert((Widget) editor, 0);
    }
    
    @UiHandler("save")
    public void onSave(ClickEvent e) {
	listener.onSaveEditor(editor);
    }
    
    @UiHandler("cancel")
    public void onCancel(ClickEvent e) {
	listener.onCancelEditor(editor);
    }

}
