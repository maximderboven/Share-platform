package persistence;

import domein.transactie.Transactie;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
    public boolean remove(int id) {
        return transactieSet.removeIf(t -> t.id == id);
    }

    @Override
    public List<Transactie> getAll() {
        return null;
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
