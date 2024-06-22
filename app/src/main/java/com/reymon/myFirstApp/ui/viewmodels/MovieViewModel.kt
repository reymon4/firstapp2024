package com.reymon.myFirstApp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reymon.myFirstApp.data.network.entities.tmdb.rated.Result as ResultMovie
class MovieViewModel: ViewModel(){
    val movie = MutableLiveData<ResultMovie>()


}