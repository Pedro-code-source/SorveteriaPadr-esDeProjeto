package ifpb.sorveteria.app;

import ifpb.sorveteria.facade.SorveteriaFacade;

public class Main {
    public static void main(String[] args) throws Exception {
        SorveteriaFacade sorveteriaFacade =  new SorveteriaFacade();
        sorveteriaFacade.iniciar();
    }
}
