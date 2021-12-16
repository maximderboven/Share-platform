package persistence;

import domein.transactie.Transactie;

import java.util.*;

/**
 * Arne Cools
 * 16/12/2021
 */
public class InMemoryTransactieCataloog implements TransactieCataloog {

    private Set<Transactie> transactieSet = new HashSet<>();

    @Override
    public int add(Transactie transactie) {
        transactieSet.add(transactie);
        return transactie.id;
    }

    @Override
    public Transactie get(int id) {
        return transactieSet.stream().filter(t -> id == t.getId()).findFirst().orElse(null);
    }

    @Override
    public boolean remove(int id) {
        return transactieSet.removeIf(t -> t.id == id);
    }

    @Override
    public List<Transactie> getAll() {
        return new ArrayList<>(transactieSet);
    }

    private static Random randomIDs = new Random ();

    @Override
    public int getNewId() {
        int id;
        do {
            id = randomIDs.nextInt();
            if (get(id) != null)
                id = -1;
        } while (id != -1);
        return id;
    }

}
