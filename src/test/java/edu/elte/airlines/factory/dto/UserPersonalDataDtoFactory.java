package edu.elte.airlines.factory.dto;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dto.UserPersonalDataDto;
import edu.elte.airlines.factory.AbstractFactory;

import java.time.LocalDate;

public class UserPersonalDataDtoFactory extends AbstractFactory<UserPersonalDataDto> {
    public UserPersonalDataDtoFactory(CrudDao<UserPersonalDataDto, ?> dao) {
        super(dao);
    }

    @Override
    public UserPersonalDataDto createOne(Object... arguments) {
        Faker faker = new Faker();
        UserPersonalDataDto result = new UserPersonalDataDto();
        result.setName(faker.name().name());
        result.setAge(faker.number().randomDigit());
        result.setAddress(faker.address().fullAddress());
        result.setBalance(faker.number().digits(6));
        result.setAccountNumber(faker.number().digits(10));
        result.setDateOfBirth(LocalDate.of(faker.number().randomDigit(), faker.number().randomDigit(), faker.number().randomDigit()));
        return result;
    }
}
