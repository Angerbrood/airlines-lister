package edu.elte.airlines.factory.dto;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserPersonalDataDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.service.interfaces.CrudService;

import java.time.LocalDate;

public class UserPersonalDataDtoFactory extends AbstractDtoFactory<UserPersonalData, UserPersonalDataDto, Integer> {


    public UserPersonalDataDtoFactory(CrudService<UserPersonalData, UserPersonalDataDto, Integer> crudService) {
        super(crudService);
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
        result.setDateOfBirth(LocalDate.of(1995, 1,1));
        return result;
    }
    public UserPersonalDataDto createAndSave(Object... arguments) {
        UserPersonalDataDto result = createOne();
        result.setId(getService().create(result));
        return result;
    }
}
