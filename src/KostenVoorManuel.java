import java.util.Scanner;

public class KostenVoorManuel {

    //Standaard constructor voor Manuel want dit zijn standaard kosten die je te zien krijgt asl ManuelGebruiker net zoals in oude project je ZZPKosten en BewustKosten hebt.
    public KostenVoorManuel(KostenController kostenController) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kosten door hoofdpijn van studenten: ");
        double hoofdpijn = scanner.nextDouble();
        kostenController.voegKostToe(new Kosten("Schadevergoeding voor tegen studenten", hoofdpijn));

        System.out.print("Kosten voor parkeren in Den Haag stad: ");
        double parkeerKosten = scanner.nextDouble();
        kostenController.voegKostToe(new Kosten("Parkeerkosten", parkeerKosten));

        System.out.print("Kosten voor koffie op HHS: ");
        double koffie = scanner.nextDouble();
        kostenController.voegKostToe(new Kosten("Koffie", koffie));

        System.out.print("Kosten voor de broodjes in de kantine: ");
        double broodjes = scanner.nextDouble();
        kostenController.voegKostToe(new Kosten("Broodjes", broodjes));


    }
}
