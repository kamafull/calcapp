package rest.service;

import rest.model.User;

import java.util.List;

/**
 * Service interface for class {@link User}.
 */

public interface UserService {

    User register(User user);

    List<User> getAll();

    void save(User user);

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
