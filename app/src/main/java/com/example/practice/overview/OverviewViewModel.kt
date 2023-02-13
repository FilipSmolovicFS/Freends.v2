package com.example.practice.overview

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.R
import com.example.practice.network.Content
import com.example.practice.network.ContentApi
import kotlinx.coroutines.launch

class OverviewViewModel:ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _photos = MutableLiveData<List<Content>>()
    val photos : LiveData<List<Content>> = _photos

    private val _profilePic = MutableLiveData<Content>()
    val profilePic : LiveData<Content> = _profilePic

    private val _test = MutableLiveData("Username")
    val test : LiveData<String>
    get() = _test

    init {
        getContent()
    }


    private fun getContent() {

        viewModelScope.launch {
            try {
                val listResult = ContentApi.retrofitService.getPhotos()
                _profilePic.value = ContentApi.retrofitService.getPhotos()[0]
                _photos.value = ContentApi.retrofitService.getPhotos()
                _status.value = _profilePic.value!!.imgSrcUrl

            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    fun updateUser(user: String){
        _test.value = user
    }

}