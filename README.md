# Ontrace SDK (Public Metadata Repo)

This repository contains metadata and documentation for the `ontrace-sdk` Android library, which is available on Maven Central.

For usage instructions, see: [Maven Central](https://central.sonatype.com/artifact/io.github.vlad-buhaescu-qoob/ontrace-sdk)

The full implementation of this library is stored in a private repository.

# Introductions

Ontrace SDK provides a set of screens and functionalities that enable applications to implement user identity verification flow for the romanian identity cards.
It comes with a predefined set of steps that will guide the user to validate his id.
Please make sure you always use the latest version on Maven Central.

## Installation

### Initialize the Library: In order to be able to use the library our sales team will provide an API KEY

### Maven Central

To integrate `OntraceSDK` into your project, add the following to your module `gradle` file in the dependencies section:

```gradle
dependencies {
	implementation("io.github.vlad-buhaescu-qoob:ontrace-sdk:0.0.32")
    // your own dependencies	
}
```

## Requirements

minSdk = 24
Developed in:
    kotlin version 2.1.0
    Android Studion Ladybug

## Project setup

Here's a quick example to get started with `OntraceSDK`:

### 📸 Adding Required Permissions

To ensure your application can use the camera, add the following permissions to your **AndroidManifest.xml** file.

### 🏗 1. Declare Camera Feature
Add the following `<uses-feature>` tag to indicate that your app **can use the camera**, but it is **not required** for the app to function:

```xml
<uses-feature
    android:name="android.hardware.camera"
    android:required="true" />
```
### 2. Request Camera Permission

```xml
<uses-permission android:name="android.permission.CAMERA" />
```


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

