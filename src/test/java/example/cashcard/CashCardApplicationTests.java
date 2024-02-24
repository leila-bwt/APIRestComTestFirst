package example.cashcard;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // iniciará nosso aplicativo Spring Boot e o disponibilizará para nosso teste realizar solicitações a ele.
class CashCardApplicationTests {
    @Autowired
    TestRestTemplate restTemplate; //Pedimos ao Spring para injetar um auxiliar de teste que nos permitirá fazer solicitações HTTP para o aplicativo em execução localmente.

    @Test
    void shouldReturnACashCardWhenDataIsSaved() {
        ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/99", String.class); // usamos restTemplate para fazer uma solicitação HTTP GET para o endpoint do nosso aplicativo '/cashcards/99'.
		// restTemplate retornará um ResponseEntity, que capturamos em uma variável que chamamos de response. ResponseEntity é outro objeto útil do Spring que fornece informações valiosas sobre o que aconteceu com nossa solicitação.

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK); // Podemos inspecionar muitos aspectos da resposta, incluindo o código de status da resposta HTTP, que esperamos ser '200 OK'.
    
        DocumentContext documentContext = JsonPath.parse(response.getBody()); //converte a resposta String em um objeto compatível com JSON com vários métodos auxiliares.
Number id = documentContext.read("$.id");
assertThat(id).isEqualTo(99); //quando solicitarmos um Cash Card com id 99, um objeto JSON sera retornado com algo no campo id.    
    }

    @Test
void shouldNotReturnACashCardWithAnUnknownId() {
  ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/1000", String.class);

  assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND); //esperamos um código de status de resposta HTTP semântico de 404 NOT_FOUND. Se solicitarmos um Cash Card que não existe, então esse Cash Card realmente "não foi encontrado".
  assertThat(response.getBody()).isBlank();
}
}
