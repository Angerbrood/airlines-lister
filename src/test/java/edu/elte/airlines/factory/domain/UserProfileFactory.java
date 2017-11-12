package edu.elte.airlines.factory.domain;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.UserProfileDao;
import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.model.UserProfile;

import java.util.UUID;

public class UserProfileFactory extends AbstractFactory<UserProfile> {

    public UserProfileFactory(UserProfileDao dao) {
        super(dao);
    }

    @Override
    public UserProfile createOne(Object... arguments) {
        UserProfile result = new UserProfile();
        result.setType(UUID.randomUUID().toString().substring(0, 10));
        return result;
    }
    public UserProfile createOneAndSave() {
        UserProfile result = createOne();
        super.getDao().persist(result);
        return result;
    }
}
