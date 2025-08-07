package es.upm.miw.apaw.pd.abstractfactory.accounts.ten;

import es.upm.miw.apaw.pd.abstractfactory.accounts.Account;

public class TenAccount implements Account {

    @Override
    public String view() {
        return "Cuenta 10";
    }
}
