import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EvidenceZakazniku evidence = new EvidenceZakazniku();

        evidence.pridatZakaznika(new Zakaznik("Karel Dvořák", 45));
        evidence.pridatZakaznika(new Zakaznik("Aleš Dvořáček", 26));
        evidence.pridatZakaznika(new Zakaznik("Josef Novák", 38));


        evidence.odebratPoslednihoZakaznika();

        evidence.ulozitDoSouboru("zakaznici.txt");

        evidence.nacistZeSouboru("zakaznici.txt");


        System.out.println("Výsledek:");
        for (Zakaznik zakaznik : evidence.getZakaznici()) {
            System.out.println(zakaznik.getJmeno() + ": " + zakaznik.getPocetProdeju());
        }
    }

}