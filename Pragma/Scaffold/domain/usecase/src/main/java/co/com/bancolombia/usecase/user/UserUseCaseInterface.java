package co.com.bancolombia.usecase.user;

import co.com.bancolombia.model.user.User;

import java.util.List;

public interface UserUseCaseInterface {
        void saveUser(User user);

        List<User> getAllUsers();

        User getUserByIdNumber(Long idNumber);

        User editUser(User user);

        void deleteUser(Long idNumber);
}
