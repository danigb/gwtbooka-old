package net.zaszas.booka.client.ui.clip;

import net.zaszas.booka.client.models.Clip;
import net.zaszas.booka.client.ui.clip.EditorPanel.EditorPanelListener;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class ClipUI extends Composite implements EditorPanelListener {

    private static ClipUIUiBinder uiBinder = GWT.create(ClipUIUiBinder.class);
    private final Clip clip;

    public static interface ClipUIListener {
	
    }
    
    @UiField
    FlowPanel editorPanel;
    
    @UiField
    HTML contentPanel;
    private final ClipUIListener listener;

    interface ClipUIUiBinder extends UiBinder<Widget, ClipUI> {
    }

    public ClipUI(Clip clip, ClipUIListener listener) {
	this.clip = clip;
	this.listener = listener;
	initWidget(uiBinder.createAndBindUi(this));
	editorPanel.setVisible(false);
    }

    public void setEditor(String type) {
	contentPanel.setVisible(false);
	ClipEditor editor = ClipEditorFactory.getInstance().create(type);
	editor.getDataFrom(clip);
	editorPanel.clear();
	editorPanel.add(new EditorPanel(editor, this));
	editorPanel.setVisible(true);
    }

    @Override
    public void onCancelEditor(ClipEditor editor) {
	editorPanel.clear();
	editorPanel.setVisible(false);
	contentPanel.setVisible(true);
    }

    @Override
    public void onSaveEditor(ClipEditor editor) {
	contentPanel.setHTML(editor.getResultAsHTML());
	editor.setDataTo(clip);
	editorPanel.clear();
	contentPanel.setVisible(true);
    }

}
