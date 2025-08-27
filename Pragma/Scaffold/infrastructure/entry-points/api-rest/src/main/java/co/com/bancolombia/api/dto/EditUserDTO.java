package co.com.bancolombia.api.dto;

public record EditUserDTO(String name,
                          String lastname,
                          Integer age,
                          Integer idType,
                          Long idNumber) {
}
