package edu.elte.airlines.converter.model;

import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserPersonalDataDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserPersonalDataConverter implements Converter<UserPersonalDataDto, UserPersonalData> {
    @Override
    public UserPersonalData convert(UserPersonalDataDto userPersonalDataDto) {
        UserPersonalData userPersonalData = new UserPersonalData();
        userPersonalData.setId(userPersonalDataDto.getId());
        userPersonalData.setDateOfBirth(userPersonalDataDto.getDateOfBirth());
        userPersonalData.setAccountNumber(userPersonalDataDto.getAccountNumber());
        userPersonalData.setBalance(userPersonalDataDto.getBalance());
        userPersonalData.setAge(userPersonalDataDto.getAge());
        userPersonalData.setAddress(userPersonalDataDto.getAddress());
        String[] name = userPersonalDataDto.getName().split(" ");
        userPersonalData.setFirstName(name[0]);
        userPersonalData.setLastName(name[1]);
        return userPersonalData;
    }
}
