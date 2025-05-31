package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverterApp()
                }
            }
        }
    }
}

@Composable
fun UnitConverterApp() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Unit Converter",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(32.dp))
        ConversionTypeSelector()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversionTypeSelector() {
    val conversionTypes = listOf("Length", "Weight", "Temperature", "Volume")
    var expanded by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf(conversionTypes[0]) }

    Column {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedType,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                label = { Text("Conversion Type") }
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                conversionTypes.forEach { type ->
                    DropdownMenuItem(
                        text = { Text(type) },
                        onClick = {
                            selectedType = type
                            expanded = false
                        }
                    )
                }
            }
        }

        when (selectedType) {
            "Length" -> LengthConverter()
            "Weight" -> WeightConverter()
            "Temperature" -> TemperatureConverter()
            "Volume" -> VolumeConverter()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LengthConverter() {
    val units = listOf("Meters", "Feet", "Inches", "Centimeters")
    var inputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf(units[0]) }
    var outputUnit by remember { mutableStateOf(units[1]) }

    val outputValue = calculateLengthConversion(inputValue, inputUnit, outputUnit)

    ConversionUI(
        inputValue = inputValue,
        onInputChange = { inputValue = it },
        inputUnit = inputUnit,
        onInputUnitChange = { inputUnit = it },
        outputValue = outputValue,
        outputUnit = outputUnit,
        onOutputUnitChange = { outputUnit = it },
        units = units
    )
}

