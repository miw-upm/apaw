package es.upm.miw.pd.abstractfactory.accounts.gold;

import es.upm.miw.pd.abstractfactory.accounts.Account;

public class GoldAccount implements Account {

    @Override
    public String view() {
        return "Cuenta Oro";
    }
}
