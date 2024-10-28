plugins {
    alias(libs.plugins.android.library)
}
//apply plugin: 'com.github.dcendents.android-maven'

//group = 'com.github.tiagohm'

android {
    namespace = "br.tiagohm.markdownview"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
//        versionCode = 1
//        versionName = "0.19.0"
    }
    lint {
        targetSdk = 34
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

//noinspection UseTomlInstead
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

//    implementation(libs.androidx.appcompat)
//    testImplementation(libs.junit)
//    androidTestImplementation 'com.android.support.test:runner:1.0.1'
//    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
    //Flexmark
//    implementation(libs.flexmark)
//    implementation(libs.flexmark.ext.tables)
//    implementation(libs.flexmark.ext.gfm.strikethrough)
//    implementation(libs.flexmark.ext.gfm.tasklist)
//    implementation(libs.flexmark.ext.autolink)
//    implementation(libs.flexmark.ext.abbreviation)
//    implementation(libs.flexmark.ext.superscript)
//    implementation(libs.flexmark.ext.footnotes)
//    implementation(libs.flexmark.ext.attributes)
//    //Logger
//    implementation(libs.logger)

    implementation("androidx.appcompat:appcompat:1.7.0")
    testImplementation("junit:junit:4.13.2")
    //Flexmark
    implementation("com.vladsch.flexmark:flexmark:0.28.32")
    implementation("com.vladsch.flexmark:flexmark-ext-tables:0.28.32")
    implementation("com.vladsch.flexmark:flexmark-ext-gfm-strikethrough:0.28.32")
    implementation("com.vladsch.flexmark:flexmark-ext-gfm-tasklist:0.28.32")
    implementation("com.vladsch.flexmark:flexmark-ext-autolink:0.28.32")
    implementation("com.vladsch.flexmark:flexmark-ext-abbreviation:0.28.32")
    implementation("com.vladsch.flexmark:flexmark-ext-superscript:0.28.32")
    implementation("com.vladsch.flexmark:flexmark-ext-footnotes:0.28.32")
    implementation("com.vladsch.flexmark:flexmark-ext-attributes:0.28.32")
    //Logger
    implementation("com.orhanobut:logger:1.15")
}

configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
        force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.22")
    }
}