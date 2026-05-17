# Microservice Project

Spring Boot mikroservis mimarisini anlamak icin hazirlanmis ornek proje seti.

## Servisler

| Servis | Port | Aciklama |
| --- | ---: | --- |
| `naming-server` | `8761` | Eureka naming server |
| `api-gateway` | `8765` | Spring Cloud Gateway |
| `currency-exchange-service` | `8000` | H2 veritabani kullanan exchange servisi |
| `currency-conversion-service` | `8100` | Feign/Eureka uzerinden conversion servisi |

## Gereksinimler

- Java 17
- Maven wrapper servis klasorlerinde mevcut

## Calistirma Sirasi

1. `naming-server`
2. `currency-exchange-service`
3. `currency-conversion-service`
4. `api-gateway`

Her servis kendi klasorunden calistirilabilir:

```powershell
cd naming-server
.\mvnw.cmd spring-boot:run
```

Linux/macOS icin:

```bash
cd naming-server
./mvnw spring-boot:run
```

## Git Kullanim Notlari

Bu repo tek cati altinda tutulur, ancak servisler ayri ayri commitlenebilir.

Ornek:

```powershell
git add api-gateway
git commit -m "Add api gateway service"

git add currency-conversion-service
git commit -m "Add currency conversion service"
```

Sadece belirli bir servisteki degisikligi commit etmek icin:

```powershell
git status --short
git add currency-exchange-service
git commit -m "Update currency exchange service"
```
