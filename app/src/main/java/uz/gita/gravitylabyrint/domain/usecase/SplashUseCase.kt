package uz.gita.gravitylabyrint.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SplashUseCase {
    fun loadMap(): Flow<Unit>
}