package uz.gita.gravitylabyrint.presentation.viewmodel

import androidx.lifecycle.MutableLiveData

interface GameViewModel {

    val mapByLevelLiveData: MutableLiveData<Array<Array<Int>>>

    fun loadByLevel(level: Int)
}