package com.github.attikovacs.quiz.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.github.attikovacs.quiz.enums.QuestioningType;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@Lob
	private String description;

	@Lob
	private Byte[] logo;

	@ManyToMany
	@JoinTable(name = "quiz_question_group", joinColumns = @JoinColumn(name = "quiz_id"), inverseJoinColumns = @JoinColumn(name = "question_group_id"))
	private Set<QuestionGroup> questionGroups;

	@Enumerated(value = EnumType.STRING)
	private QuestioningType questioningType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte[] getLogo() {
		return logo;
	}

	public void setLogo(Byte[] logo) {
		this.logo = logo;
	}

	public Set<QuestionGroup> getQuestionGroups() {
		return questionGroups;
	}

	public void setQuestionGroups(Set<QuestionGroup> questionGroups) {
		this.questionGroups = questionGroups;
	}

	public QuestioningType getQuestioningType() {
		return questioningType;
	}

	public void setQuestioningType(QuestioningType questioningType) {
		this.questioningType = questioningType;
	}

}
