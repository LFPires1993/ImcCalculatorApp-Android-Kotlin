package com.example.imccalculator.resources

class Constants {
    companion object {
        const val WEIGHT_ERROR = "Peso não informado"
        const val HEIGHT_ERROR = "Altura não informada"
        const val LOW = "Baixo"
        const val NORMAL = "Normal"
        const val OVERWEIGHT = "Sobrepeso"
        const val OBISITY = "Obesidade"
        fun WEIGHT_SHOW(param: String) = "Peso: ${param}KG"
        fun HEIGHT_SHOW(param: String) = "Altura: ${param}cm"
        fun IMC_SHOW(param: String) = "IMC: $param"
    }
}