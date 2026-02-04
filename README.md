# Generelt
Sjølve javaprosjektet finnes under mappa Oblig1

MERK! Det er denne mappa som skal importeres inn i IDE
ikkje heile repositoriet.

Databasen bruker v4 av sql-fila.

Programmet kjøres frå Main.java 

Tester legges under `test` source-mappa.

## Ikkje implementert enno:
- landetpaa  
	_metoden trengs ikkje før slanger/stiger er implementert_
- SpillBrett  
	_kan brukes om me vil flytte brikker gjennom spillbrettet.
	Må isåfall ha ny Stigespill konstruktør for denne implementasjonen._

## Ting som må fikses:
### TEKST:
* Tekst når spiller vinner.
* Tekst for kva spiller triller  
_(kan gjøres ved ein funksjon som tar inn sum før denne endres og rekonstruerer kvart trill fyrst `sum/6` (antall ganger trillet seks) så `sum%6` for siste trill)_

> _Spesialtekst viss fengsel_
> * havnet i fengsel
> * står i fengsel
> * trillet ut av fengsel

### KODE:
* Legge til Access på MappedSuperClass
	* DType
	* Brett
	* Rute
* Legge til tilhøyrande Access på entitetane
´´´
@Access(AccessType.FIELD)
´´´
### TEST:
* Brett må testes
	- gyldigRute
	- finnRute (begge typer)
