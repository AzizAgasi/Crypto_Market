package com.techdot.cryptomarket

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techdot.cryptomarket.adapter.CryptoAdapter
import com.techdot.cryptomarket.network.CryptoApi
import com.techdot.cryptomarket.network.CryptoMarket
import com.techdot.cryptomarket.network.CryptoModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class CryptoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cryptoAdapter: CryptoAdapter
    private var cryptoDataList: List<CryptoModel>? = emptyList<CryptoModel>()

    companion object {
        fun newInstance() = CryptoFragment()
    }

    private val viewModel: CryptoViewModel by lazy {
        ViewModelProvider(this).get(CryptoViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.crypto_fragment, container, false)

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it == CryptoApiStatus.DONE) {
                cryptoDataList = viewModel.cryptoData.value
                Log.v("CRYPTO_TEST_DATA", viewModel.cryptoData.value?.size.toString())
            }
        })

        recyclerView = view.findViewById(R.id.recyclerView)
        cryptoAdapter = CryptoAdapter(cryptoDataList, requireContext())
        recyclerView.adapter = cryptoAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return view
    }

}