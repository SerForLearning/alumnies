# Anagrafica Alunni

Questo progetto prevede la gestione dell'anagrafica degli alunni delle università

## Tecnologie e Approcci Utilizzati

### 1. **Behavior-Driven Development (BDD)**

Il progetto segue il paradigma del **Behavior-Driven Development (BDD)**, che aiuta a definire le funzionalità del
sistema in modo che siano facilmente comprensibili da tutti i membri del team, non solo gli sviluppatori. In
particolare, il progetto include uno specifico modulo con gli **Acceptance Criteria** che definisce il comportamento
atteso del sistema in vari scenari. I test sono scritti utilizzando una notazione che rappresenta le caratteristiche e i
comportamenti del sistema, rendendo il progetto facilmente comprensibile e orientato agli utenti finali.

Il sorgente si trova nella cartella *acceptance-test*

### 2. **Test-Driven Development (TDD)**

L'approccio **Test-Driven Development (TDD)** è stato utilizzato durante lo sviluppo. Ogni funzionalità è stata
sviluppata seguendo il ciclo **Red-Green-Refactor**:

- **Red**: Scrittura dei test unitari che descrivono il comportamento desiderato.
- **Green**: Implementazione del codice per far passare i test.
- **Refactor**: Riorganizzazione e ottimizzazione del codice per migliorare la qualità e la manutenibilità.

I test sono stati scritti utilizzando **JUnit 5** e **Mockito**, con l'intento di garantire una copertura completa del
codice e un elevato standard di qualità.

### 3. **Contract-Driven Development (CDD)**

Il progetto segue l'approccio **Contract-Driven Development (CDD)**, che si basa su specifiche formali (contratti) per
la progettazione delle API. In questo caso, l'applicazione si è basata su **OpenAPI** per la definizione dei contratti
delle API RESTful.

L'uso di **OpenAPI** consente di avere una descrizione chiara e univoca delle API, facilitando il lavoro di integrazione
con altri sistemi e riducendo il rischio di malintesi tra i team di sviluppo. Le specifiche OpenAPI sono documentate e
utilizzate come riferimento per il corretto funzionamento delle API nel progetto. I modelli rest sono stati utilizzati
con l'apposito generatore

### 4. **Spring Boot e Java 21**

Il backend dell'applicazione è sviluppato con **Spring Boot**, sfruttando le sue capacità di configurazione automatica e
la facilità d'uso per costruire microservizi robusti e scalabili. Il progetto è basato su **Java 21**, che offre nuove
funzionalità e miglioramenti in termini di performance e sicurezza.

## Struttura del Progetto

Il progetto è suddiviso nelle seguenti cartelle principali:

- **/be**: Contiene il codice sorgente del backend, scritto in Java. All'interno di questa cartella, troverai il codice
  che implementa la logica di business, i controller REST, i servizi, e le repository per l'accesso ai dati.
    - La struttura del progetto all'interno di `/be` segue le convenzioni di **Spring Boot** con l'uso di componenti
      come controller, servizi, repository, e modelli.
    - L'approccio BDD e TDD è seguito in modo coerente, con test unitari e di integrazione che coprono la maggior parte
      del codice.
    - L'API è documentata utilizzando **OpenAPI** e le specifiche di contratto sono disponibili all'interno della
      cartella *resources/openapi* nel file alumni-api.yaml

## Setup e Avvio del Progetto

### 1. **Prerequisiti**

Assicurati di avere i seguenti strumenti installati sul tuo sistema:

- **Java 21** o versioni successive
- **Maven**  per la gestione delle dipendenze
- **IDE** come **IntelliJ IDEA** o **Eclipse** per la scrittura del codice
- **Docker** (opzionale, per il setup di database per i test e2e e per poter provare l'applicazione in locale)

### 2. **Installazione**

1. Clona il repository del progetto:
   ```bash
   git clone https://github.com/tuo-username/progetto-java
   cd be
   mvn clean install
   mvn spring-boot:run
