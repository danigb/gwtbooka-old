package net.zaszas.booka.client.ui.document;

import net.zaszas.booka.client.models.Clip;
import net.zaszas.booka.client.models.Document;
import net.zaszas.booka.client.ui.clip.ClipUI;
import net.zaszas.booka.client.ui.clip.ClipUI.ClipUIListener;
import net.zaszas.booka.client.ui.document.Slot.SlotListener;

import com.calclab.suco.client.events.Event2;
import com.calclab.suco.client.events.Listener2;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DocumentUI extends Composite {

    private static DocumentEditorUiBinder uiBinder = GWT.create(DocumentEditorUiBinder.class);

    interface DocumentEditorUiBinder extends UiBinder<Widget, DocumentUI> {
    }

    @UiField
    Label title, description;

    @UiField
    FlowPanel content;

    private final Event2<Clip, ClipUI> clipSave;
    private final Event2<Clip, ClipUI> clipSaveCancel;
    private final SlotListener slotListener;
    private final Event2<String, ClipUI> newClip;

    private final ClipUIListener clipUIListener;

    private Slot lastSlot;

    public DocumentUI() {
	initWidget(uiBinder.createAndBindUi(this));
	this.clipSave = new Event2<Clip, ClipUI>("ui.document.clipCreate");
	this.clipSaveCancel = new Event2<Clip, ClipUI>("ui.document.clipUpdate");
	this.newClip = new Event2<String, ClipUI>("ui.document.newClip");

	clipUIListener = new ClipUIListener() {
	    @Override
	    public void editorCancelled(Clip clip, ClipUI clipUI) {
		clipSaveCancel.fire(clip, clipUI);
	    }

	    @Override
	    public void editorSaved(Clip clip, ClipUI clipUI) {
		clipSave.fire(clip, clipUI);
	    }
	};

	this.slotListener = new SlotListener() {
	    @Override
	    public void onAddClip(Slot slot, ClipUI clipUI, String type) {
		newClip.fire(type, clipUI);
	    }
	};
    }

    public void setDocument(Document doc) {
	title.setText(doc.title);
	description.setText(doc.description);
	content.clear();
	lastSlot = new Slot(null, slotListener);
	content.add(lastSlot);
    }

    public void onClipEditCancelled(Listener2<Clip, ClipUI> listener) {
	clipSaveCancel.add(listener);
    }

    public void onClipEditSaved(Listener2<Clip, ClipUI> listener) {
	clipSave.add(listener);
    }

    public void removeClip(ClipUI clipUI) {
	content.remove(clipUI);
    }

    public void addSlotFor(ClipUI clipUI) {
	int index = content.getWidgetIndex(clipUI);
	content.insert(new Slot(clipUI, slotListener), index);
    }

    public void onNewClip(Listener2<String, ClipUI> listener) {
	newClip.add(listener);
    }

    public ClipUI createNewClipUI(Clip clip) {
	return new ClipUI(clip, clipUIListener);
    }

    public void addClipBefore(ClipUI newClip, ClipUI clipAfter) {
	int index = content.getWidgetIndex((clipAfter != null) ? clipAfter : lastSlot);
	content.insert(newClip, index);
    }

}
