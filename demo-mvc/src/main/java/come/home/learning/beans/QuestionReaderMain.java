package come.home.learning.beans;

import java.util.List;

import come.home.learning.model.Question;

public class QuestionReaderMain {
	//TODO replace with Junit test class
	public static void main(final String argsp[]) {
		final QuestionReader reader = new QuestionReader();
		final List<Question> questionList = reader.getQuestions();
		for (final Question question: questionList) {
			System.out.println(question.getText() + " " + question.isMultipleChoice()
					+ " " + question.isMultipleAnswer() + " " + question.isAnswerRequired());
			final List <String> options = question.getOptions();
			if (options != null) {
                System.out.println("Options");
                for (final String option: options) {
                    System.out.println(option);
                }
			}
		}
	}
}
