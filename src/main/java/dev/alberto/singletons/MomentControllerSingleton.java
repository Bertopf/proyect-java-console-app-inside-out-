package dev.alberto.singletons;

import dev.alberto.controllers.MomentController;


public class MomentControllerSingleton {
    private static MomentController instance;
    private MomentControllerSingleton() {}
    public static MomentController getInstance() {
        if (instance == null) {
            instance = new MomentController();
        }
        return instance;
    }
}








