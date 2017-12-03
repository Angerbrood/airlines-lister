package edu.elte.airlines.converter;

import edu.elte.airlines.dao.interfaces.UserDao;
import edu.elte.airlines.dao.interfaces.UserProfileDao;
import edu.elte.airlines.dto.UserDto;
import edu.elte.airlines.model.Passenger;
import edu.elte.airlines.model.User;
import edu.elte.airlines.model.UserProfile;
import edu.elte.airlines.model.UserProfileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@Component
@Transactional
public class UserDtoConverter implements Converter<UserDto, User> {

    @Autowired
    private UserProfileDao userProfileDao;
    @Autowired
    private UserDao userDao;

    @Override
    public User convert(UserDto userDto) {
        User result = new User();
        String userId;
        if(userDto.getId().split(" ").length == 2) {
            userId = userDto.getId().split(" ")[1];
        } else {
            userId = userDto.getId();
        }
        if(userDao.findById(Integer.parseInt(userId)) != null) {
            User tempUser = userDao.findById(Integer.parseInt(userId));
            result.setId(tempUser.getId());
            result.setUserProfiles(tempUser.getUserProfiles());

        }
        result.setSsoId(userDto.getSsoId());
        result.setPassword(userDto.getPassword());
        if(userDto.getRole() != null) {
            String role = userDto.getRole().split(" ")[1];
            UserProfile userProfile = userProfileDao.findByType(role);
            result.setUserProfiles(new HashSet<>(Arrays.asList(userProfile)));
        }
        Passenger passenger = new Passenger();
        if(userDao.findById(Integer.parseInt(userId)) != null) {
            passenger.setId(userDao.findById(result.getId()).getUserPassengerData().getId());
        }
        passenger.setEmail(userDto.getEmail());
        passenger.setAddress(userDto.getAddress());
        passenger.setAccountNumber(userDto.getAccountNumber());
        passenger.setAge(Integer.parseInt(userDto.getAge()));
        passenger.setBalance(userDto.getBalance());
        passenger.setDateOfBirth(LocalDate.parse(userDto.getDateOfBirth()));
        passenger.setFirstName(userDto.getFirstname());
        passenger.setLastName(userDto.getLastname());
        result.setUserPassengerData(passenger);

        return  result;

    }
}
