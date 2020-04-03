/**
 *  Rheem EcoNet Water Heater
 *
 *  Copyright 2020 Dominick Meglio
 *
 *	If you find this useful, donations are always appreciated 
 *	https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=7LBRPJRLJSDDN&source=url
 *
 */
 
metadata {
    definition (name: "Rheem Econet Water Heater", namespace: "dcm.rheem", author: "dmeglio@gmail.com") {
		capability "Thermostat"
		capability "Actuator"
		capability "Refresh"
		capability "Sensor"
		capability "ThermostatHeatingSetpoint"
        capability "TemperatureMeasurement"
		capability "ThermostatSetpoint"
		capability "ThermostatOperatingState"
		capability "ThermostatMode"
		
		attribute "upperTemp", "STRING"
		attribute "lowerTemp", "STRING"
		attribute "ambientTemp", "STRING"
    }
}



def refresh() {
	parent.handleRefresh(device, device.deviceNetworkId.split(":")[1])
}

def setCoolingSetpoint(temperature) {
    log.error "setCoolingSetpoint called but not supported"
}

def setSchedule(obj) {
    log.error "setSchedule called but not supported"
}

def setThermostatFanMode(fanmode) {
    log.error "setThermostatFanMode called but not supported"
}

def setHeatingSetpoint(temperature) {
	parent.handlesetHeatingSetPoint(device, device.deviceNetworkId.split(":")[1], temperature)
}

def setThermostatMode(thermostatmode) {
	parent.handlesetThermostatMode(device, device.deviceNetworkId.split(":")[1],thermostatmode)
}

def auto() {
	setThermostatMode("auto")
}

def emergencyHeat() {
	setThermostatMode("emergency heat")
}

def off() {
	setThermostatMode("off")
}

def heat() {
	setThermostatMode("heat")
}

def cool() {
	log.error "cool called but not supported"
}

def fanAuto() {
	log.error" fanAuto called but not supported"
}

def fanCirculate() {
	log.error" fanCirculate called but not supported"
}

def fanOn() {
	log.error" fanOn called but not supported"
}