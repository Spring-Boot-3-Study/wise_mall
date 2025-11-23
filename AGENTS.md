# Repository Guidelines

## Project Structure & Module Organization
Wise Mall is a Kotlin/Spring Boot monolith targeting Java 21. Application code sits under `src/main/kotlin/com/wisemall/monolithic/v1`, grouped by bounded contexts (`account`, `product`, `order`, `payment`, `delivery`) with `api`, `application`, and `persistence` adapters. Shared utilities live in `global/*`. Configuration and Flyway SQL migrations are under `src/main/resources`, including `db/migration/v1__init.sql`. Tests mirror the package layout in `src/test/kotlin`.

## Build, Test, and Development Commands
- `./gradlew clean build` compiles the project, runs all tests, and produces the bootable artifact.
- `./gradlew bootRun` starts the API locally with the default `application.yml`.
- `./gradlew test` runs Kotest/JUnit test suites without building artifacts.
Use the `gradlew` script to guarantee the repo-pinned Gradle version.

## Coding Style & Naming Conventions
Follow the Kotlin official style: 4-space indents, trailing commas where helpful, and idiomatic null-safety. Keep packages aligned with `com.wisemall.monolithic.v1.<domain>.<layer>`. Classes and data models use PascalCase, functions and properties camelCase, and REST endpoints use kebab-case paths already established (e.g., `/api/v1/order`). Leverage Spring annotations at constructor level and favor immutable data classes for DTOs. Linting is manual—run IntelliJ’s Kotlin formatter before committing.

## Testing Guidelines
Add unit or slice tests beside the feature under `src/test/kotlin/com/wisemall/monolithic/v1/<domain>`. Use Kotest specs (e.g., `OrderServiceTest : DescribeSpec`) or Spring `@SpringBootTest` when integration coverage is required. Name files with a `*Test` or `*Spec` suffix, and aim to cover edge cases around transactional boundaries and entity mappings. Ensure `./gradlew test` is green before pushing.

## Commit & Pull Request Guidelines
Align with the existing Conventional Commit style (`feat:`, `chore:`, `refactor:`). Keep messages in English, present-tense, and scoped to a single concern (e.g., `feat: add payment approval flow`). For pull requests, target `develop` unless coordinating otherwise, describe the change, list test evidence (command outputs or screenshots for API changes), and link related issues. Request reviews when the branch is rebased and free of failing checks.
