package com.refactoring.ch08.class04.step01;

import java.time.LocalDate;
import java.util.List;

public class PersonRender {
	public String renderPerson(Person person) {
		StringBuilder result = new StringBuilder();
		result.append("<p>Person: " + person.getName() + "</p>").append("\n");
		result.append(renderPhoto(person.getPhoto())).append("\n");
		result.append(emitPhotoData(person.getPhoto()));
		result.append("<p>위치: " + person.getPhoto().getLocation() + "</p>").append("\n");
		return result.toString();
	}

	public String listRecentPhotos(List<Photo> photos){
		StringBuilder result = new StringBuilder();
		photos.stream()
			.filter(p-> p.getData().isAfter(recentDateCutoff()))
			.forEach(p->{
				result.append("<div>").append("\n");
				result.append(emitPhotoData(p));
				result.append("<p>위치: " + p.getLocation() + "</p>").append("\n");
				result.append("</div>");
			});
		return result.toString();
	}

	// 특정 날짜를 기준으로 최신 사진을 선별하기 위한 최신일자 컷오프 반환
	private LocalDate recentDateCutoff() {
		return LocalDate.now().minusDays(7);
	}

	private String emitPhotoData(Photo photo) {
		StringBuilder result = new StringBuilder();
		result.append("<p>제목: ").append(photo.getTitle()).append("</p>").append("\n");
		result.append("<p>날짜: " + photo.getData().toString() + "</p>").append("\n");
		return result.toString();
	}

	private String renderPhoto(Photo photo) {
		return "<div>\n" +
				"  <img src=\"" + photo.getUrl() + "\"/>\n" +
				"</div>";
	}
}
