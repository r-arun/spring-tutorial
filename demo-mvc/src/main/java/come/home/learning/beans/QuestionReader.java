package come.home.learning.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import come.home.learning.model.Question;

public class QuestionReader {
	public List<Question> getQuestions() {
		final ClassPathResource resource = new ClassPathResource("questions/questions.xml");
		final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		final List<Question> questionList = new ArrayList<Question>();
		try {
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            final Document document = dBuilder.parse(resource.getFile());
            document.getDocumentElement().normalize();
            final NodeList nList = document.getElementsByTagName("question");
            
            for (int i = 0; i < nList.getLength(); ++i) {
            	List<String> options = null;
                final Node node = nList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    final Element element = (Element) node;
                    final String text = getInternalTag(element, "question-text");
                    final String isMultipleChoice = getInternalTag(element, "multiple-choice");
                    final String isMultipleAnswer = getInternalTag(element, "multiple-answer");
                    String isAnswerRequired = getInternalTag(element, "is-answer-required");
                    if (isAnswerRequired == null) {
                    	isAnswerRequired = "false";
                    }
                    final Element optionTag = getOptionTag(element, "options");
                    if (optionTag != null) {
                        options = getInternalTagList(optionTag, "option");
                    }
                    final Question question = new Question(text, new Boolean(isMultipleChoice),
                                            new Boolean(isMultipleAnswer),
                                            new Boolean(isAnswerRequired), options);
                    questionList.add(question);
                    System.out.println(question.getText() + " " + question.isMultipleChoice()
                    		+ " " + question.isMultipleAnswer());
                }
            }
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return questionList;
	}
	
	private Element getOptionTag(final Element element, final String tagName) {
		if (element != null) {
            final NodeList nodeList = element.getElementsByTagName("options");
            if (nodeList != null && nodeList.getLength() > 0) {
                return (Element) nodeList.item(0);
            }
		}
		return null;
	}

	private List<String> getInternalTagList(final Element element, final String tagName) {
        final List<String> tagList = new ArrayList<String>();
		if (element != null) {
			final NodeList nodeList = element.getElementsByTagName(tagName);
			if (nodeList != null) {
				for (int i = 0; i < nodeList.getLength(); ++i) {
					tagList.add(nodeList.item(i).getTextContent());
				}
			}
		}
        return tagList;
	}
	
	private String getInternalTag(final Element element, final String tagName) {
		if (element != null) {
			final NodeList nodeList = element.getElementsByTagName(tagName);
			if (nodeList != null && nodeList.getLength() > 0) {
				return nodeList.item(0).getTextContent();
			}
		}
		return null;
	}
}
