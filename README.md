# camacttry

Baseline Android project with GitHub + API wiring.

## ✅ Current Setup
- Android target/compile SDK **35** (auto-bump weekly).
- `buildSrc/SdkPolicyCheck` enforces policy floor on every `./gradlew check`.
- GitHub Actions CI:
    - `android.yml` builds, lints, tests, and runs policy check.
    - `sdk-bump.yml` auto-opens PR to bump target/compileSdk via `tools/bump_sdk.sh`.
- Secrets:
    - `local.properties` (local dev).
    - GitHub Actions Secrets → `OPENAI_API_KEY` (CI).

## 🔑 Secrets
- Local dev: add to `local.properties`
  ```properties
  OPENAI_API_KEY=your_key_here