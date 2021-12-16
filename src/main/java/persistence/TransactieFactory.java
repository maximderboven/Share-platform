package persistence;

import domein.transactie.Transactie;

/**
 * Arne Cools
 * 16/12/2021
 */
public class TransactieFactory {
    private static TransactieFactory instance;
    private static TransactieCataloog cataloog;

    private TransactieFactory() {
        synchronized (instance) {
            if (instance != null){
                return;
            }
            instance = this;
        }
        cataloog = new InMemoryTransactieCataloog();
    }

    public static TransactieFactory getInstance() {
        return instance;
    }

    public static TransactieCataloog getCataloog(){
        return cataloog;
    }
}
