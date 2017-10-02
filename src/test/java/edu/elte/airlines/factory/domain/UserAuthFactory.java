package edu.elte.airlines.factory.domain;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.RoleEnum;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.domain.UserRole;
import edu.elte.airlines.factory.AbstractFactory;

import java.util.LinkedList;
import java.util.List;

public class UserAuthFactory extends AbstractFactory<UserAuth> {
    public UserAuthFactory(CrudDao<UserAuth, ?> dao) {
        super(dao);
    }

    @Override
    public UserAuth createOne(Object... arguments) {
        Faker faker = new Faker();
        UserAuth result = new UserAuth();
        result.setUsername(faker.name().username());
        result.setPassword(faker.name().username() + faker.number().digit());
        List<UserRole> roles = new LinkedList<>();
        UserRole role = new UserRole();
        role.setRole(RoleEnum.ADMIN);
        roles.add(role);
        result.setRoles(roles);
        return result;
    }
}
