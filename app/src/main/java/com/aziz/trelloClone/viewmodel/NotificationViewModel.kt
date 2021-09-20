package com.aziz.trelloClone.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.aziz.trelloClone.models.PushNotification
import com.aziz.trelloClone.repository.NotificationRepository
import kotlinx.coroutines.launch


class NotificationViewModel(
    private val notificationRepository: NotificationRepository
): ViewModel() {
    var message: String? = null
    fun sendNotification(notification: PushNotification) = viewModelScope.launch {
        try {
            val response = notificationRepository.postNotification(notification)
            if(response.isSuccessful){
                message = response.message()
                Log.d("Notification Success ", "Response: ${Gson().toJson(response)}")
            }else{
                message = response.errorBody().toString()
                Log.d("Notification Error", response.errorBody().toString())
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}