package com.example.listadesejo

class ListaCores {
    private lateinit var colorList: ArrayList<Cor>

    init {
        this.colorList = arrayListOf();
    }

    fun add(colorConfig: Cor) {
        this.colorList.add(colorConfig)
    }

    fun remove(colorConfig: Cor) {
        this.colorList.remove(colorConfig)
    }

    fun replace(colorConfig: Cor) {
        val foundColorConfig = this.colorList.find { it.id == colorConfig.id  }
        val index = this.colorList.indexOf(foundColorConfig)

        this.colorList.set(index, colorConfig)
    }

    operator fun get(index: Int): Cor {
        return this.colorList[index]
    }

    fun get(): ArrayList<Cor> {
        return this.colorList
    }

    fun set(colors: ArrayList<Cor>) {
        this.colorList = colors
    }

    fun count(): Int {
        return this.colorList.count()
    }
}