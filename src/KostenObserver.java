import java.util.Map;

public class KostenObserver implements Observer {
    @Override
    public void update(Map<String, Double> kostenMap) {
        System.out.println("De kosten zijn geüpdatet:");
        for (Map.Entry<String, Double> entry : kostenMap.entrySet()) {
            System.out.println(entry.getKey() + ": €" + entry.getValue());
        }
        System.out.println();
    }
}
