package uz.gita.gravitylabyrint.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.gravitylabyrint.domain.repository.AppRepository
import uz.gita.gravitylabyrint.domain.repository.impl.AppRepositoryImpl

@[Module InstallIn(SingletonComponent::class)]
interface RepositoryModule {

    @Binds
    fun getAppRepository(impl: AppRepositoryImpl): AppRepository
}