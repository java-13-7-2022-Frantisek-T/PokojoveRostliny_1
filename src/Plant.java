import java.time.LocalDate;


        /*
        Připravte třídu pro ukládání informací o pokojových rostlinách (plant).
        U každé rostliny budeme mít uložen:
        název (name),
        poznámky (notes),
        datum, kdy byly zasazena (planted),
        datum poslední zálivky (watering)
        běžnou frekvenci zálivky ve dnech (frequency of watering)
        Vytvořte tři konstruktory:
        jeden pro nastavení všech atributů
        druhý nastaví jako poznámku prázdný řetězec a datum poslední zálivky nastaví na dnešní datum.
        třetí nastaví totéž co druhý a navíc výchozí frekvenci zálivky na 7 dnů a datum zasazení na dnešní datum. (Uživatel tedy bude zadávat pouze název rostliny.)
        Vytvořte výchozí přístupové metody pro všechny atributy.
        Připravte metodu getWateringInfo(), která vrátí název květiny, datum poslední zálivky a datum doporučené další zálivky. (Metoda vrátí textový řetězec, obsahující požadované informace.)
        */


public class Plant {

    // Atributy
    String      name;                   // název rostliny
    String      notes;                  // poznámky
    LocalDate   planted;                // datum kdy byla zasazena
    LocalDate   watering;               // datum poslední zálivky
    int         frequencyOfWatering;    // běžnou frekvenci zálivky

    // Konstruktor pro nastavení všech atributů
    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    // Konstruktor který provede nastavení poznámky jako prázdný řetězec a datum poslední zálivky nastaví na dnešní datum
    public Plant(String name, LocalDate planted, int frequencyOfWatering) {
        this.name = name;
        this.notes = "";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;
    }

    // Konstruktor který provede nastavení poznámky jako prázdný řetězec a datum poslední zálivky nastaví na dnešní datum
    // a výchozí frekvenci zálivky NASTAVÍ na 7 dnů a datum zasazení nastaví na dnešní datum.
    // (Uživatel tedy bude zadávat pouze název rostliny.)
    public Plant(String name) {
        this.name = name;
        this.notes = "";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
    }

    // Výchozí přístupová metoda pro předání atributu name.
    public String getName() {
        return name;
    }

    // Výchozí přístupová metoda pro nastavení atributu name.
    public void setName(String name) {
        this.name = name;
    }

    // Výchozí přístupová metoda pro předání atributu notes.
    public String getNotes() {
        return notes;
    }

    // Výchozí přístupová metoda pro nastavení atributu notes
    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Výchozí přístupová metoda pro předání atributu planted.
    public LocalDate getPlanted() {
        return planted;
    }

    // Výchozí přístupová metoda pro nastavení atributu planted.
    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    // Výchozí přístupová metoda pro předání atributu watering.
    public LocalDate getWatering() {
        return watering;
    }

    // Výchozí přístupová metoda pro nastavení atributu watering.
    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    // Výchozí přístupová metoda pro předání atributu frekvencyOfWatering.
    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    // Výchozí přístupová metoda pro nastavení atributu frekvencyOfWatering.
    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    // Metoda getWateringInfo(), která vrátí název květiny, datum poslední zálivky a datum doporučené další zálivky.
    // (Metoda vrátí textový řetězec, obsahující požadované informace.)
    public String getWateringInfo( Plant plant){

        String      nameOfPlant     =   this.getName();
        LocalDate   lastWatering    =   this.getWatering();
        LocalDate   nextWatering    =   this.getWatering().plusDays(this.getFrequencyOfWatering());

        return  nameOfPlant + " " + lastWatering.toString() + " " + nextWatering.toString();

    }
}
