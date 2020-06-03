package ClasseInverseeTest.Classe;

import Exceptions.UnauthorizedOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompteTest {


    @Test
    public void testRetirer_HugeAmount(){
        CompteCl compteTest = null;
        try {
            // SetUp
            compteTest = new CompteCl("BeXXXX", 1200, 0, true);
            //Exercise

            // Verify
            CompteCl finalCompteTest = compteTest;
            // Si l'assertion n'est pas vérifiée, cela montre qu'il y a un problème avec la méthode et qu'elle ne
            // respecte pas sa spécification
            Assertions.assertThrows(UnauthorizedOperation.class, () -> {finalCompteTest.retirer(Integer.MAX_VALUE);});
        }
        finally {
            // Teardown
            compteTest = null;
        }
    }

}