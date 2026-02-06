# Generelt
Sjølve javaprosjektet finnes under mappa Oblig1

MERK! Det er denne mappa som skal importeres inn i IDE
ikkje heile repositoriet.

Databasen bruker v4 av sql-fila.

Programmet kjøres frå Main.java 

Tester legges under `test` source-mappa.

## Ikkje implementert enno:
- Definer ein fyrste runde som starter spillet. 
Kvar påfølgende runde sjekkes det kva rute ein spiller står på og er dette startruta, 
flyttes spilleren kun om den har trillet ein verdi som er 6 (eller høgare). 
Står spilleren ikkje på startruta fortsetter spillet sin vanlige gang.
  
- Brettet flytter brikken og ikkje spilleren. 
Dette gjør at plasseringen til brikkene kan lagres i ein database.
Brettet har også informasjon om kor start, mål, slanger og stiger er 
og kan derfor lett gjøre spørringer mot desse.

## Ting som må fikses:
### TEKST:
* Tekst for kva spiller triller  
_(kan gjøres ved ein funksjon som tar inn sum før denne endres og rekonstruerer kvart trill fyrst `sum/6` (antall ganger trillet seks) så `sum%6` for siste trill)_

> _Spesialtekst viss fengsel_
> * trillet ut av fengsel

### TEST:
* Brett må testes
	- gyldigRute
	- finnRute (begge typer)
