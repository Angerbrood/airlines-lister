package edu.elte.airlines.service;



import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.service.interfaces.UserIdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import edu.elte.airlines.dto.DtoInterface;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.response.CustomResponseFactory;
import edu.elte.airlines.service.interfaces.CrudService;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AdminService {

    private final CrudService crudService;
    private final CustomResponseFactory customResponseFactory;
    private static Logger logger = LoggerFactory.getLogger(AdminService.class);
    public AdminService(CrudService<?, DtoInterface, String> crudService, CustomResponseFactory customResponseFactory) {
        this.crudService = crudService;
        this.customResponseFactory = customResponseFactory;
    }

    public CustomResponse list() {
        CustomResponse response;
        try {
            response = customResponseFactory.successfullResponse(crudService.list());
        } catch (Exception ex) {

            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse create(DtoInterface dtoObject) {
        CustomResponse response;
        try {
            crudService.create(dtoObject);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {

            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse update(DtoInterface dtoObject) {
        CustomResponse response;
        try {
            crudService.update(dtoObject);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {

            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse delete(Integer id) {
        CustomResponse response;
        try {
            DtoInterface dtoInterface = (DtoInterface) crudService.findById(id);
            crudService.delete(dtoInterface);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {

            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
    public CustomResponse findById(Integer id) {
        CustomResponse response;
        try {
            DtoInterface dtoObject = (DtoInterface) crudService.findById(id);
            response = customResponseFactory.successfullResponse(dtoObject);
        } catch (Exception ex) {

            response = customResponseFactory.errorResponse(ex);
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
        }
        return response;
    }
    public CustomResponse createNewUser(DtoInterface dtoInterface) {
        CustomResponse response;
        try {
            UserIdService userIdService = (UserIdService) crudService;
            userIdService.createNewUser((UserIdDto) dtoInterface);
            response = customResponseFactory.successfullResponse();
        } catch (Exception ex) {
            response = customResponseFactory.errorResponse(ex);
        }
        return response;
    }
}