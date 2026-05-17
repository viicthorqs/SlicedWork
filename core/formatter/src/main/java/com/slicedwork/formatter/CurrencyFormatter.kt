package com.slicedwork.formatter

import java.text.NumberFormat

fun Double.asCurrency(): String = NumberFormat.getCurrencyInstance().format(this)
