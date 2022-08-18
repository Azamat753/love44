package com.siroca.lovecalculator44

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.siroca.lovecalculator44.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getLiveLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLoveModel(firstName, secondName)
    }
}