package co.com.bancolombia.api.dto;

public record UserDTO(String name,
        String lastname,
        Integer age,
        Integer idType,
        Long idNumber) {
}
