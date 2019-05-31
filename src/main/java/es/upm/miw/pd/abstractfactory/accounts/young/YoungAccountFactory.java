package es.upm.miw.pd.abstractfactory.accounts.young;

import es.upm.miw.pd.abstractfactory.accounts.Account;
import es.upm.miw.pd.abstractfactory.accounts.AccountFactory;
import es.upm.miw.pd.abstractfactory.accounts.CreditCard;
import es.upm.miw.pd.abstractfactory.accounts.DebitCard;

public class YoungAccountFactory extends AccountFactory {

    private Account account = null;

    private DebitCard debitCard = null;

    private CreditCard creditCard = null;

    @Override
    public Account getAccount() {
        if (this.account == null) {
            this.account = new YoungAccount();
        }
        return this.account;
    }

    @Override
    public DebitCard getDebitCard() {
        if (this.debitCard == null) {
            this.debitCard = new YoungDebitCard();
        }
        return this.debitCard;
    }

    @Override
    public CreditCard getCreditCard() {
        if (this.creditCard == null) {
            this.creditCard = new YoungCreditCard();
        }
        return this.creditCard;
    }

}
