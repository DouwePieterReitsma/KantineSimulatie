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
