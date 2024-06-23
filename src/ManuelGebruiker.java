import java.util.Map;
import java.util.Scanner;

public class ManuelGebruiker {
    private KostenController kostenController;

    public ManuelGebruiker() {
        kostenController = new KostenController();
        new KostenVoorManuel(kostenController);
        kostenController.addObserver(new KostenObserver());
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean doorgaan = true;
        while (doorgaan) {
            toonMenu();
            int keuze = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            verwerkOptie(keuze, scanner);
        }
    }

    private void toonMenu() {
        System.out.println("Menu:");
        System.out.println("1. Bekijk alle kosten");
        System.out.println("2. Wijzig een specifieke kost");
        System.out.println("3. Voeg een nieuwe kost toe");
        System.out.println("4. Update je kostenlijst");
        System.out.println("5. Afsluiten");
    }

    private void verwerkOptie(int keuze, Scanner scanner) {
        switch (keuze) {
            case 1:
                bekijkAlleKosten();
                break;
            case 2:
                wijzigSpecifiekeKost(scanner);
                break;
            case 3:
                voegNieuweKostToe(scanner);
                break;
            case 4:
                kostenController.notifyObservers();
                break;
            case 5:
                System.out.println("Programma afgesloten.");
                System.exit(0);
                break;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
    }

    private void bekijkAlleKosten() {
        System.out.println("Overzicht van alle kosten:");
        for (Map.Entry<String, Double> entry : kostenController.getKostenMap().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("--------------------------------------------------------------");
    }

    private void wijzigSpecifiekeKost(Scanner scanner) {
        Map<String, Double> kostenMap = kostenController.getKostenMap();

        System.out.print("Voer de naam van de kost in die u wilt wijzigen,\nLET OP: hoofdlettergevoelig\nVul hier in: ");
        String naam = scanner.nextLine();
        System.out.print("Voer het nieuwe bedrag in: ");
        double nieuwBedrag = scanner.nextDouble();
        kostenController.wijzigKost(naam, nieuwBedrag);
        System.out.println("Kost gewijzigd.");
    }

    private void voegNieuweKostToe(Scanner scanner) {
        System.out.print("Voer de naam van de nieuwe kost in: ");
        String naam = scanner.nextLine();
        System.out.print("Voer het bedrag in: ");
        double bedrag = scanner.nextDouble();
        kostenController.voegKostToe(new Kosten(naam, bedrag));
        System.out.println("Nieuwe kost toegevoegd.");
    }
}
