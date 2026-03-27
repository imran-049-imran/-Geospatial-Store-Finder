# Geospatial Store Finder

> Find nearby stores instantly using real-time location and an interactive map.

![Java](https://img.shields.io/badge/Java-Spring%20Boot-brightgreen?style=flat-square&logo=springboot)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue?style=flat-square&logo=mysql)
![Google Maps](https://img.shields.io/badge/Maps-Google%20Maps%20API-red?style=flat-square&logo=googlemaps)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)

---

## Overview

Geospatial Store Finder is a full-stack application that computes nearby stores from a user's coordinates using the **Haversine formula**, exposes the results via a **RESTful Spring Boot API**, and renders them as markers on a **Google Maps** frontend.

---

## Tech Stack

| Layer      | Technology                        |
|------------|-----------------------------------|
| Backend    | Java, Spring Boot, Spring Data JPA |
| Frontend   | HTML, JavaScript, Google Maps API |
| Database   | MySQL                             |
| Build/Dev  | Maven, Postman, Git               |

---

## Features

- **Location-based search** — query stores by latitude, longitude, and radius
- **Haversine distance calculation** — accurate great-circle distance between coordinates
- **RESTful API** — clean, stateless endpoints built with Spring Boot
- **Interactive map** — Google Maps with store markers rendered in real time
- **Dynamic responses** — live API data without page reloads

---

## Project Structure

```
com.geospatial.storefinder
├── controller      # REST endpoints
├── service         # Business logic & Haversine calculation
├── repository      # Spring Data JPA interfaces
├── model           # JPA entities (Store, etc.)
└── config          # CORS, beans, app configuration
```

---

## Getting Started

### Prerequisites

- Java 17+
- MySQL 8+
- Maven 3.8+
- A Google Maps API key

---

### 1. Clone the Repository

```bash
git clone https://github.com/imran-049-imran/Geospatial-StoreFinder.git
cd Geospatial-StoreFinder
```

### 2. Set Up the Database

```sql
CREATE DATABASE store_db;
```

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/store_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

### 3. Add Your Google Maps API Key

In `src/main/resources/static/index.html`:

```html
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY"></script>
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

The server starts at `http://localhost:8080`.

---

## API Reference

### Get Nearby Stores

```
GET /api/stores/nearby
```

| Parameter | Type   | Required | Description                        |
|-----------|--------|----------|------------------------------------|
| `lat`     | float  | Yes      | User's latitude                    |
| `lon`     | float  | Yes      | User's longitude                   |
| `radius`  | float  | Yes      | Search radius in kilometers        |

**Example request:**

```bash
curl "http://localhost:8080/api/stores/nearby?lat=17.3850&lon=78.4867&radius=5"
```

**Example response:**

```json
[
  {
    "id": 1,
    "name": "Store Name",
    "latitude": 17.391,
    "longitude": 78.479,
    "distanceKm": 1.23
  }
]
```

---

## How It Works

```
User Input (lat, lon, radius)
        │
        ▼
Spring Boot Controller
        │
        ▼
Service Layer — Haversine formula filters stores by distance
        │
        ▼
MySQL Database — store coordinates retrieved via JPA
        │
        ▼
JSON Response → Google Maps renders markers
```

---

## Roadmap

- [ ] Live location tracking (Geolocation API)
- [ ] JWT-based authentication
- [ ] Distance sorting and category filtering
- [ ] Deployment on AWS / Render
- [ ] Store details panel on marker click

---

## Author

**Imran Attar**

- Email: [attarimran782@gmail.com](mailto:attarimran782@gmail.com)
- GitHub: [@imran-049-imran](https://github.com/imran-049-imran)
- LinkedIn: [imran-attar-703637373](https://www.linkedin.com/in/imran-attar-703637373/)

---

## Support

If this project was helpful, consider giving it a ⭐ on [GitHub](https://github.com/imran-049-imran/Geospatial-StoreFinder) — it helps others find it too.
