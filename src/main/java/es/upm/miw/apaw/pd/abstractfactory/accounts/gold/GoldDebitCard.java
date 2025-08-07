package es.upm.miw.apaw.pd.abstractfactory.accounts.gold;

import es.upm.miw.apaw.pd.abstractfactory.accounts.DebitCard;

public class GoldDebitCard implements DebitCard {

    @Override
    public String view() {
        return "Tarjeta de Debito Oro ";
    }
}
