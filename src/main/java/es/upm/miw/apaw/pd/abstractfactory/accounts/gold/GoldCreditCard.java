package es.upm.miw.apaw.pd.abstractfactory.accounts.gold;

import es.upm.miw.apaw.pd.abstractfactory.accounts.CreditCard;

public class GoldCreditCard implements CreditCard {

    @Override
    public String view() {
        return "Tarjeta de Crédito Oro";
    }
}
