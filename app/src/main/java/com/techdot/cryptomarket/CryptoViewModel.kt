package com.techdot.cryptomarket

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techdot.cryptomarket.network.CryptoApi
import com.techdot.cryptomarket.network.CryptoMarket
import com.techdot.cryptomarket.network.CryptoModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

enum class CryptoApiStatus {LOADING, ERROR, DONE}

class CryptoViewModel : ViewModel() {

    private var _cryptoData = MutableLiveData<List<CryptoModel>>()

    val cryptoData: LiveData<List<CryptoModel>>
    get() = _cryptoData

    private val _status = MutableLiveData<CryptoApiStatus>()

    val status: LiveData<CryptoApiStatus>
        get() = _status

    init {
        getCryptoData()
    }

    private fun getCryptoData() {
        _status.value = CryptoApiStatus.LOADING
        viewModelScope.launch {
            try {
                _status.value = CryptoApiStatus.DONE
                _cryptoData.value = CryptoApi.retrofitService.getCryptoData().markets
                Log.v("TEST_DATA_SIZE", cryptoData.value!!.size.toString())
            } catch (t: Throwable) {
                _status.value = CryptoApiStatus.ERROR
                _cryptoData.value = ArrayList()
                Log.v("CRYPTO_ERROR", "AN ERROR OCCURRED")
                t.printStackTrace()
            }
        }
    }


}