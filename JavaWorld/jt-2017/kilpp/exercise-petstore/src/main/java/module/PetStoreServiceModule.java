package module;

import com.google.inject.AbstractModule;
import model.PetStore;
import model.PetStoreService;

public class PetStoreServiceModule extends AbstractModule {
    @Override
    public void configure() {
        bind(PetStore.class).to(PetStoreService.class);
    }
}
