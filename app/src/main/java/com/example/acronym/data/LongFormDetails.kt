package com.example.acronym.data

import java.io.Serializable

data class LongFormDetails (val lf: String,
                            val freq: Int,
                            val since: Int): Serializable