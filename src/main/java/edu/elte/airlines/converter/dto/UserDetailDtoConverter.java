package edu.elte.airlines.converter.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.elte.airlines.domain.UserDetail;
import edu.elte.airlines.dto.UserDetailDto;

@Component
public class UserDetailDtoConverter implements Converter<UserDetail, UserDetailDto> {

	
	@Override
	public UserDetailDto convert(UserDetail userDetail) {
		UserDetailDto result = new UserDetailDto();
		result.setId(userDetail.getId());
		result.setAccountNumber(userDetail.getAccountNumber());
		result.setBalance(userDetail.getBalance());
		result.setDateOfBirth(userDetail.getDateOfBirth());
		result.setName(userDetail.getFirstName() + " " + userDetail.getLastName());
		result.setAge(userDetail.getAge());
		return result;
	}

}
