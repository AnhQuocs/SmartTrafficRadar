package com.example.smarttrafficradar

import android.content.Context
import androidx.activity.ComponentActivity
import com.example.smarttrafficradar.features.system.language.data.preference.LanguagePreferenceManager
import com.example.smarttrafficradar.features.system.language.domain.model.AppLanguage
import com.example.smarttrafficradar.utils.LangUtils
import com.example.smarttrafficradar.utils.LanguageManager
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

open class BaseComponentActivity : ComponentActivity() {

    override fun attachBaseContext(newBase: Context) {
        val updatedContext = runBlocking {
            val manager = LanguagePreferenceManager(newBase)
            val lang = manager.languageFlow.firstOrNull() ?: AppLanguage.ENGLISH
            val contextWithLocale = LanguageManager.setAppLocale(newBase, lang)

            LangUtils.currentLang = lang.code

            contextWithLocale
        }
        super.attachBaseContext(updatedContext)
    }
}