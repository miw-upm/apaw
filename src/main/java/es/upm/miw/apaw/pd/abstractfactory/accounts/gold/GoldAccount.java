package es.upm.miw.apaw.pd.abstractfactory.accounts.gold;

import es.upm.miw.apaw.pd.abstractfactory.accounts.Account;

public class GoldAccount implements Account {

    @Override
    public String view() {
        return "Cuenta Oro";
    }
}
