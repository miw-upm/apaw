package es.upm.miw.pd.abstractfactory.accounts.ten;

import es.upm.miw.pd.abstractfactory.accounts.CreditCard;

public class TenCreditCard implements CreditCard {

    @Override
    public String view() {
        return "Tarjeta de Crédito 10";
    }
}
