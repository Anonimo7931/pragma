package co.com.bancolombia.api.dto;

import java.math.BigDecimal;
import java.util.Date;

public record CreateUserDTO(
        String name,
        String lastname,
        Date birthdate,
        String address,
        String phone,
        String email,
        BigDecimal salary) {

}
