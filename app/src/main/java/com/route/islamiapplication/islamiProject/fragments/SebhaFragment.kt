package com.route.islamiapplication.islamiProject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.route.islamiapplication.Constants
import com.route.islamiapplication.R
import com.route.islamiapplication.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {
    lateinit var viewBinding : FragmentSebhaBinding
    lateinit var iv_sebha : ImageView
    lateinit var tv_counter : TextView
    lateinit var tv_convert : TextView

    var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentSebhaBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_sebha = viewBinding.bodyOfSebha
        tv_counter = viewBinding.counter
        tv_convert = viewBinding.azkar


        tv_counter.text = "$counter"
        counter++

        iv_sebha.setOnClickListener {
            onClickSebhaImage()
        }
    }

    fun onClickSebhaImage(){
        iv_sebha.rotation =iv_sebha.rotation+5
        tv_convert.text = Constants.SOBHANALLAH

        if (counter >= 1 && counter <= 33){
            tv_convert.text = Constants.SOBHANALLAH
            tv_counter.text = "$counter"
        }
        else if(counter >= 34 && counter <= 66){
            tv_convert.text = Constants.Elhamdllah
            tv_counter.text = "$counter"
        }
        else if(counter >= 67 && counter <= 99){
            tv_convert.text = Constants.ALLAHAKBAR
            tv_counter.text = "$counter"
        }

        if(counter == 100) counter = 0

        if (counter == 0){
            tv_convert.text = Constants.ELKATEMA
            tv_counter.text = "$counter"
        }
        counter++

}
}