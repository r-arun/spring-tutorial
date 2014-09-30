package come.home.learning.view.model.constants;

public enum ViewModelAttributes {
	QUESTION("question", "paragraph", "learning-question", null),
	OPTION("option", "option-field", "learning-option", "answer");
	
	private final String id;
	private final String type;
	private final String cssClass;
	private final String name;
	
	ViewModelAttributes(final String id, final String type, final String cssClass,
			final String name) {
		this.id = id;
		this.type = type;
		this.cssClass = cssClass;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getCssClass() {
		return cssClass;
	}

	public String getName() {
		return name;
	}
}
