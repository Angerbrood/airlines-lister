package edu.elte.airlines.dao.interfaces;

import edu.elte.airlines.domain.UserId;

public interface UserIdDao extends CrudDao<UserId, Integer> {
    UserId findUserIdByUsername(String username);
}
