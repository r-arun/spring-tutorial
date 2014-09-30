package come.home.learning.view.model;

import java.util.Map;

public class OptionViewModel extends BasicViewModel {
	private final String name;
	private final Boolean multipleChoice;
	private final Boolean multipleAnswer;
	private final Map<String, String> valueDescriptionMap;

	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param cssClass
	 * @param description
	 * @param multipleChoice
	 * @param multipleAnswer
	 * @param valueDescriptionMap
	 */
	public OptionViewModel(final String id,  final String type,
			final String cssClass, final String name, final Boolean multipleChoice,
			final Boolean multipleAnswer, final Map <String, String> valueDescriptionMap) {
		super(id, type, cssClass);
		this.name = name;
		this.multipleChoice = multipleChoice;
		this.multipleAnswer = multipleAnswer;
		this.valueDescriptionMap = valueDescriptionMap;
	}
	
	public String getName() {
		return name;
	}

	public Boolean getMultipleChoice() {
		return multipleChoice;
	}

	public Boolean getMultipleAnswer() {
		return multipleAnswer;
	}

	public Map<String, String> getValueDescriptionMap() {
		return valueDescriptionMap;
	}
	
	
}
