/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.dagger.registration

import android.util.Log
import com.example.android.dagger.BuildConfig
import com.example.android.dagger.di.ActivityScope
import com.example.android.dagger.user.UserManager
import javax.inject.Inject

/**
 * RegistrationViewModel is the ViewModel that the Registration flow ([RegistrationActivity]
 * and fragments) uses to keep user's input data.
 */
@ActivityScope
class RegistrationViewModel @Inject constructor(val userManager: UserManager) {

    private var username: String? = null
    private var password: String? = null
    private var acceptedTCs: Boolean? = null

    fun updateUserData(username: String, password: String) {
        this.username = username
        this.password = password
    }

    fun acceptTCs() {
        acceptedTCs = true
    }

    fun registerUser() {
        if (BuildConfig.DEBUG && username == null) {
            error("Assertion failed")
        }
        Log.i("RegistrationViewModel", "1")
        if (BuildConfig.DEBUG && password == null) {
            error("Assertion failed")
        }
        Log.i("RegistrationViewModel", "2")
        if (BuildConfig.DEBUG && acceptedTCs != true) {
            error("Assertion failed")
        }
        Log.i("RegistrationViewModel", "3")

        if (userManager == null) {
            Log.i("RegistrationViewModel", "4")
        }
        userManager.registerUser(username!!, password!!)
    }
}
