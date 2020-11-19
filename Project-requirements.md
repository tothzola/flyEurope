# Project

## Airports

### Creare Repository si proiect Maven

- creeaza un repository in GitHub (fie public, fie privat - sa ma adaugi colaborator)
- cloneaza-l local (sugestie: foloseste GitHub Desktop, folosind URL-ul repo-ului)
- creeaza un proiect Maven, folosind archetype-ul: maven-archetype-quickstart
- muta continutul proiectului in folder-ul unde ai clonat repository-ul

### Configurare proiect

- din punct de vedere tehnic, aplicatia Spring Boot trebuie organizata pe layer-e, reprezentate prin pachete Java:
  - controller
  - model
  - repository
  - service

- ideal ar fi sa scrii si teste unitare si/sau de integrare

- proiectul ar trebui sa contina un fisier README.md, care sa descrie pasii de instalare si pornire a aplicatiei
  - start the application executing the following command: `mvn spring-boot:run`
  - access the application using the following URL in the browser: `http://localhost:8080`

### Requirements

#### Concepte cu care lucreaza aplicatia

- aeroporturi listate in aplicatia noastra
- companii aeriene
- zborurile, care au aeroport de plecare si aeroport de sosire; fiecare zbor are o companie aeriana asociata

#### Home page si Search page

- aplicatia permite "gestiunea" mai multor aeroporturi
- pe home page vom permite selectia unui aeroport (fie dintr-un dropdown, fie prin alta modalitate)
- o data ce am selectat un aeroport, suntem redirectati intr-o noua pagina, in care gasim informatii despre aeroport
  - e.g. nume, orasul, tara
  - adresa si localizare pe harta (optional; Google Maps, OpenStreetMap, MapBox)
- pentru aeroportul selectat, by default trebuie sa afisam pe aceeasi pagina o selectie cu urmatoarele 10 zboruri din ziua curenta
  - tinem cont de ora curenta
  - afisam intr-o sectiune urmatoarele "arrivals" si intr-o alta sectiune urmatoarele "departures"
- vom avea o pagina de cautare, in care, pentru aeroportul selectat putem cautam toate zborurile dintr-un interval de zile
  - in plus, daca selectam in formularul de cautare si o linie aeriana, afisam doar zborurile acelei companii
  - avem si un grup de radio buttons in care selectam daca vrem sosirile sau plecarile


#### Administration page

- in header-ul paginii "home" trebuie sa avem un link "Login"
- atunci cand administratorul se autentifica, va avea acces la pagina de administrare a aplicatiei
  - linkul de login va disparea si va aparea un link de logout
  - in stanga linkului de logout va aparea un link "Administration"
- cand se acceseaza linkul de admin, se afiseaza pagina ce ne permite sa adaugam/editam/stergem de date despre zboruri
  - in pagina, vom avea un buton "Add", care ne duce intr-o noua pagina; pagina va fi un formular, prin care introducem un nou zbor
    - zborul contine urmatoarele date: aeroport de plecare, aeroport de sosire (le poate selecta din lista de aeroporturi gestionata de aplicatia noastra), data si ora de plecare, data si ora de sosire, compania aeriana, numar zbor etc.
    - tabela flights
      - id long PK
      - flightno string
      - departure datetime
      - arrival datetime
      - departure_airport FK (foreign key; legatura la id-ul tabelei airports)
      - arrival_airport FK (foreign key; legatura la id-ul tabelei airports)
      - airline FK (foreign key catre tabela airlines)

  - datele despre zboruri sunt afisate sub forma tabelara in pagina administrare (pentru inceput, fara paginare)

  - pentru fiecare rand in parte trebuie sa putem face actiuni: edit sau delete
  - atunci cand apasam linkul "edit", avem un zbor selectat => mergem intr-o noua pagina, in care avem un formular
  precompletat cu datele acelui zbor; si putem modifica datele; apoi putem da Save si datele se actualizeaza in DB; apoi facem "refresh" paginii
  - la "delete" stergem zborul si facem "refresh" paginii (o accesam din nou)

