package com.cmesamartinez.proyecto_beginkotlin.settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.cmesamartinez.proyecto_beginkotlin.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.datastore:DataStore<Preferences> by preferencesDataStore(name="settings")

class SettingsActivity : AppCompatActivity() {
    companion object {
        const val VOLUME_LVL="volume_lvl"
        const val KEY_BLUETOOTH="key_bluetooth"
        const val KEY_DARKMODE="key_darkmode"
        const val KEY_VIBRATION="key_vibration"
    }
    private lateinit var binding: ActivitySettingsBinding
    private  var firstTime: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivitySettingsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter { firstTime }.collect { settingsModel->
                if(settingsModel!=null){
                    runOnUiThread {
                        binding.switchVibration.isChecked=settingsModel.vibration
                        binding.switchDarkMode.isChecked=settingsModel.darkMode
                        binding.switchBluethoot.isChecked=settingsModel.bluetooth
                        binding.rsVolume.setValues(settingsModel.volume.toFloat())
                        firstTime=!firstTime
                    }

                }
            }
        }

        initUI()
    }

    private fun initUI() {
        binding.rsVolume.addOnChangeListener { _, value, _ ->
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }
        binding.switchBluethoot.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_BLUETOOTH,value)

            }
        }
        binding.switchDarkMode.setOnCheckedChangeListener { _, value ->
            if(value){
                enableDarkmode()
            }else{
                disabledDarkmode()
            }
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_DARKMODE,value)

            }
        }
        binding.switchVibration.setOnCheckedChangeListener { _, value ->

            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_VIBRATION,value)

            }
        }

    }

    private suspend fun saveVolume(value:Int){
        datastore.edit {preferences -> preferences[intPreferencesKey(VOLUME_LVL)]= value
        }
    }
    private suspend fun saveOptions(key:String,value:Boolean){
        datastore.edit { preferences -> preferences[booleanPreferencesKey(key)]= value
        }
    }
    private fun getSettings(): Flow<SettingsModel?> {
        return datastore.data.map{preferences ->
            SettingsModel(
                volume=preferences[intPreferencesKey(VOLUME_LVL)] ?: 50,
                bluetooth=preferences[booleanPreferencesKey(KEY_BLUETOOTH)] ?: true,
                darkMode = preferences[booleanPreferencesKey(KEY_DARKMODE)]?: false,
                vibration = preferences[booleanPreferencesKey(KEY_VIBRATION)]?: true
            )

        }
    }
    private fun enableDarkmode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }
    private fun disabledDarkmode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()

    }

}