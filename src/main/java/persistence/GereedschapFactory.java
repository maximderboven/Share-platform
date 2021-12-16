package persistence;

import domein.gereedschap.Gereedschap;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapFactory {
    private static GereedschapFactory instance;
    private static GereedschapCataloog cataloog;

    public static GereedschapFactory getInstance() {
        return instance;
    }

    public GereedschapFactory() {
        synchronized (instance){
            if(instance != null)
                return;
            instance = this;
        }
        cataloog = new InMemoryGereedschapsCataloog();
    }

    public static GereedschapCataloog getCataloog(){
        return cataloog;
    }
}
