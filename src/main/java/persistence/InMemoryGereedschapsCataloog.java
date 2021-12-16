package persistence;

import domein.gereedschap.Gereedschap;

import java.util.*;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class InMemoryGereedschapsCataloog implements GereedschapCataloog {
    
    public Set<Gereedschap> gereedschapSet = new HashSet<> ();
    
    @Override
    public int add (Gereedschap gereedschap) {
        gereedschapSet.add (gereedschap);
        return gereedschap.getId ();
    }

    @Override
    public Gereedschap get(int id) {
        return gereedschapSet.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean remove (int id) {
        return gereedschapSet.removeIf (t -> t.id == id);
    }

    @Override
    public List<Gereedschap> getAll() {
        return new ArrayList<>(gereedschapSet);
    }

    private static Random randomIDs = new Random();

    @Override
    public int getNewId () {
        int id;
        do {
            id = randomIDs.nextInt ();
            if (get (id) != null)
                id = -1;
        } while (id != -1);
        return id;
    }
}
