package com.refactoring.ch11.class09.step01;

public class Scorer {

	private final Candidate candidate;
	private final MedicalExam medicalExam;
	private final ScoringGuide scoringGuide;
	private int result;
	private int healthLevel;
	private boolean highMedicalRiskFlag;
	private String certificationGrade;

	public Scorer(Candidate candidate, MedicalExam medicalExam, ScoringGuide scoringGuide) {
		this.candidate = candidate;
		this.medicalExam = medicalExam;
		this.scoringGuide = scoringGuide;
	}

	public int execute() {
		this.result = 0;
		this.healthLevel = 0;
		this.highMedicalRiskFlag = false;

		this.scoreSmoking();
		this.certificationGrade = "regular";
		if (scoringGuide.stateWithLowCertification(candidate.originState())) {
			this.certificationGrade = "low";
			this.result -= 5;
		}
		this.result -= Math.max(this.healthLevel - 5, 0);
		return this.result;
	}

	private void scoreSmoking() {
		if (medicalExam.isSmoker()) {
			this.healthLevel += 10;
			this.highMedicalRiskFlag = true;
		}
	}
}
