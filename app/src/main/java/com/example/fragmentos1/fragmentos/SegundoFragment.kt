package com.example.fragmentos1.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import com.example.fragmentos1.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val DEFAULT_URL = "urlPorDefault"

/**
 * A simple [Fragment] subclass.
 * Use the [SegundoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SegundoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var url: String? = null
    lateinit var wvNavigator:WebView
    lateinit var btnSearch:Button
    lateinit var etUrl:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(DEFAULT_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("url:",url!!)
        // Inflate the layout for this fragment
        val vistaNavegador = inflater.inflate(R.layout.fragment_segundo, container, false)

        wvNavigator = vistaNavegador.findViewById(R.id.wvNavigator)
        btnSearch = vistaNavegador.findViewById(R.id.btnSearch)
        etUrl = vistaNavegador.findViewById(R.id.etUrl)

        val webSettings = wvNavigator.settings
        webSettings.javaScriptEnabled = true
        wvNavigator.webViewClient = object : WebViewClient(){

        }

        wvNavigator.loadUrl(url!!)

        btnSearch.setOnClickListener {
            url = etUrl.text.toString().trim()
            if (!url!!.isEmpty()) {
                if (url!!.endsWith(".com")) {
                    url = "https://" + url
                    wvNavigator.loadUrl(url!!)
                } else {
                    url = "https://www.google.com/search?q=" + etUrl.text.toString().trim()
                    wvNavigator.loadUrl(url!!)
                }
            }
        }

        return vistaNavegador
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param url por default.
         * @return A new instance of fragment SegundoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(urlPorDefault: String) =
            SegundoFragment().apply {
                arguments = Bundle().apply {
                    putString(DEFAULT_URL, urlPorDefault)
                }
            }
    }
}