package com.example.offlinecacheretrohilt.repository

import androidx.room.withTransaction
import com.example.offlinecacheretrohilt.db.MainDb
import com.example.offlinecacheretrohilt.network.ApiService
import com.example.offlinecacheretrohilt.utils.networkBoundResours
import javax.inject.Inject

class RepoMain @Inject constructor(
    private val api:ApiService,
    private val db:MainDb
) {
    private val dao=db.getDao()

    fun getRestoran()= networkBoundResours(
        query = {
            dao.getAllrest()
        },
        fetch = {
            api.getRestaur()
        },
        saveFetchResult = {
            db.withTransaction {
                dao.deleteAllRestoran()
                dao.insertRest(it)
            }
        }

    )
}