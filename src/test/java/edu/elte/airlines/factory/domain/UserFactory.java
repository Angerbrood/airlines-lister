package edu.elte.airlines.factory.domain;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.UserDao;
import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.model.User;
import edu.elte.airlines.model.UserProfile;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserFactory extends AbstractFactory<User> {

    private final UserProfileFactory userProfileFactory;
    private final PassengerFactory passengerFactory;

    public UserFactory(UserDao dao, UserProfileFactory userProfileFactory, PassengerFactory passengerFactory) {
        super(dao);
        this.userProfileFactory = userProfileFactory;
        this.passengerFactory = passengerFactory;
    }

    @Override
    public User createOne(Object... arguments) {
        Faker faker = new Faker();
        User result = new User();
        result.setPassword(faker.number().digits(6));
        result.setSsoId(UUID.randomUUID().toString());
        Set<UserProfile> profiles = new HashSet<>();
        profiles.add(userProfileFactory.createOneAndSave());
        result.setUserProfiles(profiles);
        result.setUserPassengerData(passengerFactory.createOne());
        return result;

    }
}
