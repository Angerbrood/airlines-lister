package edu.elte.airlines.converter.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserDetailDto;

@Component
public class UserDetailDtoConverter implements Converter<UserPersonalData, UserDetailDto> {

	
	@Override
	public UserDetailDto convert(UserPersonalData userPersonalData) {
		UserDetailDto result = new UserDetailDto();
		result.setId(userPersonalData.getId());
		result.setAccountNumber(userPersonalData.getAccountNumber());
		result.setBalance(userPersonalData.getBalance());
		result.setDateOfBirth(userPersonalData.getDateOfBirth());
		result.setName(userPersonalData.getFirstName() + " " + userPersonalData.getLastName());
		result.setAge(userPersonalData.getAge());
		return result;
	}

}
