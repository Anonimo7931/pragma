package co.com.bancolombia.usecase.user;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;

    public void saveUser(User user){
        String _name = user.getName();
        String _lastname = user.getLastname();
        String _email = user.getEmail();
        BigDecimal _salary = user.getSalary();

        BigDecimal max = new BigDecimal("15000000");

        Pattern patternEmail = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        if(_name == null || _name.trim().isEmpty()){
            throw new IllegalArgumentException("El campo nombre no puede ser vacio");
        }

        if(_lastname == null || _lastname.trim().isEmpty()){
            throw new IllegalArgumentException("El campo apellido no puede ser vacio");
        }

        if(_email == null || _email.trim().isEmpty()){
            throw new IllegalArgumentException("El campo correo no puede ser vacio");
        }

        if(userRepository.existEmail(_email)){
            throw new IllegalArgumentException("El campo email ya existe");
        }

        if(!patternEmail.matcher(_email).matches()){
            throw new IllegalArgumentException("El campo correo no es valido");
        }

        if(_salary.compareTo(BigDecimal.ZERO) < 0 || _salary.compareTo(max) > 0){
            throw new IllegalArgumentException("El salario debe estar entre 0 y 15000000");
        }

        userRepository.saveUser(user);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public User getUserByIdNumber(Long idNumber){
        return userRepository.getUserByIdNumber(idNumber);
    }

    public User editUser(User user){
        return userRepository.editUser(user);
    }

    public void deleteUser(Long idNumber){
        userRepository.deleteUser(idNumber);
    }
}
