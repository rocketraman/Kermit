plugins {
    id("com.android.library") version "3.6.1"
    kotlin("multiplatform") version "1.3.71"
    id("co.touchlab.native.cocoapods") version "0.6"
    id("maven-publish")
}

group="co.touchlab"
version="0.0.1"

repositories {
    google()
    mavenCentral()
    jcenter()
}

kotlin {
    version = "0.0.1"
    android {
        publishAllLibraryVariants()
    }
    ios()

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val androidMain by sourceSets.getting {
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
        val androidTest by sourceSets.getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation("androidx.test:runner:1.2.0")
                implementation("org.robolectric:robolectric:4.3.1")
            }
        }

        val iosMain by sourceSets.getting {

        }
    }
    cocoapodsext {
        summary = "Common library for Kermit"
        homepage = "https://www.touchlab.co"
    }
}

android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(15)
    }

    val main by sourceSets.getting {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
    }
}
