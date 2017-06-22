
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jts.spring.modelo.ListaPet;
import com.ilegra.jts.spring.modelo.ListaServico;
import com.ilegra.jts.spring.modelo.ServicoPet;
import com.ilegra.jts.spring.modulo.PetServiceModulo;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by adriel on 05/06/17.
 */
public class PetsStoreTest {
   ServicoPet servicoPet = new ServicoPet(new ListaPet(), new ListaServico());

    @Test
    public void addTest() {
        Assert.assertTrue(servicoPet.addPet(1, "Phil", "Labrador", 10));

    }

   @Test
    public void removeTest() {
       Assert.assertFalse(servicoPet.removePet(1));
       servicoPet.addPet(1, "Phil", "Labrador", 10);
        Assert.assertTrue(servicoPet.removePet(1));
    }

    @Test
    public void pesquisaPorIdadeTest() {
        Assert.assertFalse(servicoPet.pesquisaPorIdade(10));
        servicoPet.addPet(1, "Phil", "Labrador", 10);
        Assert.assertTrue(servicoPet.pesquisaPorIdade(10));
    }

    @Test
    public void addBanhotest(){
        Assert.assertFalse(servicoPet.addBanho(1,false, true, true));
        servicoPet.addPet(1, "Phil", "Labrador", 10);
        Assert.assertTrue(servicoPet.addBanho(1,false, true, true));
    }

    @Test
    public void addCortetest(){
        servicoPet.addPet(2, "Marco", "Cusco", 9);
        Assert.assertTrue(servicoPet.addCorte(2, true, false));
    }


}
