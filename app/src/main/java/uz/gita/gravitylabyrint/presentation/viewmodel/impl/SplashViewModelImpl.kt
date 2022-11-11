package uz.gita.gravitylabyrint.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.gravitylabyrint.domain.usecase.SplashUseCase
import uz.gita.gravitylabyrint.presentation.viewmodel.SplashViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val useCase: SplashUseCase
) : ViewModel(), SplashViewModel {
    override val openNextScreenLiveData = MutableLiveData<Unit>()

    init {
        useCase.loadMap().onEach {
            delay(2000)
            openNextScreenLiveData.value = Unit
        }.launchIn(viewModelScope)
    }
}