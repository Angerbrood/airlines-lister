package edu.elte.airlines.configuration.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import edu.elte.airlines.configuration.database.DatabaseConfig;
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
import edu.elte.airlines.domain.Airline;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.domain.UserDetail;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.provider.DaoProvider;

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
    UserDetailDao userDetailDao() {
    	return new UserDetailDaoImpl(sessionFactory);
    }
    @Bean
    UserIdDao userIdDao() {
    	return new UserIdDaoImpl(sessionFactory);
    }
    @Bean
    DaoProvider daoProvider() {
    	DaoProvider provider = new DaoProvider();
    	provider.registerDao(Airline.class, airlineDao());
    	provider.registerDao(Flight.class, flightDao());
    	provider.registerDao(Location.class, locationDao());
    	provider.registerDao(UserAuth.class, userAuthDao());
    	provider.registerDao(UserDetail.class, userDetailDao());
    	provider.registerDao(UserId.class, userIdDao());
    	return provider;
    }
}
