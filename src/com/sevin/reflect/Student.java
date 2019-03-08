package com.sevin.reflect;

import java.util.List;

public class Student {

	private double score = 1.33;
	public List<String> courses;
	public static int grade;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public static int getGrade() {
		return grade;
	}
	public static void setGrade(int grade) {
		Student.grade = grade;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [score=");
		builder.append(score);
		builder.append(", courses=");
		builder.append(courses);
		builder.append("]");
		return builder.toString();
	}
}
