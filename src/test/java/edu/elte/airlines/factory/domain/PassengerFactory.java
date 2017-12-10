package edu.elte.airlines.factory.domain;


import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.PassengerDao;
import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.model.Passenger;

import java.time.LocalDate;

public class PassengerFactory extends AbstractFactory<Passenger> {

    public PassengerFactory(PassengerDao dao) {
        super(dao);
    }

    @Override
    public Passenger createOne(Object... arguments) {
        Faker faker = new Faker();
        Passenger result = new Passenger();
        result.setFirstName(faker.name().firstName());
        result.setLastName(faker.name().lastName());
        result.setAge(faker.number().randomDigit());
        result.setAddress(faker.address().fullAddress());
        result.setBalance(1000000);
        result.setAccountNumber(faker.number().digits(10));
        result.setDateOfBirth(LocalDate.of(1990,1,1));
        result.setEmail(result.getFirstName() + "_" + result.getLastName() + "@foo.com");
        return result;
    }
}
