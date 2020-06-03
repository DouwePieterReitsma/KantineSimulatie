# ITVP19DAV1A

Project KantineSimulatie SE/NSE

# Antwoorden op vragen:

## Week 1
Vraag 1b: Declaratie is het opstellen van een variabele. Initialisatie is het geven van een waarde aan een variabele.

## Week 2
Vraag 4a: aantalArtikelen(), hoeveelheidGeldInKassa() en resetKassa()

Vraag 5a: Het is goed om de methodes ArrayList<Artikel> getArrayList(String productnaam) en Artikel getArtikel(ArrayList<Artikel>) private te maken omdat ze alleen intern gebruikt worden en er al een publieke methode getArtikel bestaat die beide functies gebruikt om een artikel te returnen.

Vraag 5b: Een HashMap gebruik je als je aan de hand van een sleutel een waarde wilt kunnen opslaan met eventueel gedupliceerde waardes. Een HashSet gebruik je wanneer je unieke waardes (d.w.z. niet gedupliceerde) wilt opslaan.

Vraag 6a: In de constructor wordt:
* de kantine variabele geïnitialiseerd
* een array met een willekeurig aantal hoeveelheden voor de artikelen gegenereerd
* het kantineaanbod geïnitialiseerd met behulp van de gegeven artikelnamen, artikelprijzen en hoeveelheden.
* het kantineaanbod meegegeven aan de kantine

Vraag 6b: getRandomValue(int min, int max) returnt een willekeurig getal tussen min en max. Dit wordt gedaan door random.NextInt() aan te roepen met (max - min + 1) als input en vervolgens min er bij op te tellen. De +1 wordt gebruikt om het inclusief te maken. Dus getRandomValue(0, 10) returnt dus een getal tussen 0 en 10 met 0 en 10 inbegrepen (inclusief). Dus 0,1,2,3,4,5,6,7,8,9 of 10. Als de +1 niet zou worden gebruikt dan zou de functie 1,2,3,4,5,6,7,8 of 9 returnen. De + min op het eind van de functie wordt gebruikt voor de offset.

## Week 3
Vraag 2c: Als er geen constructor gedefiniëerd is in een klasse wordt er alsnog een constructor gegenereerd.

Vraag 2d: Beide functies maken geen gebruik van klasse-variabelen.

Vraag 2e: Door een private constructor aan te maken voorkom je dat er een instantie van de klasse kan worden gemaakt. Hierdoor kunnen de functies alleen vanuit statische context worden aangeroepen.

Vraag 2g: final zorgt er voor dat de variabele niet meer kan worden aangepast nadat deze geïnitialiseerd is.

Vraag 2h: De compiler vind dit niet leuk omdat je een instantievariabele van een klasse probeert aan te roepen terwijl deze klasse niet geïnitialiseerd is.

Vraag 2i: De variabele kan nu worden aangepast wat niet de bedoeling is aangezien het ter vervanging van een magic constant was geïntroduceerd.

Vraag 3b: super moet altijd bovenaan staan in een constructor omdat je een super-klasse altijd moet initialiseren voordat je de niet-statische methodes kunt gebruiken.

## Week 4
Vraag 1b: ![Sequentiediagram](/afbeeldingen/week4opdracht1b.png)

Vraag 1c: De instantievariabele saldo is protected gemaakt omdat je deze dan kunt gebruiken in de subklasses, maar niet kunt veranderen buiten de scope van de klasse om zoals bij een public variabele.

Vraag 3a: Nee dit kan niet omdat een interface alleen ongeïmplementeerde methodes bevat die geïmplementeerd moeten worden in een subklasse om te kunnen worden gebruikt.

Vraag 3b: Hetzelfde antwoord als hierboven, maar met als opmerking dat een abstracte klasse ook niet-abstracte methodes kan bevatten.

Vraag 3c: In java is multiple inheritance niet mogelijk omdat dit conflicten kan veroorzaken als er gelijknamige methodes zijn in meerdere klassen.

