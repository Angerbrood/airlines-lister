package edu.elte.airlines.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import edu.elte.airlines.dao.impl.AirlineDaoImpl;
import edu.elte.airlines.dao.impl.FlightDaoImpl;
import edu.elte.airlines.dao.impl.LocationDaoImpl;
import edu.elte.airlines.dao.impl.UserAuthDaoImpl;
import edu.elte.airlines.dao.impl.UserDetailsDaoImpl;
import edu.elte.airlines.dao.impl.UserIdDaoImpl;
import edu.elte.airlines.dao.interfaces.IAirlineDao;
import edu.elte.airlines.dao.interfaces.IFlightDao;
import edu.elte.airlines.dao.interfaces.ILocationDao;
import edu.elte.airlines.dao.interfaces.IUserAuthDao;
import edu.elte.airlines.dao.interfaces.IUserDetailsDao;
import edu.elte.airlines.dao.interfaces.IUserIdDao;

@Configuration
@EnableTransactionManagement
@Import({DatabaseConfig.class})
public class DaoConfig {

    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    IAirlineDao airlineDao() {
    	return new AirlineDaoImpl(sessionFactory);
    }
    @Bean
    IFlightDao flightDao() {
    	return new FlightDaoImpl(sessionFactory);
    }
    @Bean
    ILocationDao locationDao() {
    	return new LocationDaoImpl(sessionFactory);
    }
    @Bean
    IUserAuthDao userAuthDao() {
    	return new UserAuthDaoImpl(sessionFactory);
    }
    @Bean
    IUserDetailsDao userDetailsDao() {
    	return new UserDetailsDaoImpl(sessionFactory);
    }
    @Bean
    IUserIdDao userIdDao() {
    	return new UserIdDaoImpl(sessionFactory);
    }
}
