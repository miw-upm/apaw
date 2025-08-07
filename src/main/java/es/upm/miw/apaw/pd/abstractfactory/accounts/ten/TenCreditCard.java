package es.upm.miw.apaw.pd.abstractfactory.accounts.ten;

import es.upm.miw.apaw.pd.abstractfactory.accounts.CreditCard;

public class TenCreditCard implements CreditCard {

    @Override
    public String view() {
        return "Tarjeta de Crédito 10";
    }
}
