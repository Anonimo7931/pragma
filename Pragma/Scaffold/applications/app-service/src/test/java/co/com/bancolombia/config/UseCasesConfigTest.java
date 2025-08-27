package co.com.bancolombia.config;

import co.com.bancolombia.api.dto.CreateUserDTO;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import co.com.bancolombia.usecase.user.UserUseCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@WebFluxTest(UserUseCase.class)
public class UseCasesConfigTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void createUser(){
        CreateUserDTO user = new CreateUserDTO(
            "camilo", "munoz", new Date(), "diagonal 65", "+57 316", "camilo", new BigDecimal("150000000")
        );

        webTestClient
                .post()
                .uri("/api/user").body(Mono.just(user), User.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }
}