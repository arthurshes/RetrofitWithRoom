package com.example.offlinecacheretrohilt.features.UserAdapter

import androidx.lifecycle.*
import com.example.offlinecacheretrohilt.db.Restoran
import com.example.offlinecacheretrohilt.network.ApiService
import com.example.offlinecacheretrohilt.repository.RepoMain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(repoMain: RepoMain):ViewModel() {
    val restoram=repoMain.getRestoran().asLiveData()
}