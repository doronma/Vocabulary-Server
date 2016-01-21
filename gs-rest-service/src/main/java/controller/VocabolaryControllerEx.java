package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import beans.vocabulary.Message;
import beans.vocabulary.Word;
import beans.vocabulary.WordGroup;
import repository.VocabularyRepositoryEx;

@CrossOrigin
@RestController
public class VocabolaryControllerEx {

	@Autowired
	private VocabularyRepositoryEx repository;

	@RequestMapping("/addWordsEx")
	public String addWords() {
		repository.deleteAll();
		WordGroup wordGroup1 = new WordGroup("WeekDays");
		wordGroup1.addWord(new Word("Sunday", "יום ראשון"));
		wordGroup1.addWord(new Word("Monday", "יום שני"));
		wordGroup1.addWord(new Word("Tuesday", "יום שלישי"));
		wordGroup1.addWord(new Word("Wednesday", "יום רביעי"));
		wordGroup1.addWord(new Word("Thursday", "יום חמישי"));
		wordGroup1.addWord(new Word("Friday", "יום שישי"));
		wordGroup1.addWord(new Word("Saturday", "יום שבת"));
		WordGroup wordGroup2 = new WordGroup("Animals");
		wordGroup2.addWord(new Word("frog", "צפרדע"));
		wordGroup2.addWord(new Word("pig", "חזיר"));
		wordGroup2.addWord(new Word("duck", "ברבז"));
		wordGroup2.addWord(new Word("dog", "כלב"));
		wordGroup2.addWord(new Word("spider", "עכביש"));
		wordGroup2.addWord(new Word("fish", "דג"));
		wordGroup2.addWord(new Word("bee", "דבורה"));
		wordGroup2.addWord(new Word("bear", "דב"));
		wordGroup2.addWord(new Word("rose", "שושנה"));
		wordGroup2.addWord(new Word("tree", "עץ"));
		repository.save(wordGroup1);
		repository.save(wordGroup2);
		for (WordGroup wordGroup : repository.findAll()) {
			System.out.println(wordGroup);
		}

		return "ok";

	}

	@CrossOrigin
	@RequestMapping("/getWordGroupNameList")
	public List<String> getLastWordGroup() {
		List<String> wordGroupNameList = new ArrayList<String>();
		for (WordGroup wordGroup : repository.findAll()) {
			wordGroupNameList.add(wordGroup.getGroupName());
		}
		return wordGroupNameList;
	}

	@CrossOrigin
	@RequestMapping("/getWordsExByName")
	public WordGroup getWordGroup(@RequestParam(value = "groupName", defaultValue = "WeekDays") String groupName) {
		WordGroup wordGroup = repository.findByGroupName(groupName);
		// System.out.println(wordGroup.getGroupName());

		return wordGroup;

	}
	
	
	@RequestMapping(value="/sendWords",method = RequestMethod.POST)
	public Message sendwords (@RequestBody WordGroup wordGroup){
		System.out.println("in sendWords");
		System.out.println(wordGroup);
		Message message = new Message();
		message.setMsg("All is Good");
		return message;
	}

}