package com.example.allinoneapppractise.fragment_practice_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.allinoneapppractise.R


class BlankFragment : Fragment() {

    private lateinit var textView :TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_blank,container,false)
        return view.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val someInt = requireArguments().get("some_int")
//        view.findViewById<TextView>(R.id.tv_in_fragment).text = someInt.toString()

    }
}