# Repository Guidelines

## Project Structure & Module Organization
Kotlin sources live in `src/main/kotlin/com/wisemall/monolithic/v1`, grouped by domain (`account`, `order`, `payment`, `product`) and layer (`api`, `application`, `core`, `adapter`, `persistence`). Cross-cutting utilities and configuration sit under `global` (e.g., `global/config`, `global/exception`). Views and database assets are in `src/main/resources`; Flyway migrations reside in `db/migration`. Tests mirror the production package layout beneath `src/test/kotlin` so new specs should follow the same domain folder.

## Build, Test, and Development Commands
- `./gradlew bootRun` launches the Spring Boot application with devtools for hot reload.
- `./gradlew build` runs compilation and the full test suite to produce the runnable JAR in `build/libs`.
- `./gradlew test` executes unit and integration tests only; use this before pushing quick fixes.
- `./gradlew clean` clears build artifacts when dependencies or generated sources become stale.

## Coding Style & Naming Conventions
Use Kotlin’s default 4-space indentation and keep line length under 120 characters. Classes and components adopt `PascalCase`, functions and variables use `camelCase`, and DTOs end with `Request` or `Response` as in `OrderCreateRequest`. Controllers should remain thin, delegating to `application` or `core` services via constructor injection. Prefer data classes for immutable payloads and leverage Kotlin null-safety instead of unchecked `!!` operators.

## Testing Guidelines
Kotest with the JUnit 5 runner is available for expressive specs; place new tests alongside targets (e.g., `payment/application/service/PaymentServiceTest.kt`). Name files with the `*Test.kt` suffix and favor scenario-based method names such as `shouldReturnOrderDetails`. Run `./gradlew test` locally before opening a pull request and add fixtures that cover both success and edge cases for new domain rules.

## Commit & Pull Request Guidelines
Follow the existing history by starting commit subjects with a lowercase type tag (`feat:`, `fix:`, `refact:`) followed by a concise summary. Limit subjects to 72 characters and elaborate in the body when decisions need explanation or follow-up actions. Pull requests must describe the change, list validation commands (`./gradlew test`), and attach API samples or screenshots when the client contract shifts. Link to Jira or GitHub issues when available so reviewers can trace requirements.

## Configuration & Data Safety
Shared defaults live in `src/main/resources/application.yml`; override credentials locally via environment variables or profile-specific files rather than editing committed secrets. Flyway runs automatically at startup, so add new DDL scripts with incremental names (`v2__add_payment_table.sql`) and keep them idempotent. Mask any sensitive values in logs by relying on the provided `global` response and exception helpers.
