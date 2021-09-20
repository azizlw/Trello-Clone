package com.aziz.trelloClone.repository

import com.aziz.trelloClone.api.RetrofitInstance
import com.aziz.trelloClone.models.PushNotification

class NotificationRepository {
    suspend fun postNotification(notification: PushNotification) = RetrofitInstance.api.postNotification(notification)
}