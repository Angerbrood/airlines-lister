package edu.elte.airlines.configuration;

import edu.elte.airlines.dao.impl.*;
import edu.elte.airlines.dao.interfaces.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@Import(HibernateConfiguration.class)
public class DaoConfig {

    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    AirlineDao airlineDao() {
        return new AirlineDaoImpl(sessionFactory);
    }
    @Bean
    FlightDao flightDao() {
        return new FlightDaoImpl(sessionFactory);
    }
    @Bean
    LocationDao locationDao() {
        return new LocationDaoImpl(sessionFactory);
    }
    @Bean
    PassengerDao passengerDao() {
        return new PassengerDaoImpl(sessionFactory);
    }
    @Bean
    UserDao userDao() {
        return new UserDaoImpl(sessionFactory);
    }
    @Bean
    UserProfileDao userProfileDao() {
        return new UserProfileDaoImpl(sessionFactory);
    }
    @Bean
    PersistentTokenRepository persistentTokenRepository() {
        return new HibernateTokenRepositoryImpl(sessionFactory);
    }
}
