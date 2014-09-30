package come.home.learning.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import come.home.learning.beans.QuestionReader;
import come.home.learning.model.Question;
import come.home.learning.view.model.OptionViewModel;
import come.home.learning.view.model.QuestionViewModel;
import come.home.learning.view.model.constants.ViewModelAttributes;

@Controller
public class QuestionController {
	private final QuestionReader reader;
	
	@Autowired
	public QuestionController(final QuestionReader reader) {
		this.reader = reader;
	}

	@RequestMapping(value = "/question")
	public String getQuestion(final Model model) {
		final List <Question> questionList = reader.getQuestions();
		final int index = (int)(Math.random() * questionList.size());
		final Question question = questionList.get(index);
		final QuestionViewModel questionModel =
				new QuestionViewModel(ViewModelAttributes.QUESTION.getId(),
						ViewModelAttributes.QUESTION.getType(),
						ViewModelAttributes.QUESTION.getCssClass() +
						(question.isAnswerRequired() ? " answer-required" : ""),
						question.getText());
		final OptionViewModel optionModel =
				new OptionViewModel(ViewModelAttributes.OPTION.getId(),
						ViewModelAttributes.OPTION.getType(),
						ViewModelAttributes.OPTION.getCssClass(),
						ViewModelAttributes.OPTION.getName(),
						question.isMultipleChoice(),
						question.isMultipleAnswer(),
						getOptionMap(question.getOptions()));
        model.addAttribute("question", questionModel);
        model.addAttribute("isAnswerRequired", question.isAnswerRequired());
        model.addAttribute("options", optionModel);
		return "question";
	}
	
	private Map<String, String> getOptionMap(final List <String> options) {
		if (options == null) return null;
		final HashMap<String, String> optionsMap = new HashMap<String, String>();
		for(final String option: options) {
			optionsMap.put(option, option);
		}
		return optionsMap;
	}
}
