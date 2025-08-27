package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entity.UserEntity;
import co.com.bancolombia.jpa.exception.UserNotFoundException;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<User, UserEntity, Long, JPARepository>
 implements UserRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, User.class));
    }

    @Override
    public void saveUser(User user) {
        repository.save(toData(user));
    }

    @Override
    public List<User> getAllUsers() {
        return toList(repository.findAll());
    }

    @Override
    public User getUserByIdNumber(Long idNumber) {
        return toEntity(repository.findById(idNumber).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public User editUser(User user) {
        UserEntity saveUser = repository.findById(user.getId()).orElseThrow(UserNotFoundException::new);
        UserEntity editedUser = new UserEntity(saveUser.getName(), saveUser.getLastname(), saveUser.getPhone(),
                saveUser.getAddress(), saveUser.getEmail(), saveUser.getBirthdate(), saveUser.getSalary());

        return toEntity(repository.save(editedUser));
    }

    @Override
    public void deleteUser(Long idNumber) {

    }

    @Override
    public boolean existEmail(String email) {
        return repository.findByEmail(email).isPresent();
    }
}
