package es.upm.miw.apaw.pd.abstractfactory.accounts.young;

import es.upm.miw.apaw.pd.abstractfactory.accounts.Account;

public class YoungAccount implements Account {

    @Override
    public String view() {
        return "Cuenta Joven";
    }
}
