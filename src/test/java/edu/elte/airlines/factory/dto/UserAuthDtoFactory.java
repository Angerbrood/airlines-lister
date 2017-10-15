package edu.elte.airlines.factory.dto;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.RoleEnum;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.domain.UserRole;
import edu.elte.airlines.dto.UserAuthDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.service.interfaces.CrudService;

import java.util.LinkedList;
import java.util.List;

public class UserAuthDtoFactory extends AbstractDtoFactory<UserAuth, UserAuthDto, Integer> {


    public UserAuthDtoFactory(CrudService<UserAuth, UserAuthDto, Integer> crudService) {
        super(crudService);
    }

    @Override
    public UserAuthDto createOne(Object... arguments) {
        Faker faker = new Faker();
        UserAuthDto result = new UserAuthDto();
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
