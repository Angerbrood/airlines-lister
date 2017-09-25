package edu.elte.airlines.configuration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.elte.airlines.configuration.dao.DaoConfig;
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
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.provider.DaoProvider;
import edu.elte.airlines.provider.ServiceProvider;
import edu.elte.airlines.response.CustomResponseFactory;
import edu.elte.airlines.service.impl.AirlineServiceImpl;
import edu.elte.airlines.service.impl.FlightServiceImpl;
import edu.elte.airlines.service.impl.LocationServiceImpl;
import edu.elte.airlines.service.impl.UserDetailsServiceImpl;
import edu.elte.airlines.service.impl.UserPersonalDataServiceImpl;
import edu.elte.airlines.service.impl.UserIdServiceImpl;
import edu.elte.airlines.service.interfaces.AirlineService;
import edu.elte.airlines.service.interfaces.FlightService;
import edu.elte.airlines.service.interfaces.LocationService;
import edu.elte.airlines.service.interfaces.UserPersonalDataService;
import edu.elte.airlines.service.interfaces.UserIdService;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {
	@Autowired
	private DaoProvider daoProvider;
	
	@Bean
	AirlineService airlineService() {
		return new AirlineServiceImpl((AirlineDao) daoProvider.getDao(Airline.class));
	}
	@Bean
	FlightService flightService() {
		return new FlightServiceImpl((FlightDao) daoProvider.getDao(Flight.class));
	}
	@Bean
	LocationService locationService() {
		return new LocationServiceImpl((LocationDao) daoProvider.getDao(Location.class));
	}
	@Bean
	UserDetailsService userAuthService() {
		return new UserDetailsServiceImpl((UserAuthDao) daoProvider.getDao(UserAuth.class));
	}

	@Bean
	UserPersonalDataService userDetailService() {
		return new UserPersonalDataServiceImpl((UserDetailDao) daoProvider.getDao(UserPersonalData.class));
	}
	@Bean
	UserIdService userIdService() {
		return new UserIdServiceImpl((UserIdDao) daoProvider.getDao(UserId.class));
	}
	
	@Bean
	ServiceProvider serviceProvider() {
		ServiceProvider provider = new ServiceProvider(customResponseFactory());
		provider.registerService(Airline.class, airlineService());
		provider.registerService(Flight.class, flightService());
		provider.registerService(Location.class, locationService());
		//provider.registerService(UserAuth.class, userAuthService());
		provider.registerService(UserPersonalData.class, userDetailService());
		provider.registerService(UserId.class, userIdService());
		return provider;
	}
    @Bean
    CustomResponseFactory customResponseFactory() {
        return new CustomResponseFactory();
    }
}