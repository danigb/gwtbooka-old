package net.zaszas.booka.client.ui.clip;

import net.zaszas.booka.client.models.Clip;

public interface ClipEditor {
    public abstract void getDataFrom(Clip clip);

    public abstract String getResultAsHTML();

    public abstract void setDataTo(Clip clip);

}
