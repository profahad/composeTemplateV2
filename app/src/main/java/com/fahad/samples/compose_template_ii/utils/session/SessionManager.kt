package com.fahad.samples.compose_template_ii.utils.session

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.fahad.samples.compose_template_ii.utils.app.BaseApp
import com.fahad.samples.compose_template_ii.models.user.CoreUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

object SessionManager {

    private val dataStore: DataStore<Preferences>
        get() = BaseApp.instance.userPreferencesDataStore

    suspend fun isLogin() = dataStore.data.firstOrNull()?.get(IS_LOGIN) ?: false

    val isLoginFlow: Flow<Boolean> = dataStore.data.map { preference ->
        preference[IS_LOGIN] ?: false
    }

    val user: Flow<CoreUser> = dataStore.data.catch {
        if (it is IOException) {
            it.printStackTrace()
            emit(emptyPreferences())
        } else {
            throw it
        }
    }.map { preference ->
        CoreUser(
            id = preference[USER_ID],
            username = preference[USER_NAME],
            accessToken = preference[ACCESS_TOKEN],
        )
    }

    suspend fun login(user: CoreUser) {
        dataStore.edit { preferences ->
            preferences[IS_LOGIN] = true
            preferences[USER_ID] = user.id ?: 0
            preferences[USER_NAME] = user.username ?: ""
            preferences[ACCESS_TOKEN] = user.accessToken ?: ""
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    private val IS_LOGIN = booleanPreferencesKey("isLogin")
    private val USER_ID = intPreferencesKey("id")
    private val USER_NAME = stringPreferencesKey("name")
    private val ACCESS_TOKEN = stringPreferencesKey("accessToken")

}