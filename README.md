# GitHubMPP
Proof of concept of a Kotlin MultiPlatform project.

The project consist in displaying a list of some Github account's members. For this POC only Android, iOS and Web(React) are supported.

## How to run the project

Clone this repository and open it with Android Studio.

#### Android

Run it as a normal Android application from the run button in Android Studio.

#### iOS (MacOS Only)

1. Run `open iosApp/GitHubKMP/GitHubKMP.xcworkspace` to open the project in XCode.
2. Run it as a normal iOS application from the run button in XCode.

#### Web

1. Run `./gradlew :jsApp:run` to start a development WebPack server locally.
2. Open a modern web browser and go to http://localhost:8088/ to see the result.
3. Run `./gradlew :jsApp:stop` to stop the server.
