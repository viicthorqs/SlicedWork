package com.slicedwork.designsystem.ext

import java.text.NumberFormat

fun Double.asCurrency(): String = NumberFormat.getCurrencyInstance().format(this)
