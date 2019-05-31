package es.upm.miw.pd.abstractfactory.accounts.young;

import es.upm.miw.pd.abstractfactory.accounts.DebitCard;

public class YoungDebitCard implements DebitCard {

    @Override
    public String view() {
        return "Tarjeta de Débito Joven";
    }
}
