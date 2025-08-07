package es.upm.miw.apaw.pd.abstractfactory.accounts.ten;

import es.upm.miw.apaw.pd.abstractfactory.accounts.DebitCard;

public class TenDebitCard implements DebitCard {

    @Override
    public String view() {
        return "Tarjeta de Débito 10";
    }
}
