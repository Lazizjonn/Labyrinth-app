package uz.gita.gravitylabyrint.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.gravitylabyrint.domain.usecase.GameUseCase
import uz.gita.gravitylabyrint.presentation.viewmodel.GameViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModelImpl @Inject constructor(
    private val useCase: GameUseCase
) : ViewModel(), GameViewModel {
    override val mapByLevelLiveData = MutableLiveData<Array<Array<Int>>>()

    override fun loadByLevel(level: Int) {
        useCase.getMapByLevel(level).onEach {
            mapByLevelLiveData.value = it
        }.launchIn(viewModelScope)
    }



}