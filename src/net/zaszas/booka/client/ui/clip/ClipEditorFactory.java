package net.zaszas.booka.client.ui.clip;


public class ClipEditorFactory {

    private static ClipEditorFactory instance;

    private ClipEditorFactory() {
    }
    
    
    public static ClipEditorFactory getInstance() {
	if (instance == null) {
	    instance = new ClipEditorFactory();
	}
	return instance;
    }


    public ClipEditor create(String type) {
	if ("text".equals(type)) {
	    return new ClipEditorText();
	} else {
	    return null;
	}
	
    }
}
