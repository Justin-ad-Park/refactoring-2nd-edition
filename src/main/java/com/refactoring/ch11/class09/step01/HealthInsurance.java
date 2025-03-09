package com.refactoring.ch11.class09.step01;

public class HealthInsurance {

	public int score(Candidate candidate, MedicalExam medicalExam, ScoringGuide scoringGuide) {
		return new Scorer(candidate, medicalExam, scoringGuide).execute();
	}
}
