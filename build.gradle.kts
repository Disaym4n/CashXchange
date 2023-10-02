
// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false

}
true // Needed to make the Suppress annotation work for the plugins block

dependencies {
     (libs.gradle)
    (libs.kotlin.gradle.plugin)

    //hilt for di
    //ext.hilt_version = '2.28-alpha'
     (libs.hilt.android.gradle.plugin.v244)

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
}
