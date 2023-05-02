package bo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Article {
	
	private Integer id;
	@NonNull
	private String title;
	@NonNull
	private String content;
	@NonNull
	private String author;

	private LocalDate dateCreation;

	@ToString.Exclude
	private boolean isPublished;

}
