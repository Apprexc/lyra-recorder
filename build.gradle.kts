// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.5.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.25" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

// 🔐 Wire SdkPolicyCheck into the build lifecycle
tasks.register<SdkPolicyCheck>("checkSdkPolicy")

// Ensure policy check runs with every `./gradlew check`
tasks.named("check") {
    dependsOn("checkSdkPolicy")
}