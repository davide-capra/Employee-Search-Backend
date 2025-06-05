# Portale di Ricerca Employee - Backend

## Descrizione
Backend dell'applicazione web per la ricerca avanzata di dati relativi agli employee basata sullo schema HR di Oracle.  
Fornisce API REST che permettono di filtrare i dati di employee in base a diversi criteri di ricerca ricevuti dal frontend.

---

## Tecnologie utilizzate
- **Java 8+**
- **Spring Boot**: framework per lo sviluppo rapido di applicazioni web
- **Spring Data JPA**: per l’accesso e la gestione dei dati tramite ORM
- **Maven**: gestione delle dipendenze e build del progetto
- **Oracle Database**: schema HR per il modello dati employee
- **JPA Entities**: mappatura delle tabelle dello schema HR
- **REST API**: per comunicare con il frontend Angular

---

## Funzionalità principali
- Ricerca employee filtrata dinamicamente in base a:
  - Nome dipartimento
  - Location
  - Country
  - Nome employee (input text)
  - Regione
  - Salario massimo
  - Salario minimo
- Gestione di query personalizzate tramite repository JPA

---

## Configurazione database
Configurare la connessione al database Oracle HR nel file `application.properties` (o `application.yml`):

```properties
spring.datasource.url=jdbc:oracle:thin:@//host:port/service_name
spring.datasource.username=hr
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
