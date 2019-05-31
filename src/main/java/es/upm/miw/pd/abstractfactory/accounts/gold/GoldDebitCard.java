package es.upm.miw.pd.abstractfactory.accounts.gold;

import es.upm.miw.pd.abstractfactory.accounts.DebitCard;

public class GoldDebitCard implements DebitCard {

    @Override
    public String view() {
        return "Tarjeta de Debito Oro ";
    }
}
