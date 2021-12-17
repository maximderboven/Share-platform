package persistence;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.gereedschap.GereedschapsType;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapFactory {
    private static GereedschapFactory instance;
    private Cataloog<? extends Number, Gereedschap> cataloog;

    public static GereedschapFactory getInstance() {
        return instance;
    }

    public GereedschapFactory(Cataloog<? extends Number, Gereedschap> cataloog) {
        synchronized (instance){
            if(instance != null)
                return;
            instance = this;
        }
        this.cataloog = cataloog;
    }

    public Cataloog<? extends Number, Gereedschap> getCataloog(){
        return cataloog;
    }
}
