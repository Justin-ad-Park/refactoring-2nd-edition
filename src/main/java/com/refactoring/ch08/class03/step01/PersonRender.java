package com.refactoring.ch08.class03.step01;

public class PersonRender {
	public String renderPerson(Person person) {
		StringBuilder result = new StringBuilder();
		result.append("<p>Person: " + person.getName() + "</p>").append("\n");
		result.append(renderPhoto(person.getPhoto())).append("\n");
		result.append(emitPhotoData(person.getPhoto()));
		return result.toString();
	}

	public String photoDiv(Photo photo){
		StringBuilder result = new StringBuilder();
		result.append("<div>").append("\n");
		result.append(emitPhotoData(photo));
		result.append("</div>");
		return result.toString();
	}

	private String emitPhotoData(Photo photo) {
		StringBuilder result = new StringBuilder();
		result.append("<p>제목: ").append(photo.getTitle()).append("</p>").append("\n");
		result.append("<p>위치: " + photo.getLocation() + "</p>").append("\n");
		result.append("<p>날짜: " + photo.getData().toString() + "</p>").append("\n");
		return result.toString();
	}

	private String renderPhoto(Photo photo) {
		return "<div>\n" +
				"  <img src=\"" + photo.getUrl() + "\"/>\n" +
				"</div>";
	}
}
