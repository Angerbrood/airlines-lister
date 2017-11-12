package edu.elte.airlines.service;

import edu.elte.airlines.model.EntityInterface;
import edu.elte.airlines.model.User;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.response.CustomResponseFactory;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.FlightService;
import edu.elte.airlines.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

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
            Integer id = (Integer) dtoObject;
            EntityInterface entity = (EntityInterface) crudService.findById(id);
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
            Integer flightId = (Integer) objectDto;
            UserService userService = (UserService) crudService;
            User currentUser = userService.findBySSO(ssoId);
            flightService.bookFlight(currentUser.getId(), flightId);
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
            Integer flightId = (Integer) objectDto;
            UserService userService = (UserService) crudService;
            User currentUser = userService.findBySSO(ssoId);
            flightService.removeReservation(currentUser.getId(), flightId);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
}
