package uz.gita.gravitylabyrint.presentation.viewmodel

import androidx.lifecycle.LiveData

interface LevelViewModel {
    val openNextScreenLiveData: LiveData<Int>

    fun openNextScreenByLevel(level: Int)
}