package edu.elte.airlines.factory.domain;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.factory.AbstractFactory;

public class UserIdFactory extends AbstractFactory<UserId> {
    private UserAuthFactory userAuthFactory;
    private UserPersonalDataFactory userPersonalDataFactory;

    public UserIdFactory(CrudDao<UserId, ?> dao, UserAuthFactory userAuthFactory, UserPersonalDataFactory userPersonalDataFactory) {
        super(dao);
        this.userAuthFactory = userAuthFactory;
        this.userPersonalDataFactory = userPersonalDataFactory;
    }

    @Override
    public UserId createOne(Object... arguments) {
        UserId result = new UserId();
        result.setUserAuth(userAuthFactory.createOne());
        result.setUserPersonalData(userPersonalDataFactory.createOne());
        return result;
    }
}
