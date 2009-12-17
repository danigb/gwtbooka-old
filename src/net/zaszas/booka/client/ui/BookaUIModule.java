package net.zaszas.booka.client.ui;

import net.zaszas.booka.client.managers.ClipManager;
import net.zaszas.booka.client.managers.DocumentManager;
import net.zaszas.booka.client.ui.archives.ArchivesUI;
import net.zaszas.booka.client.ui.archives.ArchivesUILogic;
import net.zaszas.booka.client.ui.booka.BookaUI;
import net.zaszas.booka.client.ui.booka.BookaUILogic;
import net.zaszas.booka.client.ui.document.DocumentUI;
import net.zaszas.booka.client.ui.document.DocumentUILogic;
import net.zaszas.booka.client.ui.explorer.ExplorerUI;
import net.zaszas.booka.client.ui.explorer.ExplorerUILogic;

import com.calclab.suco.client.ioc.decorator.Singleton;
import com.calclab.suco.client.ioc.module.AbstractModule;
import com.calclab.suco.client.ioc.module.Factory;

public class BookaUIModule extends AbstractModule {

    @Override
    protected void onInstall() {
	register(Singleton.class, new Factory<BookaUI>(BookaUI.class) {
	    @Override
	    public BookaUI create() {
		return new BookaUI();
	    }

	    @Override
	    public void onAfterCreated(BookaUI ui) {
		new BookaUILogic(ui, $$(ArchivesUI.class));
	    }
	});

	register(Singleton.class, new Factory<ArchivesUI>(ArchivesUI.class) {
	    @Override
	    public ArchivesUI create() {
		return new ArchivesUI();
	    }

	    @Override
	    public void onAfterCreated(ArchivesUI ui) {
		new ArchivesUILogic(ui, $$(ExplorerUI.class), $$(DocumentUI.class));
	    }
	});
	
	register(Singleton.class, new Factory<ExplorerUI>(ExplorerUI.class) {
	    @Override
	    public ExplorerUI create() {
		return new ExplorerUI();
	    }
	    
	    @Override
	    public void onAfterCreated(ExplorerUI ui) {
		new ExplorerUILogic(ui, $(DocumentManager.class));
	    }
	    
	});
	register(Singleton.class, new Factory<DocumentUI>(DocumentUI.class) {
	    @Override
	    public DocumentUI create() {
		return new DocumentUI();
	    }
	    
	    @Override
	    public void onAfterCreated(DocumentUI ui) {
		new DocumentUILogic(ui, $(DocumentManager.class), $(ClipManager.class));
	    }
	    
	});
    }
}
