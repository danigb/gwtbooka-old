package net.zaszas.booka.client.ui.clip;

import net.zaszas.booka.client.models.Clip;
import net.zaszas.booka.client.ui.clip.ClipUI.ClipUIListener;
import net.zaszas.booka.client.ui.clip.EditorPanel.EditorPanelListener;

public class ClipUILogic implements EditorPanelListener {
    private final Clip clip;
    private final ClipUI ui;
    private boolean isLocked;
    private final ClipUIListener listener;

    public ClipUILogic(final Clip clip, final ClipUI ui, final ClipUIListener listener) {
	this.clip = clip;
	this.ui = ui;
	this.listener = listener;
	ui.setClipEditor(null);
	ui.setContentControlsVisible(false);
	setLocked(false);
    }
    
    public void onEditContent() {
	setLocked(false);
	ui.setContentVisible(false);
	setEditor(clip.type);
    }

    @Override
    public void onSaveEditor(ClipEditor editor) {
	ui.setClipEditor(null);
	ui.setContent(editor.getResultAsHTML());
	editor.setDataTo(clip);
	listener.editorSaved(clip, ui);
    }

    @Override
    public void onCancelEditor(ClipEditor editor) {
	ui.setClipEditor(null);
	ui.setContentVisible(true);
	listener.editorCancelled(clip, ui);
    }    

    void setEditor(String type) {
	ClipEditor editor = ClipEditorFactory.getInstance().create(type);
	editor.getDataFrom(clip);
	EditorPanel editorPanel = new EditorPanel(editor, this);
	ui.setClipEditor(editorPanel);
    }

    public void onOverContent() {
	ui.setActive(true);
    }

    public void onOutContent() {
	if (!isLocked) {
	    ui.setActive(false);
	}
    }

    public void onContentClicked() {
	setLocked(!isLocked);
    }

    private void setLocked(boolean locked) {
	isLocked = locked;
	ui.setContentControlsVisible(isLocked);
	ui.setActive(isLocked);
    }


}
