package es.upm.miw.pd.abstractfactory.accounts.ten;

import es.upm.miw.pd.abstractfactory.accounts.Account;

public class TenAccount implements Account {

    @Override
    public String view() {
        return "Cuenta 10";
    }
}
