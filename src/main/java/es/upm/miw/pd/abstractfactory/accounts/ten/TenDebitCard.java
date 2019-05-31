package es.upm.miw.pd.abstractfactory.accounts.ten;

import es.upm.miw.pd.abstractfactory.accounts.DebitCard;

public class TenDebitCard implements DebitCard {

    @Override
    public String view() {
        return "Tarjeta de Débito 10";
    }
}
