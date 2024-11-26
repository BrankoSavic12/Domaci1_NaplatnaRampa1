# Domaci1_NaplatnaRampa1

Napisati na jeziku Java sledeći paket tipova (greške prijavljivati izuzecima
opremljenim tekstovima poruka):
Kategorizovano je nešto čemu se može dohvatiti celobrojna kategorija.
Kategorizovano vozilo ima zadatu kategoriju.
Cenovnik sadrži niz celobrojnih putarina po kategorijama vozila. Stvara se
popunjenim nizom putarina. Može da se dohvati broj kategorija i da se dohvati
putarina za datu kategoriju vozila. Greška je ako takva kategorija ne postoji.
Naplatna stanica ima jedinstven, automatski generisan celobrojan identifikator i
cenovnik. Može da se postavi cenovnik, da se napravi kopija stanice (sa anuliranom
naplaćenom putarinom), da se naplati putarina od zadatog vozila, da se dohvati
ukupan naplaćeni iznos za prolaz od prethodnog postavljanja cenovnika i da se
sastavi tekstualni opis stanice u obliku idBr(naplaćenIznos). Greška je ako je
kategorija van dozvoljenog opsega ili ako u trenutku naplate nije definisan cenovnik.
Aktivna naplatna rampa sadrži naziv, zadat broj stanica i zadato srednje vreme (tsr)
između dva dolaska vozila. Pri stvaranju se zadaje stanica čijim kopiranjem se
stvaraju stanice rampe. Rampa može da se otvori, zatvori i da se uništi. Može da se
odredi ukupan naplaćen iznos od poslednjeg otvaranja rampe i da se sastavi
tekstualni opis rampe u obliku naziv(naplaćeno):stanica,…,stanica. Pri otvaranju se
zadaje novi cenovnik koji se prosleđuje svim stanicama. Kad je rampa otvorena,
vozila slučajnih kategorija, koje su u dozvoljenom intervalu prema važećem
cenovniku, pristižu u slučajnim vermenskim intervalima od (1±0,3)tsr, na slučajnu
stanicu rampe.
Napisati na jeziku Java Program koji napravi jednu naplatnu rampu koju otvori, posle
izvesnog vremena ispiše na glavnom izlazu, posle još nešto vremena zatvori, ispiše na
glavnom izlazu i uništi. Koristiti konstantne parametre (ne treba ništa učitavati s
glavnog ulaza).
