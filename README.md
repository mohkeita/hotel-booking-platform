# HotelBookingApp – Backend

API REST sécurisée pour la réservation d’hôtels, utilisant :

- **Spring Boot**
- **Spring Security** avec OAuth2/JWT
- **Keycloak** (authentification & rôles)
- **PostgreSQL** (persistance via JPA/Hibernate)

---

## 🏗️ Architecture

- Contrôleurs (`/api/rooms`, `/api/bookings`)
- Services métier
- Repositories (JPA)
- Sécurité Keycloak / JWT
- Rôles : `ROLE_USER`, `ROLE_ADMIN`

---

## ⚙️ Pré-requis

- Docker + Docker Compose (PostgreSQL + Keycloak)
- Java 21+
- Maven

---