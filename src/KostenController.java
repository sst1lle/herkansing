import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class KostenController {
    private Map<String, Kosten> kostenMap;
    private List<Observer> observers;

    public KostenController() {
        kostenMap = new HashMap<>();
        observers = new ArrayList<>();
    }

    public void voegKostToe(Kosten kost) {
        kostenMap.put(kost.getNaam(), kost);
        notifyObservers();
    }

    public void wijzigKost(String naam, double nieuweKost) {
        if (kostenMap.containsKey(naam)) {
            kostenMap.get(naam).setKost(nieuweKost);
            notifyObservers();
        } else {
            System.out.println("Kost met naam " + naam + " bestaat niet.");
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(getKostenMap());
        }
    }

    public Map<String, Double> getKostenMap() {
        Map<String, Double> map = new HashMap<>();
        for (Map.Entry<String, Kosten> entry : kostenMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue().getKost());
        }
        return map;
    }
}
