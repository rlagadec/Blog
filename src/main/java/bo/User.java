package bo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
	
	private Integer id;
	@NonNull private String username;
	@NonNull private String email;
	@NonNull private String password;
	@NonNull private String firstname;
	@NonNull private String lastname;
	@NonNull private LocalDate dateCreated;
	
	
	public User(@NonNull String username, @NonNull String password) {
		super();
		this.username = username;
		this.password = password;
		this.dateCreated = LocalDate.now();
	}

	
	
}
