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
kép
kép
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
  kép
  ### 3.4 Admin modell
  kép
  ### 3.5 Mockup
  kép
  kép
  kép
  ### 3.6 Megvalósítása
  ## 4. Implementáció
  ### 4.1 Adatbázis terv
  ### 4.2 Fejlesztői környezet
  ### 4.3 Könyvtárstruktúra
  ## 5. Tesztelés
  ## 6. Felhasználói dokumentáció
  
