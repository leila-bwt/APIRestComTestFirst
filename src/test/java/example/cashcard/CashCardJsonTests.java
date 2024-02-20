package example.cashcard;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CashCardJsonTest {

   @Test
   void myFirstTest() {
      assertThat(1).isEqualTo(42);
   }
}

//A anotação @Test faz parte da biblioteca JUnit e o método assertThat faz parte da biblioteca AssertJ. Ambas as bibliotecas são importadas após a instrução package.

//É importante ter um teste com falha primeiro para que você possa ter alta confiança de que tudo o que você fez para corrigir o teste realmente funcionou.

//Nesse caso,o teste 'myFisrtTest' falhou, enquanto o CashCardsApplicationTest existente da lição anterior foi bem-sucedido.Você já esperava isso, pois o número 1 não é igual ao número 42. Linha 10

//Para "consertar" o teste, você pode afirmar uma afirmação que sabe ser verdadeira: assertThat(42).isEqualTo(42);
