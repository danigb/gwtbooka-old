package net.zaszas.booka.client.ui.archives;

import net.zaszas.booka.client.ui.document.DocumentUI;
import net.zaszas.booka.client.ui.explorer.ExplorerUI;

import com.calclab.suco.client.ioc.Provider;

public class ArchivesUILogic {

    public ArchivesUILogic(ArchivesUI ui, Provider<ExplorerUI> explorerProvider, Provider<DocumentUI> documentProvider) {
	ui.setExplorer(explorerProvider.get());
	DocumentUI document = documentProvider.get();
	document.setVisible(false);
	ui.setContent(document);
    }
}
