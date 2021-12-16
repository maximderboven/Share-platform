package persistence;

import domein.gereedschap.Gereedschap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public boolean remove (int id) {
        return gereedschapSet.removeIf (t -> t.id == id);
    }

    @Override
    public List<Gereedschap> getAll() {
        return new ArrayList<Gereedschap>(gereedschapSet);
    }
}
