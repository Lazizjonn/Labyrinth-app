package uz.gita.gravitylabyrint.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.gravitylabyrint.domain.usecase.GameUseCase
import uz.gita.gravitylabyrint.domain.usecase.SplashUseCase
import uz.gita.gravitylabyrint.domain.usecase.impl.GameUseCaseImpl
import uz.gita.gravitylabyrint.domain.usecase.impl.SplashUseCaseImpl

@[Module InstallIn(SingletonComponent::class)]
interface UseCaseModule {

    @Binds
    fun getSplashUseCase(impl: SplashUseCaseImpl): SplashUseCase

    @Binds
    fun getGameUseCase(impl: GameUseCaseImpl): GameUseCase

}