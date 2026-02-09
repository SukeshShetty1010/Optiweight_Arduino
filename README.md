# Optiweight

Optiweight is a comprehensive system designed to monitor a vehicle's weight distribution and tilt in real-time. It utilizes a network of Arduino-based sensors to collect data and an Android application to provide intuitive visualizations, ensuring proper loading and enhanced safety.

## Table of Contents

- [Features](#features)
- [System Architecture](#system-architecture)
- [File Descriptions](#file-descriptions)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Disclaimer](#disclaimer)
- [License](#license)

## Features

- **Real-time Weight Monitoring:** Measures weight from four individual load cells placed at different points on a vehicle.
- **Tilt and Angle Detection:** An MPU6050 gyroscope and accelerometer module tracks the vehicle's tilt and orientation.
- **Centralized Data Backend:** All sensor data is streamed to a Firebase Realtime Database for easy access.
- **Android Application for Visualization:**
    - **Heatmap:** A 2x2 grid that visually represents the weight distribution across the four load cells, with colors indicating the load on each sensor.
    - **Gyromap:** A visual representation of the vehicle's tilt, helping to identify uneven surfaces or imbalanced loads.
    - **Roadmap:** A map view, likely intended to show the vehicle's location or route.

## System Architecture

The Optiweight system is composed of three main parts:

1.  **Hardware (Arduino/ESP8266):**
    - An **ESP8266** microcontroller serves as the brain for the sensor units.
    - A **MPU6050** sensor module captures gyroscope and accelerometer data.
    - Four **HX711** amplifiers are connected to load cells to measure weight.
    - The devices connect to a WiFi network to send data to the cloud.

2.  **Backend (Cloud):**
    - **Firebase Realtime Database** is used as the central data store, acting as a bridge between the hardware sensors and the Android application.

3.  **Frontend (Android Application):**
    - An Android app that connects to Firebase to retrieve and display the sensor data in a user-friendly interface.

## File Descriptions

This project contains the following files:

-   `Gyro_final.ino`: Arduino sketch for the MPU6050 gyroscope/accelerometer. It reads the sensor data and sends it to Firebase.
-   `load cell 1.ino` / `load cell 2.ino` / `load cell 3.ino` / `load cell 4.ino`: Arduino sketches for each of the four load cells. They read weight data from the HX711 amplifier and send it to Firebase.
-   `Optiweight_Main_Page_code.java`: The XML layout for the main screen of the Android app, which provides navigation to the different visualization pages.
-   `Optiweight_HeatMap_Page_code.java`: The XML layout for the "Heatmap" visualization, displaying the 2x2 weight grid.
-   `Optiweight_GyroMap_Page_code.java`: The XML layout for the "Gyromap" visualization, which shows the vehicle's tilt.
-   `Optiweight_RoadMap_Page_code.java`: The XML layout for the "Roadmap" view.
-   `About Optiweight_Arduino.pdf`: A document likely containing additional details about the Arduino setup.

## Setup and Installation

### Arduino

1.  **Libraries:** Ensure you have the following Arduino libraries installed:
    -   `Wire`
    -   `ESP8266WiFi`
    -   `FirebaseArduino`
    -   `HX711`

2.  **Credentials:** Before uploading the sketches, you **must** update the following placeholder values in each `.ino` file:
    -   `FIREBASE_HOST`: Your Firebase project URL.
    -   `FIREBASE_AUTH`: Your Firebase authentication token.
    -   `WIFI_SSID`: Your WiFi network name.
    -   `WIFI_PASSWORD`: Your WiFi password.

3.  **Hardware Setup:**
    -   Connect the MPU6050 and HX711 load cell amplifiers to your ESP8266 according to the pin configurations defined in the sketches.
    -   Each `.ino` file is intended for a separate ESP8266 device, one for the gyroscope and one for each of the four load cells.

### Android

The files provided are the XML **layout files** for an Android application. To build a functional app, you will need to:
1.  Create a new Android Studio project.
2.  Add these layout files to the `res/layout` directory.
3.  Implement the corresponding Java/Kotlin activities to handle the logic for:
    -   Connecting to Firebase.
    -   Reading the sensor data in real-time.
    -   Updating the UI elements (Heatmap colors, Gyromap position, etc.) dynamically.

## Usage

1.  **Deploy Hardware:** Install the configured Arduino devices and sensors onto the vehicle.
2.  **Power On:** Power up the ESP8266 devices. They will automatically connect to the configured WiFi network and start streaming data to Firebase.
3.  **Monitor with App:** Open the Optiweight Android application to view the real-time weight distribution and tilt of the vehicle.

## Disclaimer

-   **Security:** The current sketches contain hardcoded WiFi and Firebase credentials. For a production environment, it is strongly recommended to use a more secure method for storing and accessing these secrets, such as using configuration files that are not checked into version control or using a secrets management system.
-   **Incomplete Android Code:** This repository only contains the UI layout files for the Android application, not the functional Java/Kotlin code required to make the app work.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.