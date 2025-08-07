package es.upm.miw.apaw.pd.abstractfactory.accounts.gold;

import es.upm.miw.apaw.pd.abstractfactory.accounts.Account;
import es.upm.miw.apaw.pd.abstractfactory.accounts.AccountFactory;
import es.upm.miw.apaw.pd.abstractfactory.accounts.CreditCard;
import es.upm.miw.apaw.pd.abstractfactory.accounts.DebitCard;

public class GoldAccountFactory extends AccountFactory {

    private Account account = null;

    private DebitCard debitCard = null;

    private CreditCard creditCard = null;

    @Override
    public Account getAccount() {
        if (this.account == null) {
            this.account = new GoldAccount();
        }
        return this.account;
    }

    @Override
    public DebitCard getDebitCard() {
        if (this.debitCard == null) {
            this.debitCard = new GoldDebitCard();
        }
        return this.debitCard;
    }

    @Override
    public CreditCard getCreditCard() {
        if (this.creditCard == null) {
            this.creditCard = new GoldCreditCard();
        }
        return this.creditCard;
    }
}
