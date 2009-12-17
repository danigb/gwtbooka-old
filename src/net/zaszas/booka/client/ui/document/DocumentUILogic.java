package net.zaszas.booka.client.ui.document;

import net.zaszas.booka.client.managers.ClipManager;
import net.zaszas.booka.client.managers.DocumentManager;
import net.zaszas.booka.client.models.Clip;
import net.zaszas.booka.client.models.Document;
import net.zaszas.booka.client.ui.clip.ClipUI;

import com.calclab.suco.client.events.Listener;
import com.calclab.suco.client.events.Listener2;

public class DocumentUILogic {

    public DocumentUILogic(final DocumentUI ui, DocumentManager docs, ClipManager clips) {

	ui.onClipEditCancelled(new Listener2<Clip, ClipUI>() {
	    @Override
	    public void onEvent(Clip clip, ClipUI clipUI) {
		if (clip.id == null) {
		    ui.removeClip(clipUI);
		}
	    }
	});

	ui.onClipEditSaved(new Listener2<Clip, ClipUI>() {
	    @Override
	    public void onEvent(Clip clip, ClipUI clipUI) {
		if (clip.id == null) {
		    ui.addSlotFor(clipUI);
		} else {

		}
	    }
	});

	ui.onNewClip(new Listener2<String, ClipUI>() {
	    @Override
	    public void onEvent(String type, ClipUI clipAfter) {
		if (type != null) {
		    ClipUI clipUI = ui.createNewClipUI(new Clip(type));
		    clipUI.setEditor(type);
		    ui.addClipBefore(clipUI, clipAfter);
		}

	    }
	});

	docs.onDocumentRetrieved(new Listener<Document>() {
	    @Override
	    public void onEvent(Document doc) {
		ui.setDocument(doc);
		ui.setVisible(true);
	    }
	});
    }

}
