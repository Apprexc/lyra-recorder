# ProGuard / R8 rules for camacttry

# Keep CameraX classes (future use if recording is added)
-keep class androidx.camera.** { *; }

# Keep app classes
-keep class com.example.camacttry.** { *; }

# Keep generated BuildConfig constants (like OPENAI_API_KEY)
-keep class **.BuildConfig { *; }

# Ignore missing javax.annotation warnings
-dontnote javax.annotation.**

# Ignore BouncyCastle warnings (avoid false positives)
-dontwarn org.bouncycastle.**