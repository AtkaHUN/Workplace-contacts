# Backend megvalósítása
## Fejlesztői környezet és annak beállításai
- Fejlesztéshez szükséges programok:
	- Java 1.8
	- Netbeans (vagy bármilyen más java kódot fordítani és futtatni képes eszköz) 
	- Postgres (vagy más endpoint tesztre képes eszköz)
- Program futtatásához szükséges külön beállítások:
	- Nincs ilyen
## Adatbázis terv:
![Adatbázis](../Database.png)
- Ahol az Enum értékei: TELEPHONE, MOBILE_PHONE, EMAIL
## Könyvtárstruktúra
A programban 6 külön alkönyvtár található, amik a következőek:
- **Entities**: Ez a mappa tárolja az adatbázisbeli táblák Java beli ábrázolását.
- **Repositories**: Az adott entiti-kből való adatlekéréseket tároló osztályok találhatóak meg ebben a mappában.
- **Controllers**: A különböző entitik megnézéséhez/felvételéhez/szerkesztéséhez/törléséhez szükséges endpointokat tartalmazó mappa.
- **Security**: Az adatbázis endpoint védelmét szolgáló osztályait tároló mappa.
- **Keys**: A Contact osztály összetett kulcsát representáló segédosztályt tároló mappa.
- **Error**: Speciális errorüzeneteket osztályát tároló mappa.
## Végpontok
###### Person végpontjai
- GET
	- Link: `/person`
		- Funkciója: Visszaadja az összes Person-t
		- Bemenet: nics
		- Kimenet: az összes Person json-ben
		- Hozzáférési szint: mindenki
	- Link: `/person/findByName`
		- Funkciója: A bemeneti érték szerint megkeresi az adott személyek elérhetőségeit (a név egy részlete is elég).
		- Bemenet: json `name` paraméterrel
		- Kimenet: json-ben Person-ök a Contact-jaikkal
		- Hozzáférési szint: mindenki
- DELETE
	- Link `/person/{id}`
		- Funkciója: A linkben megadott id-jű személy törlése
		- Bemenet: a linkben található id érték
		- Kimenet: sikeres hívás esetén semmi
		- Hozzáférési szint: admin
	
###### Department végpontjai
- GET
	- Link: `/department`
		- Funkciója: Visszaadja az összes Department-et a benne lévő emberekkel és elérhetőségeikkel.
		- Bemenet: nincs
		- Kimenet: json-ben az összes Department a benne lévő Person-ökkel és a Contact-jaikkal
		- Hozzáférési szint: mindenki
	- Link: `/department/findByName`
		- Funkciója: A bemeneti érték szerint megkeresi a Department-et és visszaadja a benne dolgozó emberek elérhetőségeit.
		- Bemenet: json `name` paraméterrel
		- Kimenet: json-ben 1 Department a benne lévő Person-ökkel és a Contact-jaikkal
		- Hozzáférési szint: mindenki
- DELETE
	- Link `/department/{id}`
		- Funkciója: A linkben megadott id-jű Department törlése
		- Bemenet: a linkben található id érték
		- Kimenet: sikeres hívás esetén semmi
		- Hozzáférési szint: admin
###### Contact végpontjai
- GET
	- Link: `/contact`
		- Funkciója: Visszaadja az összes Contact-ot.
		- Bemenet: nincs
		- Kimenet: json-ben az összes Contact
		- Hozzáférési szint: mindenki
	- Link: `/contact/findByName`
		- Funkciója: A bemeneti érték szerint megkeresi azt a Person-t akihez a contact-ban szereplő érték vagy annak egy részlete tartozik
		- Bemenet: json `contact` paraméterrel
		- Kimenet: json-ben 1 bahy több Person a benne lévő Contact-jaikkal
		- Hozzáférési szint: mindenki
- DELETE
	- Link `/contact/{contact}`
		- Funkciója: A linkben megadott contact-ú Contact törlése
		- Bemenet: a linkben található contact érték
		- Kimenet: sikeres hívás esetén semmi
		- Hozzáférési szint: admin
###### Admin végpontjai
- GET
	- Link: `/admins`
		- Funkciója: Visszaadja az összes Admin-t.
		- Bemenet: nincs
		- Kimenet: json-ben az összes Admin
		- Hozzáférési szint: admin
- DELETE
	- Link `/admin/{id}`
		- Funkciója: A linkben megadott id-ű Admin törlése
		- Bemenet: a linkben található id érték
		- Kimenet: sikeres hívás esetén semmi
		- Hozzáférési szint: admin
		
[Vissza az főleírásra](../README.md)
