# 📱 Unit Converter App

A simple and user-friendly **Android mobile application** built using **Kotlin** and **XML** in **Android Studio** that allows users to convert units across various categories like **Temperature, Length, Weight, and Volume**.

---

## ✨ Features

- 🔄 **Real-time unit conversion** across multiple measurement categories.
- 📏 Categories include:
  - Temperature (Celsius ↔ Fahrenheit ↔ Kelvin)
  - Length (Meters, Kilometers, Inches, Feet, etc.)
  - Weight (Grams, Kilograms, Pounds, Ounces, etc.)
  - Volume (Liters, Milliliters, Gallons, etc.)
- 🎛️ **Dynamic spinners** for selecting units.
- 🧮 Accurate and instant conversion logic.
- 🔁 Reset functionality for quick input changes.
- 📱 Fully responsive and intuitive **UI with XML layout**.
- 🚫 Input validation to prevent incorrect entries.

---

## 🛠️ Technologies Used

- **Kotlin** - Primary programming language for logic and Android components
- **XML** - Layout and UI design
- **Android Studio** - IDE for Android app development
- **Material Design** - For consistent UI/UX

---

## 📸 Screenshots

> Add your app screenshots here

```bash
📍 res/layout/activity_main.xml
📍 src/main/java/com/example/unitconverter/MainActivity.kt
```

## 📂 Project Structure
```

unit-converter/
├── app/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/com/example/unitconverter/
│ │ │ │ ├── MainActivity.kt 
│ │ │ │ ├── converters/ 
│ │ │ │ │ ├── LengthConverter.kt
│ │ │ │ │ ├── WeightConverter.kt
│ │ │ │ │ ├── TemperatureConverter.kt
│ │ │ │ │ └── VolumeConverter.kt
│ │ │ │ ├── components/
│ │ │ │ │ ├── UnitDropdown.kt
│ │ │ │ │ └── ConversionUI.kt
│ │ │ │ ├── utils/
│ │ │ │ │ └── Calculations.kt
│ │ │ │ └── ui/
│ │ │ │ ├── theme/
│ │ │ │ │ ├── Color.kt
│ │ │ │ │ ├── Theme.kt
│ │ │ │ │ └── Type.kt
│ │ │ ├── res/
│ │ │ │ ├── values/
│ │ │ │ │ ├── strings.xml
│ │ │ │ │ ├── colors.xml
│ │ │ │ │ └── themes.xml
│ │ │ │ └── ...
│ ├── build.gradle
│
├── gradle/
└── build.gradle

```
