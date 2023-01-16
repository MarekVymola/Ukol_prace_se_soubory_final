import java.io.*;
import java.util.ArrayList;
import java.util.List;

class EvidenceZakazniku {
    private List<Zakaznik> zakaznici;

    public EvidenceZakazniku() {
        zakaznici = new ArrayList<Zakaznik>();
    }

    public void pridatZakaznika(Zakaznik zakaznik) {
        zakaznici.add(zakaznik);
    }

    public void odebratZakaznika(Zakaznik zakaznik) {
        zakaznici.remove(zakaznik);
    }

    public void odebratPoslednihoZakaznika() {
        if (!zakaznici.isEmpty()) {
            zakaznici.remove(zakaznici.size() - 1);
        }
    }

    public List<Zakaznik> getZakaznici() {
        return zakaznici;
    }

    public void ulozitDoSouboru(String soubor) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(soubor))) {
            for (Zakaznik zakaznik : zakaznici) {
                writer.write(zakaznik.getJmeno() + ":" + zakaznik.getPocetProdeju());
                writer.newLine();
            }
        }catch (Exception e) {
            System.out.println("Chyba při zápisu");
        }
    }

    public void nacistZeSouboru(String soubor) throws IOException {
        zakaznici.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(soubor))) {
            String radek;
            while ((radek = reader.readLine()) != null) {
                String[] parts = radek.split(":");
                if (parts.length == 2) {
                    zakaznici.add(new Zakaznik(parts[0], Integer.parseInt(parts[1])));
                }
            }
        }catch (IOException e) {
            System.out.println("Soubor nenalezen");
        }
    }
}