fun calculateLengthConversion(value: String, from: String, to: String): String {
    if (value.isEmpty()) return ""
    if (from == to) return value

    return try {
        val numValue = value.toDouble()
        val result = when {
            from == "Meters" && to == "Feet" -> numValue * 3.28084
            from == "Meters" && to == "Inches" -> numValue * 39.3701
            from == "Meters" && to == "Centimeters" -> numValue * 100
            from == "Feet" && to == "Meters" -> numValue * 0.3048
            from == "Feet" && to == "Inches" -> numValue * 12
            from == "Feet" && to == "Centimeters" -> numValue * 30.48
            from == "Inches" && to == "Meters" -> numValue * 0.0254
            from == "Inches" && to == "Feet" -> numValue / 12
            from == "Inches" && to == "Centimeters" -> numValue * 2.54
            from == "Centimeters" && to == "Meters" -> numValue / 100
            from == "Centimeters" && to == "Feet" -> numValue * 0.0328084
            from == "Centimeters" && to == "Inches" -> numValue * 0.393701
            else -> numValue
        }
        "%.2f".format(result)
    } catch (e: NumberFormatException) {
        ""
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeightConverter() {
    val units = listOf("Kilograms", "Pounds", "Ounces", "Grams")
    var inputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf(units[0]) }
    var outputUnit by remember { mutableStateOf(units[1]) }

    val outputValue = calculateWeightConversion(inputValue, inputUnit, outputUnit)

    ConversionUI(
        inputValue = inputValue,
        onInputChange = { inputValue = it },
        inputUnit = inputUnit,
        onInputUnitChange = { inputUnit = it },
        outputValue = outputValue,
        outputUnit = outputUnit,
        onOutputUnitChange = { outputUnit = it },
        units = units
    )
}

fun calculateWeightConversion(value: String, from: String, to: String): String {
    if (value.isEmpty()) return ""
    if (from == to) return value

    return try {
        val numValue = value.toDouble()
        val result = when {
            from == "Kilograms" && to == "Pounds" -> numValue * 2.20462
            from == "Kilograms" && to == "Ounces" -> numValue * 35.274
            from == "Kilograms" && to == "Grams" -> numValue * 1000
            from == "Pounds" && to == "Kilograms" -> numValue * 0.453592
            from == "Pounds" && to == "Ounces" -> numValue * 16
            from == "Pounds" && to == "Grams" -> numValue * 453.592
            from == "Ounces" && to == "Kilograms" -> numValue * 0.0283495
            from == "Ounces" && to == "Pounds" -> numValue * 0.0625
            from == "Ounces" && to == "Grams" -> numValue * 28.3495
            from == "Grams" && to == "Kilograms" -> numValue / 1000
            from == "Grams" && to == "Pounds" -> numValue * 0.00220462
            from == "Grams" && to == "Ounces" -> numValue * 0.035274
            else -> numValue
        }
        "%.2f".format(result)
    } catch (e: NumberFormatException) {
        ""
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemperatureConverter() {
    val units = listOf("Celsius", "Fahrenheit", "Kelvin")
    var inputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf(units[0]) }
    var outputUnit by remember { mutableStateOf(units[1]) }

    val outputValue = calculateTemperatureConversion(inputValue, inputUnit, outputUnit)

    ConversionUI(
        inputValue = inputValue,
        onInputChange = { inputValue = it },
        inputUnit = inputUnit,
        onInputUnitChange = { inputUnit = it },
        outputValue = outputValue,
        outputUnit = outputUnit,
        onOutputUnitChange = { outputUnit = it },
        units = units
    )
}

fun calculateTemperatureConversion(value: String, from: String, to: String): String {
    if (value.isEmpty()) return ""
    if (from == to) return value

    return try {
        val numValue = value.toDouble()
        val result = when {
            from == "Celsius" && to == "Fahrenheit" -> (numValue * 9/5) + 32
            from == "Celsius" && to == "Kelvin" -> numValue + 273.15
            from == "Fahrenheit" && to == "Celsius" -> (numValue - 32) * 5/9
            from == "Fahrenheit" && to == "Kelvin" -> (numValue - 32) * 5/9 + 273.15
            from == "Kelvin" && to == "Celsius" -> numValue - 273.15
            from == "Kelvin" && to == "Fahrenheit" -> (numValue - 273.15) * 9/5 + 32
            else -> numValue
        }
        "%.2f".format(result)
    } catch (e: NumberFormatException) {
        ""
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolumeConverter() {
    val units = listOf("Liters", "Gallons", "Quarts", "Milliliters")
    var inputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf(units[0]) }
    var outputUnit by remember { mutableStateOf(units[1]) }

    val outputValue = calculateVolumeConversion(inputValue, inputUnit, outputUnit)

    ConversionUI(
        inputValue = inputValue,
        onInputChange = { inputValue = it },
        inputUnit = inputUnit,
        onInputUnitChange = { inputUnit = it },
        outputValue = outputValue,
        outputUnit = outputUnit,
        onOutputUnitChange = { outputUnit = it },
        units = units
    )
}

fun calculateVolumeConversion(value: String, from: String, to: String): String {
    if (value.isEmpty()) return ""
    if (from == to) return value

    return try {
        val numValue = value.toDouble()
        val result = when {
            from == "Liters" && to == "Gallons" -> numValue * 0.264172
            from == "Liters" && to == "Quarts" -> numValue * 1.05669
            from == "Liters" && to == "Milliliters" -> numValue * 1000
            from == "Gallons" && to == "Liters" -> numValue * 3.78541
            from == "Gallons" && to == "Quarts" -> numValue * 4
            from == "Gallons" && to == "Milliliters" -> numValue * 3785.41
            from == "Quarts" && to == "Liters" -> numValue * 0.946353
            from == "Quarts" && to == "Gallons" -> numValue * 0.25
            from == "Quarts" && to == "Milliliters" -> numValue * 946.353
            from == "Milliliters" && to == "Liters" -> numValue / 1000
            from == "Milliliters" && to == "Gallons" -> numValue * 0.000264172
            from == "Milliliters" && to == "Quarts" -> numValue * 0.00105669
            else -> numValue
        }
        "%.2f".format(result)
    } catch (e: NumberFormatException) {
        ""
    }
}

// Similar implementations for WeightConverter, TemperatureConverter, VolumeConverter
// would follow the same pattern as LengthConverter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversionUI(
    inputValue: String,
    onInputChange: (String) -> Unit,
    inputUnit: String,
    onInputUnitChange: (String) -> Unit,
    outputValue: String,
    outputUnit: String,
    onOutputUnitChange: (String) -> Unit,
    units: List<String>
) {
    Column {
        // Input Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = inputValue,
                onValueChange = onInputChange,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
                label = { Text("Input Value") }
            )

            UnitDropdown(
                selectedUnit = inputUnit,
                onUnitSelected = onInputUnitChange,
                units = units
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Output Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = outputValue,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier.weight(1f),
                label = { Text("Result") }
            )

            UnitDropdown(
                selectedUnit = outputUnit,
                onUnitSelected = onOutputUnitChange,
                units = units
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitDropdown(
    selectedUnit: String,
    onUnitSelected: (String) -> Unit,
    units: List<String>
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedUnit,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(0.4f)
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            units.forEach { unit ->
                DropdownMenuItem(
                    text = { Text(unit) },
                    onClick = {
                        onUnitSelected(unit)
                        expanded = false
                    }
                )
            }
        }
    }
}