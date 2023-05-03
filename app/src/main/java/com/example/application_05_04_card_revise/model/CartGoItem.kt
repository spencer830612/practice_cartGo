package com.example.application_05_04_card_revise.model

import java.io.Serializable
import java.time.LocalDateTime

class CartGoItem(
    var imageID: Int,
    var coachName: String,
    var className: String,
    var classComment: String,
    var classStart: String,
    var classEnd: String,
    var classCost: String,
    var classCategory: String,
    var menCount:String): Serializable