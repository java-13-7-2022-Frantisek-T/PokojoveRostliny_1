
//    ZÁSADNÍ PROBLÉM - JAK ZACHYTIT A SPÍŠE PŘEDEJÍT SITUACI, KDY plantList == null
//    "kvetiny-spatne-datum.txt" --- PROBLÉMEM JE TO, ŽE SE BĚH PROGRAMU ZASEKNE DOKUD MANUÁLNĚ NESHODÍM BĚH PROCEDURY 'Stop Main'

import java.time.LocalDate;
import java.util.ListIterator;

public class Main {

//    public static final String FILENAME = "kvetiny-spatne-frekvence.txt";
//    public static final String FILENAME = "kvetiny-spatne-datum.txt";
      public static final String FILENAME = "kvetiny.txt";

    public static void main(String[] args) {


        System.out.println("************************( S T A R T )************************");
        // Načteme obsah textového souboru (včetně ošetření vzniku možných chyb
        PlantList plantList = null;
        try {
            plantList = PlantList.importFromFile(FILENAME);
        } catch (PlantException e) {
            System.err.println("Soubor " + FILENAME + " se nepodařiol správně načíst !\n" + e.getLocalizedMessage());
        }
        System.out.println("************************( KONEC NAČÍTÁNÍ DAT Z TEXTOVÉHO SOUBORU )************************");

        // Ke zkoušení zadávání datumů a frekvence zálivky v nesmyslných hodnotách
        try {
            if (plantList == null) {
                System.err.println("************************( Kolekce není vytvořena )************************");

            } else {
                Plant plant_4 = new Plant("První květina", "Poznámka", LocalDate.parse("2022-08-01"), LocalDate.parse("2022-08-03"), 1);
                Plant plant_3 = new Plant("Druhá květina", LocalDate.parse("2022-08-18"), 2);
                Plant plant_1 = new Plant("Třetí květina");
                Plant plant_0 = new Plant("");  // CO S TÍM? teoreticky může být prázdný řetězec správné, logoicky nesmysl
                // Přidání několika objektů do kolekce
                plantList.addPlant(plant_4);
                plantList.addPlant(plant_3);
                plantList.addPlant(plant_1);
                plantList.addPlant(plant_0);
            }
        }
        // Ošetření vyhozených vyjímek které mohly vzniknout v předchozím bloku programového kódu
        // Použil jsem vlastní třídu výjímek
        // Uznávám že popis "Chyby !" není nic moc ....
        catch (PlantException e) {
            System.err.println("Chyby !! " + e.getLocalizedMessage());
        } catch (NullPointerException e) {
            System.err.println("Chyby !!!!! " + e.getLocalizedMessage());
        }

        if (plantList == null) {
            System.err.println("************************( Kolekce není vytvořena )************************");

        } else {
            for (Plant plant : plantList.getList()) {
                System.out.println(plant.getName() + " " +
                        plant.getNotes() + " " +
                        plant.getPlanted() + " " +
                        plant.getFrequencyOfWatering() + " " +
                        plant.getWatering()
                );
            }
            System.out.println("************************( VYPSÁNA ROZŠÍŘENÁ KOLEKCE KVĚTIN )************************");
        }

        if (plantList == null) {
            System.err.println("************************( Kolekce není vytvořena )************************");

        } else {
            // Ke zkoušení rušení prvku kolekce (toho posledního bez názvu)
            try {
                int i = plantList.rangeOfPlanList() - 1;
                plantList.removePlant(plantList.getPlantFromIndex(i));
            }
            // Ošetření vyhozených vyjímek které mohly vzniknout v předchozím bloku programového kódu
            // Použil jsem vlastní třídu výjímek
            catch (PlantException e) {
                System.err.println("Chyby! " + e.getLocalizedMessage());
            }
        }

        if (plantList == null) {
            System.err.println("************************( Kolekce není vytvořena )************************");

        } else {
            for (Plant plant : plantList.getList()) {
                System.out.println(plant.getName() + " " +
                        plant.getNotes() + " " +
                        plant.getPlanted() + " " +
                        plant.getFrequencyOfWatering() + " " +
                        plant.getWatering()
                );
            }
            System.out.println("************************( VYPSÁNA KOLEKCE KVĚTIN PO SMAZÁNÍ POSLEDNÍHHO PRVKU KOLEKCE )************************");
        }

        if (plantList == null) {
            System.err.println("************************( Kolekce není vytvořena )************************");

        } else {
            // Ke zkoušení zadávání indexu mimo rozsah pole
            // Pomocná proměnná
            Plant plant = new Plant("");
            try {
                // Pomocná proměnná
                // index prvku, který chci z kolekce přečíst (a vypsat na monitor)
                int i = 2;
                plant = plantList.getPlantFromIndex(i);
                System.out.println("Index prvku: " + i + " Popis prvku: " +
                        plant.getName() + " " +
                        plant.getNotes() + " " +
                        plant.getPlanted() + " " +
                        plant.getFrequencyOfWatering() + " " +
                        plant.getWatering()
                );

            } catch (PlantException e) {
                System.err.println("Prvek pole se nepodařilo načíst! \n" + e.getLocalizedMessage());
            }
            System.out.println("************************( VYPSÁNÍ JEDNOHO PRVKU KOLEKCE KVĚTIN )************************");
        }

        if (plantList == null) {
            System.err.println("************************( Kolekce není vytvořena )************************");

        } else {
            // KOSTRBATÉ PROVEDENÍ V CYKLU WHILE
            // Pomocná proměnná pro počítadlo v cyklus while
            int i = 0;
            // Pomocná proměnná
            Plant plant = new Plant("");
            // Výpis listu květin s číslem indexu a datem doporučené zálivky
            while (i < plantList.rangeOfPlanList()) {
                try {
                    plant = plantList.getPlantFromIndex(i);
                    System.out.println(i + 1 + " " + plant.getWateringInfo(plant));
                } catch (PlantException e) {
                    System.err.println("Prvek pole se nepodařilo načíst! \n" + e.getLocalizedMessage());
                } finally {
                    // Zvyšování počitadla průchodů v cyklu o 1
                    // Sice v případě výjimky by se mělo z cyklu vyskočit ale raději volím tuto cestu jak se nezacyklit
                    i++;
                }
            }
            System.out.println("************************( VYPSÁNÍ DOPORUČENÉHO DATA DALŠÍ ZÁLIVKY - while )************************");

            // SNAD O NĚCO ZAJÍMAVĚJŠÍ PROVEDENÍ PŘES ListIteraror
            for (ListIterator<Plant> it = plantList.getList().listIterator(); it.hasNext(); ) {
                Plant plant2 = it.next();
                System.out.println(" " + plant2.getWateringInfo(plant2));
            }
            System.out.println("************************( VYPSÁNÍ DOPORUČENÉHO DATA DALŠÍ ZÁLIVKY - ListIterator )************************");

            // SNAD ELEGANTNĚJŠÍ PROVEDENÍ PŘES CYKLUS FOREACH
            for (Plant plant2 : plantList.getList()) {
                System.out.println(" - " + plant2.getWateringInfo(plant2));
            }
            System.out.println("************************( VYPSÁNÍ DOPORUČENÉHO DATA DALŠÍ ZÁLIVKY - foreach )************************");
        }
    }
}