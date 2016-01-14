package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import beans.vocabulary.VocabularyWordContainer;
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

	@RequestMapping("/getWordsEx")
	public WordGroup getLastWordGroup(@RequestParam(value = "groupName", defaultValue = "WeekDays") String groupName) {
		WordGroup lastWordGroup = null;
		for (WordGroup wordGroup : repository.findAll()) {
			System.out.println(wordGroup.getGroupName());
			lastWordGroup = wordGroup;
		}
			return lastWordGroup;

	}

}