package com.example.offlinecacheretrohilt.utils


import kotlinx.coroutines.flow.*

inline fun <ResultType,RequestType> networkBoundResours(
   crossinline query: ()->Flow<ResultType>,
    crossinline fetch: suspend ()-> RequestType,
   crossinline saveFetchResult:suspend (RequestType)->Unit,
  crossinline  shouldFetch:(ResultType)->Boolean={ true }
) = flow {
    val data = query().first()

    val flow=
    if (shouldFetch(data)) {
        emit(Resourse.Loadibg(data))
        try {
            saveFetchResult(fetch())
            query().map { Resourse.Success(it) }
        } catch (throable: Throwable) {
            query().map { Resourse.Error(throable, it) }
        }


    } else {
        query().map { Resourse.Success(it) }
    }
    emitAll(flow)
}


