package come.home.learning.view.model;

public class QuestionViewModel extends BasicViewModel {
	private final String description;

	/**
	 * @param id
	 * @param type
	 * @param cssClass
	 * @param description
	 */
	public QuestionViewModel(final String id, final String type,
			final String cssClass, final String description) {
		super(id, type, cssClass);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
