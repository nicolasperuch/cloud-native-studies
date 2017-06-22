import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jt.petshop.PetShop;
import org.junit.Before;

public class HomeTest {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(PetShop.class).to(MockPetShop.class);
            }
        });
    }
}