Vraag 3d: Een klasse kan meerdere interfaces implementeren, maar de compiler zal een foutmelding laten zien als er in twee of meerdere interfaces een methode is met één dezelfde naam en verschillende return types.

Vraag 3e: Ja, dat kan.

Vraag 3f: Elke methode in een interface is per definitie abstract, omdat een interface zelf geen methodes kan implementeren.

Vraag 3g: Ja, elke klasse met een abstracte functie moet als ```abstract``` worden gemarkeerd, omdat deze ongeïmplementeerde methodes bevat.

Vraag 3h: Het begrip polymorfisme houd in dat de interface van klassen gelijkvormig zijn, maar verschillende implementaties kunnen hebben.

Voorbeeld met abstracte klasses:

    public abstract Medewerker {
        public double bonus() { return 2000; }
    
        public abstract double getLoon();

    }
    
    public class Docent extends Medewerker {
        public double getLoon() { return 42 + bonus(); }
    }
    
    public class Directeur extends Medewerker {
        public double getLoon() { return 9001 + bonus(); }
    }
    
Voorbeeld met interfaces:

    public interface Medewerker {
        double getLoon();
    }
    
    public class Docent implements Medewerker {
        double getLoon() { return 42; }
    }
    
    public class Directeur implements Medewerker {
        double getLoon() { return 9001; }
    }

Vraag 4a: Dat kan en dat is logisch omdat een abstracte klasse, abstracte en niet-abstracte methodes kan bevatten, maar tegelijkertijd niet de eis stelt dat er minimaal één abstracte methode hoort te zijn.

Vraag 4b: Ja dat moet altijd tenzij de subklasse zelf als abstract wordt gedeclareerd.

Vraag 4c: Je kunt in de interface een default methode definiëren die aangeroepen wordt indien de desbetreffende methode niet geïmplementeerd is in de subklasse.

Voorbeeld:

    public interface Test {
        default String getText() { return "Hello World!"; }
    }     
    
Vraag 4d: Dat kan niet, omdat polymorfisme sowieso niet mogelijk is met klasse-variabelen.

Vraag 4e: Een ```final```-methode is de allerlaatste implementatie van een methode. Nadat een methode als ```final``` is gedeclareerd, kan deze niet meer worden overschreven. Hierdoor is het logisch dat een methode niet zowel ```final``` als ```abstract``` kan zijn.

## Week 5
1d: 
* ```@Id``` geeft aan dat de klasse-variabele correspondeert aan de unique identifier in de database.
* ```@GeneratedValue``` geeft aan dat de waarde van de variabele automatisch wordt gegenereerd. Bijvoorbeeld door autoincrementing.
* ```@Column``` specificeert aan welke kolom in de database de variabele correspondeert.

1e: student, student_telefoon, studie en telefoon

2a: omdat een student meerdere telefoons kan bezitten.

2b: 
* Bij ```telefoons``` wordt er een nieuwe koppeltabel gegenereerd in de database.
* Bij ```studies``` wordt er simpelweg voor elke student die ingeschreven staat bij een studie een record gegenereerd met daarin de studie en de ```student_id```.
    * Er is gekozen om ```@JoinTable``` niet te gebruiken hiervoor omdat dit voor een ... TODO
    
2c: In de database wordt deze relatie gerepresenteerd door een enkele tabel genaamd ```studie``` met daarin de studienaam en de ```student_id```

2d: De velden van```kaartNummer``` en ```vervalDatum``` van ```StudentKaart``` zijn in de database toegevoegd (embedded) aan de student-tabel.

Met ```@Embedded``` kun je de velden van een ```@Embeddable``` toevoegen aan de tabel van de klasse.

3a: Je zou in het geval van onvoldoende saldo het hele koopproces terug kunnen draaien.

## Week 6

4a: many-to-one, de annotatie hiervoor is: ```@ManyToOne```

4b: one-to-many, de annotatie hiervoor is ```@OneToMany```



