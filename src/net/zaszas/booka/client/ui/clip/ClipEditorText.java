package net.zaszas.booka.client.ui.clip;

import net.zaszas.booka.client.models.Clip;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class ClipEditorText extends Composite implements ClipEditor {
    private static final String MIME_TYPE = "text";
    
    private static ClipEditorTextUiBinder uiBinder = GWT.create(ClipEditorTextUiBinder.class);

    interface ClipEditorTextUiBinder extends UiBinder<Widget, ClipEditorText> {
    }

    @UiField
    TextArea area;
    
    public ClipEditorText() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void getDataFrom(Clip clip) {
	area.setText(clip.body);
    }

    @Override
    public String getResultAsHTML() {
	return area.getText();
    }

    @Override
    public void setDataTo(Clip clip) {
	clip.body = area.getText();
	clip.type = ClipEditorText.MIME_TYPE;
    }

}
