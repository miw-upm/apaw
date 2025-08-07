package es.upm.miw.apaw.pd.abstractfactory.accounts.young;

import es.upm.miw.apaw.pd.abstractfactory.accounts.CreditCard;

public class YoungCreditCard implements CreditCard {

    @Override
    public String view() {
        return "Tarjeta de Crédito Joven";
    }
}
