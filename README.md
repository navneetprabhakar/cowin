# CoWin API Integration Service

> A Spring Boot service that wraps India's CoWin vaccination APIs and posts slot availability to Twitter.

A REST service that integrates with India's public CoWin (COVID-19 vaccination) APIs to look up states, districts, and vaccination appointment availability, and optionally tweets slot-availability updates through a Twitter bot.

## Features

- Look up all Indian states and the districts within a state from the CoWin APIs
- Find vaccination appointments by pincode or district, for a given date
- Retrieve a 7-day appointment calendar by pincode or district
- OTP-based authentication flow (generate and confirm OTP) against CoWin
- Twitter bot that posts slot-availability status at pincode, district, state, or country-wide level (state and country posts are batched with delays to respect rate limits)
- Interactive API documentation via Swagger UI

## Tech Stack

- **Java 8**
- **Spring Boot 4.1.0-M1**
- **Spring Web** (REST)
- **Twitter4J 4.0.7** (Twitter integration)
- **Springfox / Swagger 3.0.0** (OpenAPI docs)
- **Apache HttpClient 4.5.14**
- **Lombok**
- **Maven**

## Getting Started

### Prerequisites

- JDK 8+
- Maven 3.x
- Twitter developer credentials (only required for the Twitter bot endpoints)

### Build

```bash
mvn clean install
```

### Run

```bash
java -jar target/apis-0.0.1-SNAPSHOT.jar
```

The service runs on port `8080` under the context path `/cowin/service/`.

### API Documentation

Once running, the Swagger UI is available at:

```
http://localhost:8080/cowin/service/swagger-ui/
```

## Configuration

CoWin endpoint paths live in `src/main/resources/cowin.properties` (base URL `https://cdn-api.co-vin.in/api/v2/`). Server settings are in `application.properties` (`server.port`, `server.servlet.context-path`).

Twitter credentials are read from `src/main/resources/twitter4j.properties`. These are shipped as empty placeholders and must be supplied with your own Twitter developer account values:

```properties
oauth.consumerKey=your-consumer-key
oauth.consumerSecret=your-consumer-secret
oauth.accessToken=your-access-token
oauth.accessTokenSecret=your-access-token-secret
```

> Mind your Twitter API rate limits when using the state-wide and country-wide posting endpoints. See https://developer.twitter.com/en/docs/twitter-api

## API

### Location — `/v1/location`

| Method | Path | Description |
| --- | --- | --- |
| GET | `/v1/location/states` | List all states |
| GET | `/v1/location/findDistrictsByStateId?state_id={id}` | List districts for a state |

### Appointments — `/v1/appointment`

| Method | Path | Description |
| --- | --- | --- |
| GET | `/v1/appointment/findByPin?pincode={pincode}&date={dd-MM-yyyy}` | Appointments by pincode |
| GET | `/v1/appointment/findByDistrict?district_id={id}&date={dd-MM-yyyy}` | Appointments by district |
| GET | `/v1/appointment/calendarByPin?pincode={pincode}&date={dd-MM-yyyy}` | 7-day calendar by pincode |
| GET | `/v1/appointment/calendarByDistrict?district_id={id}&date={dd-MM-yyyy}` | 7-day calendar by district |

### Authentication — `/v1/authentication`

| Method | Path | Description |
| --- | --- | --- |
| POST | `/v1/authentication/generateOtp` | Generate an OTP |
| POST | `/v1/authentication/confirmOtp` | Confirm an OTP |

### Twitter Bot

| Method | Path | Description |
| --- | --- | --- |
| GET | `/postByPincode?pincode={pincode}` | Tweet availability for a pincode |
| GET | `/postDistrictStatus?districtId={id}` | Tweet availability for a district |
| GET | `/postStateStatus?stateId={id}` | Tweet availability for all districts in a state |
| GET | `/postCountryStatus` | Tweet availability across all states |
