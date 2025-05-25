import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/shalva97/overwatch-player-search-api")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

kotlin {
    val xcframeworkName = "OverwatchPlayerSearchApi"
    val xcf = XCFramework(xcframeworkName)

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = xcframeworkName

            // Specify CFBundleIdentifier to uniquely identify the framework
            binaryOption("bundleId", "com.github.shalva97.${xcframeworkName}")
            xcf.add(this)
            isStatic = true
        }
    }
}
