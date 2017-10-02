package edu.elte.airlines.factory.domain;


import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.factory.AbstractFactory;

import java.time.LocalDate;

public class UserPersonalDataFactory extends AbstractFactory<UserPersonalData> {

    public UserPersonalDataFactory(CrudDao<UserPersonalData, ?> dao) {
        super(dao);
    }

    @Override
    public UserPersonalData createOne(Object... arguments) {
        Faker faker = new Faker();
        UserPersonalData result = new UserPersonalData();
        result.setFirstName(faker.name().firstName());
        result.setLastName(faker.name().lastName());
        result.setAge(faker.number().randomDigit());
        result.setAddress(faker.address().fullAddress());
        result.setBalance(faker.number().digits(6));
        result.setAccountNumber(faker.number().digits(10));
        result.setDateOfBirth(LocalDate.of(1990,1,1));
        return result;
    }
}
