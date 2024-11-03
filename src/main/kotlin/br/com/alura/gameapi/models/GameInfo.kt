package br.com.alura.gameapi.models

data class GameInfo(val info: InfoSharkApi) {
    override fun toString(): String {
        return info.toString()
    }
}