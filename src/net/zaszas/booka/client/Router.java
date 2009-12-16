package net.zaszas.booka.client;

import java.util.HashMap;

import net.zaszas.booka.client.actions.Action;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class Router implements ValueChangeHandler<String> {
    private final HashMap<String, Action> routes;

    public Router() {
	this.routes = new HashMap<String, Action>();
	History.addValueChangeHandler(this);
	start();
    }

    public void start() {
	String initToken = History.getToken();

	if (initToken.length() == 0) {
	    History.newItem("archives");
	}
	History.fireCurrentHistoryState();
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
	String token = event.getValue();
	GWT.log("Token: " + token, null);
	for (String key : routes.keySet()) {
	    GWT.log("Key: " + key, null);
	    if (token.matches(key)) {
		GWT.log("Token matches!", null);
		routes.get(key).execute(token);
	    }
	}
    }

    public void map(String route, Action action) {
	routes.put(route, action);
    }
}
