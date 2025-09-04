import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

/**
 * Ensures android.targetSdk is at or above the required floor.
 * This task is wired into the root `check` task in build.gradle.kts.
 */
open class SdkPolicyCheck : DefaultTask() {

    init {
        group = "verification"
        description = "Checks that android.targetSdk meets policy requirements."
    }

    @TaskAction
    fun run() {
        val requiredTarget = 35

        val targetProp = (project.findProperty("android.targetSdk") as? String)
            ?: throw GradleException(
                "SdkPolicyCheck: Missing 'android.targetSdk' in gradle.properties."
            )

        val target = targetProp.toIntOrNull() ?: throw GradleException(
            "SdkPolicyCheck: 'android.targetSdk' is not an integer: '$targetProp'"
        )

        if (target < requiredTarget) {
            throw GradleException(
                "SdkPolicyCheck: targetSdk=$target is below required floor $requiredTarget. " +
                        "Please bump android.targetSdk in gradle.properties."
            )
        }

        logger.lifecycle("✅ SdkPolicyCheck passed: targetSdk=$target (required ≥ $requiredTarget)")
    }
}