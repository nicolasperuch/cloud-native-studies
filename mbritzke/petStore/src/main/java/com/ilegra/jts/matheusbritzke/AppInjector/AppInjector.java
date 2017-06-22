package com.ilegra.jts.matheusbritzke.AppInjector;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.ilegra.jts.matheusbritzke.AvailableServices.*;
import com.ilegra.jts.matheusbritzke.PetStore.ServicesPet;
import com.ilegra.jts.matheusbritzke.PetStore.SimpleStore;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {

        MapBinder<Integer, AvailableServices> mapBinder = MapBinder.newMapBinder(binder(), Integer.class, AvailableServices.class);
        mapBinder.addBinding(1).to(BathDry.class);
        mapBinder.addBinding(2).to(BathDryPerfume.class);
        mapBinder.addBinding(3).to(BathWater.class);
        mapBinder.addBinding(4).to(BathWaterPerfume.class);
        mapBinder.addBinding(5).to(LongHairCut.class);
        mapBinder.addBinding(6).to(ShortHairCut.class);

        bind(ServicesPet.class).to(SimpleStore.class);
    }
}
