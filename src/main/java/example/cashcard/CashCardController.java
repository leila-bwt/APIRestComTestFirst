package example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // informa ao Spring que esta classe é um componente do tipo RestController e capaz de lidar com solicitações HTTP.
@RequestMapping("/cashcards") // é um complemento do @RestController que indica qual endereço as solicitações devem ter para acessar este Controller.
public class CashCardController {
    @GetMapping("/{requestedId}") //marca um método como um método manipulador. Solicitações GET que correspondam a cashcards/{requestedID} serão tratadas por este método.
    private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {// @PathVariable informa o Spring Web sobre o requestId fornecido na solicitação HTTP.
        if (requestedId.equals(99L)) {
            CashCard cashCard = new CashCard(99L, 123.45);
            return ResponseEntity.ok(cashCard);
        } else {
            return ResponseEntity.notFound().build();
//Atualizado o método manipulador para retornar uma resposta vazia com status NOT_FOUND, a menos que o requestId seja 99.
        }    
    }
}
