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
import edu.elte.airlines.dao.impl.UserDetailDaoImpl;
import edu.elte.airlines.dao.impl.UserIdDaoImpl;
import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.dao.interfaces.LocationDao;
import edu.elte.airlines.dao.interfaces.UserAuthDao;
import edu.elte.airlines.dao.interfaces.UserDetailDao;
import edu.elte.airlines.dao.interfaces.UserIdDao;

@Configuration
@EnableTransactionManagement
@Import({DatabaseConfig.class})
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
    UserAuthDao userAuthDao() {
    	return new UserAuthDaoImpl(sessionFactory);
    }
    @Bean
    UserDetailDao userDetailsDao() {
    	return new UserDetailDaoImpl(sessionFactory);
    }
    @Bean
    UserIdDao userIdDao() {
    	return new UserIdDaoImpl(sessionFactory);
    }
}
