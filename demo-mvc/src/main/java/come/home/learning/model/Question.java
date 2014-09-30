package come.home.learning.model;

import java.util.List;

public class Question {
	private final String text;
	private final boolean multipleChoice;
	private final boolean multipleAnswer;
	private final boolean answerRequired;
	private final List<String> options;

	public Question(final String text, final boolean multipleChoice,
			final boolean multipleAnswer , final boolean answerRequired,
			final List<String> options) {
		this.text = text;
		this.multipleChoice = multipleChoice;
		this.multipleAnswer = multipleAnswer;
		this.answerRequired = answerRequired;
		this.options = options;
	}
	
	public Question(final String text, final boolean multipleChoice,
			final boolean multipleAnswer) {
		this(text, multipleChoice, multipleAnswer, false, null);
	}
	
	public String getText() {
		return text;
	}
	
	public boolean isMultipleChoice() {
		return multipleChoice;
	}

	public boolean isMultipleAnswer() {
		return multipleAnswer;
	}
	
	public boolean isAnswerRequired() {
		return answerRequired;
	}
	
	public List<String> getOptions() {
		return options;
	}
}
