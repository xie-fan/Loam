# Loam Developer Guide

## 1. Project Positioning

This project is organized in two layers:

1. Base platform modules (foundation)
2. Extension business modules (feature domains)

For new development, keep this boundary stable.

## 2. Module Architecture

### 2.1 Base Platform Modules

Base platform modules provide common capabilities and microservice infrastructure:

- `loam-common`
- `loam-gateway`
- `loam-auth`
- `loam-system`

These modules should remain generic and reusable. Do not put extension-specific business logic into them.

### 2.2 Extension Modules

All extension modules are placed under `module/`.

Current extension:

- `module/loam-yolo`

Recommended pattern for each extension:

- `<ext>-api`: DTO/entity/remote contract
- `<ext>-service`: controller/service/repository implementation

This keeps extension evolution independent from the base platform.

## 3. Current Maven Module Map

Root: `Loam/pom.xml`

- Base:
  - `loam-common`
  - `loam-auth`
  - `loam-gateway`
  - `loam-system`
- Extension aggregator:
  - `module`
    - `loam-yolo`
      - `yolo-api`
      - `yolo-service`

Note:

- `loam-test` has been removed from filesystem and removed from root module list.

## 4. Development Environment

### 4.1 Required

- JDK: `25.0.2` (`C:\tools\jdk\jdk-25.0.2`)
- Maven: `3.9.12` (`C:\tools\apache-maven-3.9.12`)
- OS: Windows (PowerShell examples below)

### 4.2 Optional Runtime Dependencies

- Nacos (service discovery + config center)
- MySQL (used by `system-service`)
- MongoDB (used by `yolo-service`)

## 5. Local Build

In PowerShell:

```powershell
$env:JAVA_HOME='C:\tools\jdk\jdk-25.0.2'
$env:Path='C:\tools\apache-maven-3.9.12\bin;'+$env:JAVA_HOME+'\bin;'+$env:Path
mvn -v
```

Compile all modules:

```powershell
cd C:\projects\java\yolo\Loam
mvn -DskipTests compile
```

## 6. Service Startup Entrypoints

Main classes:

- Gateway: `loam-gateway/src/main/java/org/loam/Main.java`
- Auth: `loam-auth/auth-service/src/main/java/org/loam/auth/Main.java`
- System: `loam-system/system-service/src/main/java/org/loam/system/SystemApplication.java`
- YOLO extension: `module/loam-yolo/yolo-service/src/main/java/org/loam/yolo/service/YoloServiceApplication.java`

`auth-service`, `system-service`, and `yolo-service` use `@WebServerApplication` (includes Spring Boot + Nacos Discovery + OpenFeign).

## 7. Configuration Notes

### 7.1 Local bootstrap files

- `loam-auth/auth-service/src/main/resources/bootstrap.yml`
- `loam-system/system-service/src/main/resources/bootstrap.yml`
- `loam-gateway/src/main/resources/bootstrap.yml`

Current local ports:

- gateway: `11000`
- system-service: `11001` (context path `/system`)
- auth-service: `11002` (context path `/auth`)

### 7.2 System DB config

`system-service` uses:

- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`
- `spring.datasource.driver-class-name` (default `com.mysql.cj.jdbc.Driver`)

### 7.3 Nacos

Nacos address is read from:

- `NACOS_SERVER_ADDR` (default `127.0.0.1:8848`)

Some config imports are marked `optional:nacos:...`, but discovery/config behaviors still depend on your runtime setup.

## 8. Coding Conventions in This Repo

### 8.1 Layering

- API contracts in `*-api`
- Business implementation in `*-service`
- Reusable cross-service logic in `loam-common`

### 8.2 Common response style

- Use `Message` for simple status
- Use `DataSet<T>` for payload responses

### 8.3 Extension boundary

- Base modules should not depend on extension modules
- Extension modules can depend on base modules
- Cross-service contracts should go into `*-api` modules

## 9. How to Add a New Extension Module

Example target: add extension `foo`.

1. Create `module/loam-foo`.
2. Add child modules:
   - `module/loam-foo/foo-api`
   - `module/loam-foo/foo-service`
3. In `module/pom.xml`, add `loam-foo`.
4. In `module/loam-foo/pom.xml`, add `foo-api` and `foo-service`.
5. Keep parent chain consistent:
   - use `${revision}`
   - set correct `relativePath`
6. Put contracts/entities in `foo-api`.
7. Put controller/service/repository in `foo-service`.
8. Add service bootstrap/application config (port/name/context-path/Nacos).
9. Ensure full compile passes:
   - `mvn -DskipTests compile`

## 10. Common Pitfalls

1. Delete module directory but forget to update root `pom.xml` -> Maven build fails at model stage.
2. Parent `pom` version hardcoded and not aligned with `${revision}` -> parent resolution issues.
3. Java version mismatch -> compile/source-target errors.
4. Missing Nacos/MySQL/MongoDB runtime config -> app starts but cannot provide full functionality.

## 11. Handover Checklist for New Developers

1. Confirm JDK/Maven versions.
2. Run full compile in `Loam`.
3. Confirm required middleware instances are reachable.
4. Start services in order:
   - Nacos
   - `system-service`
   - `auth-service`
   - `yolo-service`
   - `loam-gateway`
5. Verify key APIs using `API_Documentation.md` and local smoke tests.
