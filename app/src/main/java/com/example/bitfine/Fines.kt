package com.example.bitfine

data class Fines(
    var name: String ?= null,
    var licence: String ?= null,
    var nic: String ?= null,
    var dob: String ?= null,
    var fineId: String ?= null,
    var fineType: String ?= null,
    var fineValue: String ?= null
)
