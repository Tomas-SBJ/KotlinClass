package br.com.alura.gameapi.data

abstract class DAO <TModel> {
    abstract fun getList(): List<TModel>
    abstract fun create(tModel: TModel)
}