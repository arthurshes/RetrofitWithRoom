package com.example.offlinecacheretrohilt.utils

sealed class Resourse <T>(
    val data: T?=null,
    val error:Throwable?=null
 ){
    class Success<T>(data:T):Resourse<T>(data)

    class Loadibg<T>(data:T?=null):Resourse<T>(data)

    class Error<T>(throwable:Throwable,data:T?=null):Resourse<T>(data,throwable)

}