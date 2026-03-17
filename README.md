# Ontrace SDK (Public Metadata Repo)

This repository contains **metadata and documentation** for the `ontrace-sdk` Android library, which is published on Maven Central.  
You **do not** need to add this repository as a module in your project – you just depend on the Maven artifact.

For the latest published version and metadata, see  
[Maven Central – `io.github.vlad-buhaescu-qoob:ontrace-sdk`](https://central.sonatype.com/artifact/io.github.vlad-buhaescu-qoob/ontrace-sdk)

The full implementation of this library is stored in a private repository.

# Introductions

Ontrace SDK provides a set of screens and functionalities that enable applications to implement user identity verification flows for **Romanian identity documents**.

The SDK guides the user through a predefined set of steps (camera-based capture and, where applicable, NFC reading) to validate Romanian identity documents.  
Please make sure you always use the latest version on Maven Central.

## Installation

### Initialize the Library: In order to be able to use the library our sales team will provide an API KEY

### Maven Central (Gradle dependency)

To integrate `OntraceSDK` into your project, add the following to your **app module** `build.gradle` (Kotlin DSL) in the `dependencies` section:

```gradle
dependencies {
    implementation("io.github.vlad-buhaescu-qoob:ontrace-sdk:0.0.36")
    // your own dependencies
}
```

## Requirements

minSdk = 24
Developed in:
    kotlin version 2.1.0
    Android Studion Ladybug

## Project setup

Here's a quick example to get started with `OntraceSDK` in a Jetpack Compose app:

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.qoobiss.ontracesdk.LibraryEntryPoint
import com.qoobiss.ontracesdk.environment.OntraceCompletionResult

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiKey = "<YOUR_API_KEY_FROM_QOOBISS>"

        setContent {
            LibraryEntryPoint(
                apiKey = apiKey,
                onMessage = { message ->
                    // Optional: show intermediate flow messages (e.g. Toast, Snackbar, Log)
                },
                onComplete = { result: OntraceCompletionResult ->
                    // Handle completion (success, cancel, error) and use result.requestId
                }
            )
        }
    }
}
```

### 📸 Required permissions in the client app

To ensure your application can use the camera (the SDK will drive the capture flow), add the following to your **AndroidManifest.xml** file.

### 🏗 1. Declare camera feature
Add the following `<uses-feature>` tag to indicate that your app can use the camera:

```xml
<uses-feature
    android:name="android.hardware.camera"
    android:required="false" />
```

### 2. Request camera permission

```xml
<uses-permission android:name="android.permission.CAMERA" />
```

### 🪪 NFC setup for clients

The SDK already declares the required NFC permission and feature flags in its own manifest:

```xml
<!-- Inside the SDK's manifest (already provided by the dependency) -->
<uses-permission android:name="android.permission.NFC" />
<uses-feature
    android:name="android.hardware.nfc"
    android:required="false" />
```

**As a client you do not need to add extra NFC permissions or `<uses-feature>` entries** to use the NFC flow.  
You only need to ensure that:

- The device has NFC hardware and NFC is enabled in system settings when the NFC step is used.
- Your UX explains to the user what to do if NFC is unavailable or turned off (optional but recommended).

### Running on devices and simulators

The sdk is made to build together with the client app for both physical devices and simulators but there the user is able to complete the flow only on a real device due to hardware limitations for front camera usage.

### Results

The `onMessage` callback will be called every time there is a new state to transition to.

There are two scenarios for completing the flow and getting a callback from `onCompleteResult` :

Scenario 1: The user cancels the process on the landing page or the second page (Terms and Conditions).
Scenario 2: The user successfully completes the entire flow.

The response is of type OntraceCompletionResult. This response contains a requestId and using this API

Example:
https://qoobiss.com/validation/identity/shortresult?orderId=`requestId`

This will return an encrypted result.

Please make sure you always use the latest version.

