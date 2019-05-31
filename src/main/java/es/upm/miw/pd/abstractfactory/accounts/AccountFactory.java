package es.upm.miw.pd.abstractfactory.accounts;

public abstract class AccountFactory {

    private static AccountFactory factory;

    public static AccountFactory getFactory() {
        return AccountFactory.factory;
    }

    public static void setFactory(AccountFactory factory) {
        AccountFactory.factory = factory;
    }

    public abstract Account getAccount();

    public abstract DebitCard getDebitCard();

    public abstract CreditCard getCreditCard();
}
