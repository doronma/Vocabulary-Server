package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import beans.vocabulary.Word;
import beans.vocabulary.WordGroup;
import repository.VocabularyRepositoryEx;

@RestController
public class VocabolaryControllerEx {

	@Autowired
	private VocabularyRepositoryEx repository;

	@RequestMapping("/addWordsEx")
	public String addWords() {
		// repository.deleteAll();
		WordGroup wordGroup1 = new WordGroup("WeekDays");
		wordGroup1.addWord(new Word("Sunday", "יום ראשון"));
		wordGroup1.addWord(new Word("Monday", "יום שני"));
		WordGroup wordGroup2 = new WordGroup("Animals");
		wordGroup2.addWord(new Word("Frog", "צפרדע"));
		wordGroup2.addWord(new Word("Dog", "כלב"));
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

	@RequestMapping("/getWordsExByName")
	public WordGroup getWordGroup(@RequestParam(value = "groupName", defaultValue = "WeekDays") String groupName) {
		WordGroup wordGroup = repository.findByGroupName(groupName);
		//System.out.println(wordGroup.getGroupName());

		return wordGroup;

	}

}