package come.home.learning.view.model;

public class BasicViewModel {
	private final String id;
	private final String type;
	private final String cssClass;
	
	/**
	 * @param id id of the html text element
	 * @param type type of html element
	 * @param cssClass class of the element
	 */
	public BasicViewModel(final String id, final String type,
			final String cssClass) {
		super();
		this.id = id;
		this.type = type;
		this.cssClass = cssClass;
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

}
