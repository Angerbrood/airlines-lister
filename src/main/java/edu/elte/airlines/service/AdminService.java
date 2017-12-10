package edu.elte.airlines.service;

import edu.elte.airlines.model.EntityInterface;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.model.User;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.response.CustomResponseFactory;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.FlightService;
import edu.elte.airlines.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
public class AdminService {

    private final CrudService crudService;
    private final CustomResponseFactory customResponseFactory;
    private static Logger logger = LoggerFactory.getLogger(AdminService.class);

    public AdminService(CrudService crudService, CustomResponseFactory customResponseFactory) {
        this.crudService = crudService;
        this.customResponseFactory = customResponseFactory;
    }

    public CustomResponse list() {
        CustomResponse response;
        try {
            response = customResponseFactory.successfullResponse(crudService.list());
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
            logger.error(ex.getMessage());
        }
        return response;
    }
    public CustomResponse create(Object dtoObject) {
        CustomResponse response;
        try {
            EntityInterface entity = (EntityInterface) dtoObject;
            crudService.create(entity);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
            logger.error(ex.getMessage());
        }
        return response;
    }
    public CustomResponse update(Object dtoObject) {
        CustomResponse response;
        try {
            EntityInterface entity = (EntityInterface) dtoObject;
            crudService.update(entity);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
            logger.error(ex.getMessage());
        }
        return response;
    }
    public CustomResponse delete(Object dtoObject) {
        CustomResponse response;
        try {
            Integer id = (Integer) dtoObject;
            EntityInterface entity =(EntityInterface) crudService.findById(id);
            crudService.delete(entity);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
            logger.error(ex.getMessage());
        }
        return response;
    }
    public CustomResponse findById(Object dtoObject) {
        CustomResponse response;
        try {
            String id = (String) dtoObject;
            EntityInterface entity = (EntityInterface) crudService.findById(Integer.parseInt(id));
            response = customResponseFactory.successfullResponse(entity);
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
            logger.error(ex.getMessage());
        }
        return response;
    }
    public CustomResponse exists(Integer id) {
        CustomResponse response;
        try {
            Boolean result = crudService.exists(id);
            response = customResponseFactory.successfullResponse(result);
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
            logger.error(ex.getMessage());
        }
        return response;
    }
    public CustomResponse bookFlight(Object objectDto, String ssoId) {
        CustomResponse response;
        try {
            FlightService flightService = (FlightService) crudService;
            String tempId = (String) objectDto;
            Integer flightId = Integer.parseInt(tempId);
            flightService.bookFlight(ssoId, flightId);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse removeReservation(Object objectDto, String ssoId) {
        CustomResponse response;
        try {
            FlightService flightService = (FlightService) crudService;
            String tempId = (String) objectDto;
            Integer flightId = Integer.parseInt(tempId);
            flightService.removeReservation(ssoId, flightId);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse fetchUsers() {
        CustomResponse response;
        try {
            UserService userService = (UserService) crudService;
            List<User> users = userService.findAllUsers();
            response = customResponseFactory.successfullResponse(users);
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse getPersonalData(Object dtoObject) {
        CustomResponse response;
        try {
            UserService userService = (UserService) crudService;
            String username = (String) dtoObject;
            User currentUser = userService.findBySSO(username);
            response = customResponseFactory.successfullResponse(currentUser);
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse modifyPersonalData(Object dtoObject) {
        CustomResponse response;
        try {
            UserService userService = (UserService) crudService;
            User currentUser = (User) dtoObject;
            userService.updateUser(currentUser);
            response = customResponseFactory.successfullResponse(currentUser);
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse createFlight(Object flightdto, String airlineId) {
        CustomResponse response;
        try {
            FlightService flightService = (FlightService) crudService;
            Flight flight = (Flight) flightdto;
            flightService.createFlight(flight, airlineId);
            response = customResponseFactory.successfullResponse();

        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse deleteFlight(Object dtoObject) {
        CustomResponse response;
        try {
            FlightService flightService = (FlightService) crudService;
            Integer id = (Integer) dtoObject;
            flightService.deleteFlight(id);
            response = customResponseFactory.successfullResponse();

        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse listReservations(Object data) {
        CustomResponse response;
        try {
            String ssoId = (String)data;
            FlightService flightService = (FlightService) crudService;
            List<Flight> reservations = flightService.getReservedFlightsByUser(ssoId);
            response = customResponseFactory.successfullResponse(reservations);
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }

    public CustomResponse getUserPermission(Object data) {
        CustomResponse response;
        try {
            String ssoId = (String) data;
            UserService userService = (UserService) crudService;
            boolean isAdmin = userService.isAdmin(userService.findBySSO(ssoId));
            if(isAdmin) {
                response = customResponseFactory.successfullResponse("TYPE:ADMIN");
            } else {
                response = customResponseFactory.successfullResponse("TYPE:USER");
            }
        } catch (Exception ex) {
            response = this.customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse registerUser(Object object) {
        CustomResponse response;
        try {
            User user = (User) object;
            UserService userService = (UserService) crudService;
            userService.registerNewUser(user);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse updateUser(User user) {
        CustomResponse response;
        try {
            UserService userService = (UserService) crudService;
            userService.updateUser(user);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return  response;
    }
}
