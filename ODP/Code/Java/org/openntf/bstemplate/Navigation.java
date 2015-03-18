package org.openntf.bstemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Navigation implements Serializable {

	private static final long serialVersionUID = 8031965383531253276L;
	private final List<Page> navigation;

	public Navigation() {
		this.navigation = new ArrayList<Page>();
		this.navigation.add(new Page("Samples", "samples.xsp", "fa fa-code", false));
		this.navigation.add(new Page("Bootstrap CKE", "bscke.xsp", "fa fa-edit", false));
		this.navigation.add(new Page("Tabs", "tabs.xsp", "glyphicon glyphicon-th-large", false));
		this.navigation.add(new Page("AppConfig", "valuelists.xsp", "fa fa-list", false));
		this.navigation.add(new Page("FontAwesome", "fontawesome.xsp", "fa fa-send", false));
		this.navigation.add(new Page("GitHub API", "github.xsp", "fa fa-github", false));
		// this.navigation.add(new Page("Markdown", "pagedown.xsp",
		// "fa fa-code", false));
	}

	public List<Page> getNavigation() {
		return navigation;
	}
}
