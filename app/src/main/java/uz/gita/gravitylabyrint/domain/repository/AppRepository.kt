package uz.gita.gravitylabyrint.domain.repository

interface AppRepository {
    suspend fun loadMap()
    suspend fun getMapByLevel(level: Int): Array<Array<Int>>
}