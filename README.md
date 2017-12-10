# Alkalmazások fejlesztése - Féléves beadandó
## 1. Bevezető
A program egy reptéri jegykezelő rendszer egyszerűsített változatát valósítja meg.
## 2. Követelményanalízis
### 2.1 Követelmények
#### Funkctionális követelmények
* Regisztráció
* Bejelentkezés
* Bejelenektezett felhasználóknak:
  * Járatok megtekintése
  * Foglalás egy járatra
  * Foglalás törlése
  * Személyes adatok módosítása
  * Személyes adatok megtekintése
* Bejelentkezett admin-nak:
  * Légitársaság:
     * Létrehozása
      * Törlése
      * Módosítása
   * Járat:
     * Létrehozása
      * Törlése
      * Módosítása
   * Reptér:
     * Létrehozása
      * Törlése
      * Módosítása
   * Légitársaság:
     * Létrehozása
      * Törlése
      * Módosítása
   
#### Nem funkctionális követelmények
* Felhasználóbarát: Megfelelően elhatárolt funkciók. Világos látható színekkel írt betűk. Ésszerű elrendezés
* Biztonság: Jelszóval védett funkciók. A jelszavak titkosítottak. A különböző űrlapoknál egy hibalistában kijelzi a program a hibákat.
* Gyors működés: Adatbázisban operáló program, gyors kereséssekkel hamar előállítja a kívánt eredményeket.

### 2.2 Szakterületi fogalomjegyzék
#### Szerepek
* Vendég: Be nem jelentkezett felhasználó, csak a regisztriáció és bejelentkezés menü érhető el számára.
* Felhasználó: Egyszerű utas akinek az alkalmazás funkciói csak korlátozottan érhetőek el.
* Admin: Rendszergazda akinek az alkalmazás összes funkciója elérhető.
### Folyamatok
**Egy jegyfoglalás**
* Először bejelentkezünk az alkalmazásba
* Kikeressük a kívánt uticélt
* A kilistázott járatok közül a megfelelőnél a "Foglalás" gombra rányomunk
* Ha sikerül akkor az alkalmazás kiírja, hogy sikeres foglalás

 ![picture alt](https://github.com/Angerbrood/airlines-lister/blob/develop/img/Abstract_Flow.jpg "Title is optional")
 
 ![picture alt](https://github.com/Angerbrood/airlines-lister/blob/develop/img/Create_Reservation.jpg "Title is optional")
## Tervezés
### 3.1 Oldaltérkép
#### Publikus
* Bejelentkezés
* Regisztráció
#### Bejelentkezett felhasználó
* Járatok listázása
* Személyes adatok kezelése
* Hely foglalás
* Foglalás törlése
#### Bejelentkezett admin
* Fehasználók kezelése
* Járatok kezelése
* Légitársaságok kezelése
* Repterek kezelése
### 3.2 Végpontok
* GET:
  * /: Bejeletkezés
  * /register: Regisztrációs oldal
  * /logout: Kijelentkezés
  * /flights: Járatok
  * /personal: Személyes adatok
  * /listAirlines: Légitársaságok listázása
  * /listFlights: Járatok listázása
  * /listLocations: Repterek listázása
  * /listUsers: Felhasználók listázása
* POST:  
  * /createNewAirline: Légitársaság létrehozása
  * /deleteAirline/:airlineId: Légitársaság törlése
  * /modifyAirline/:airlineId: Légitársaság módosítása
  * /createNewFlight: Járat létrehozása
  * /deleteFlight/:flightId: Járat törlése
  * /modifyFlight/:flightId: Járat módosítása
  * /createNewLocation: Reptér létrehozása
  * /deleteLocation/:locationId: Reptér törlése
  * /modifyLocation/:locationId: Reptér módosítása
  * /createNewUser: Felhasználó létrehozása
  * /deleteUser/:userId: Felhasználó törlése
  * /modifyUser/:userId: Felhasználó módosítása
  * /createNewReservation/:flightId Foglalás létrehozása
  * /deleteReservation/:flightId: Foglalás törlése
  ### 3.3 Felhasználó modell
 ![picture alt](https://github.com/Angerbrood/airlines-lister/blob/develop/img/User.jpg "Title is optional")
  ### 3.4 Admin modell
 ![picture alt](https://github.com/Angerbrood/airlines-lister/blob/develop/img/Admin.jpg "Title is optional")
  ### 3.5 Megvalósítása
  ## 4. Implementáció
  ### 4.1 Adatbázis terv
  ![picture alt](https://github.com/Angerbrood/airlines-lister/blob/develop/img/db-diagram.jpg "Title is optional")
  ### 4.2 Osztály diagramm
  ![picture alt](https://github.com/Angerbrood/airlines-lister/blob/develop/img/uml.png "Title is optional")
  ### 4.3 Fejlesztői környezet
  * Github
  * IntelliJ Idea
  * Angular 2
  * MySQL
  * Heidi SQL
  ### 4.4 Könyvtárstruktúra
  * configuration: Az alkalmazás konfigurációi. (Spring, Hibernate stb)
  * controllers: Kontrollerek
  * dao: Data Access Object-ek az adatbázis kezeléshez
  * model: Modellek
  * security: Az alkamazáshoz szükséges biztonsági beállítások
  * service: Service réteg.
  * util: Egyéb máshova nem illeszkedő osztályok
  ## 5. Tesztelés
  ## 6. Felhasználói dokumentáció
  ### Futtatáshoz szükséges eszközök
  * Futó MySQL szerver
  * MySQL szerverben egy user aminek a felhasználóneve és jelszava root
  * MySQL szerverben egy adatbázis a következő névvel: elte-airlines 
  * Google Chrome
  * Megjegyzés: Ezek az adatok alapértelmezettek, ha szeretnénk megváltoztatni, akkor a src/main/resources/application.properties fájlban tudjuk megtenni. 
  ### Futtatás
 * Megjegyezés: A szerver automatikusan létrehozza a táblákat!
 * git clone a projektet vagy letölteni mint zip és kicsomagolni egy tetszőleges helyre
 * CMD-ben elnavigálni a projekt főkönyvtárába
 * Szerver:
   * CMD-ben kiadni a következő parancsot: mvn clean package
   * CMD-ben kiadni a következő parancsot: mvn cargo:run
   * A főkönyvtárban található egy init.sql fájl, azt lefuttatni egy tetszőleges sql kliensel (javasolt: HeidiSQL)
 * Klines:
   * CMD-ben kiadni a következő parancsot: cd front-end
   * CMD-ben kiadni a következő parancsot: npm install
   * CMD-ben kiadni a következő parancsot: npm start
 * Böngészőben megnyitni a localhost:5555 címet 
