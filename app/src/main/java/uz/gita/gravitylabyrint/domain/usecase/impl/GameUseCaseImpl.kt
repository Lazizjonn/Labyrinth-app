package uz.gita.gravitylabyrint.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.gravitylabyrint.domain.repository.AppRepository
import uz.gita.gravitylabyrint.domain.usecase.GameUseCase
import javax.inject.Inject

class GameUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : GameUseCase {
    override fun getMapByLevel(level: Int): Flow<Array<Array<Int>>> = flow {
        emit(repository.getMapByLevel(level))
    }.flowOn(Dispatchers.IO)


}