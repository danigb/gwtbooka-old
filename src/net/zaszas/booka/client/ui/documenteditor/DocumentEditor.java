package net.zaszas.booka.client.ui.documenteditor;

import net.zaszas.booka.client.models.Clip;
import net.zaszas.booka.client.models.Document;
import net.zaszas.booka.client.ui.clip.ClipUI;
import net.zaszas.booka.client.ui.clip.ClipUI.ClipUIListener;
import net.zaszas.booka.client.ui.documenteditor.Slot.SlotListener;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DocumentEditor extends Composite implements SlotListener, ClipUIListener {

    private static DocumentEditorUiBinder uiBinder = GWT.create(DocumentEditorUiBinder.class);

    interface DocumentEditorUiBinder extends UiBinder<Widget, DocumentEditor> {
    }

    @UiField
    Label title, description;
    
    @UiField
    FlowPanel content;
    
    public DocumentEditor() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    public void setDocument(Document doc) {
	title.setText(doc.title);
	description.setText(doc.description);
	content.clear();
	addSlot();
    }

    private void addSlot() {
	Slot slot = new Slot(null, this);
	content.add(slot);
    }

    @Override
    public void onAddClip(Slot slot, String position, String type) {
	if (type != null) {
	    ClipUI clip = new ClipUI(new Clip(), this);
	    clip.setEditor(type);
	    if (position == null) {
		content.add(clip);
	    }
	}
    }
    
    public void onClipEditCancelled(ClipUI ui, Clip clip) {
	
    }
    
    public void onClipEditSaved(ClipUI ui, Clip clip) {
	
    }

}
