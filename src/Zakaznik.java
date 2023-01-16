class Zakaznik {
    private String jmeno;
    private int pocetProdeju;

    public Zakaznik(String jmeno, int pocetProdeju) {
        this.jmeno = jmeno;
        this.pocetProdeju = pocetProdeju;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getPocetProdeju() {
        return pocetProdeju;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPocetProdeju(int pocetProdeju) {
        this.pocetProdeju = pocetProdeju;
    }

    public void zvysPocetProdeju(int hodnota) throws Exception {
        if (hodnota <= 0) {
            throw new Exception("Hodnota musí být kladná!");
        }
        this.pocetProdeju += hodnota;
    }
}

