package edu.elte.airlines.dto;

public class UserIdDto implements DtoInterface<Integer> {
	private Integer id;
	private UserAuthDto userAuthDto;
	private UserPersonalDataDto userPersonalDataDto;

	public UserIdDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserAuthDto getUserAuthDto() {
		return userAuthDto;
	}

	public void setUserAuthDto(UserAuthDto userAuthDto) {
		this.userAuthDto = userAuthDto;
	}

	public UserPersonalDataDto getUserPersonalDataDto() {
		return userPersonalDataDto;
	}

	public void setUserPersonalDataDto(UserPersonalDataDto userPersonalDataDto) {
		this.userPersonalDataDto = userPersonalDataDto;
	}
}
