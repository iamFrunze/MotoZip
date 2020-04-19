package com.byfrunze.motozip.preview.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.byfrunze.motozip.R
import com.byfrunze.motozip.auth.activities.LoginActivity
import com.byfrunze.motozip.auth.activities.RegistrationActivity
import com.byfrunze.motozip.content.NavActivity
import kotlinx.android.synthetic.main.fragment_preview_slideone.*

private const val ARG_BACKGROUND_COLOR = "param1"
private const val ARG_RESOURCE = "param2"
private const val ARG_TITLE = "param3"
private const val ARG_POS = "POS"

class PreviewSlideFragment : Fragment() {
    private var param1: Int? = null
    private var param2: Int? = null
    private var param3: String? = null
    private var param4: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_BACKGROUND_COLOR)
            param2 = it.getInt(ARG_RESOURCE)
            param3 = it.getString(ARG_TITLE)
            param4 = it.getInt(ARG_POS)

        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preview_slideone, container, false).apply {
            setBackgroundColor(param1 ?: Color.RED)

            findViewById<LottieAnimationView>(R.id.lottieAnimationView).setAnimation(
                    param2 ?: R.raw.work
            )
            findViewById<LottieAnimationView>(R.id.lottieAnimationView).repeatCount =
                    LottieDrawable.INFINITE
            findViewById<LottieAnimationView>(R.id.lottieAnimationView).repeatMode =
                    LottieDrawable.REVERSE
            findViewById<LottieAnimationView>(R.id.lottieAnimationView).playAnimation()

            findViewById<TextView>(R.id.fragment_textview).text =
                    param3 ?: "Hello fellow developer!"

        }
    }
    var pos: Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (pos == 2) {
            btn_entered_preview.visibility = View.VISIBLE
            btn_registration_preview.visibility = View.VISIBLE
            txt_skip_preview.visibility = View.VISIBLE
            btn_entered_preview.setOnClickListener {
                startActivity(Intent(activity, LoginActivity::class.java))
            }
            btn_registration_preview.setOnClickListener{
                startActivity(Intent(activity, RegistrationActivity::class.java))
            }
            txt_skip_preview.setOnClickListener{
                startActivity(Intent(activity, NavActivity::class.java))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: Int, param3: String, param4: Int) =
                PreviewSlideFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_BACKGROUND_COLOR, param1)
                        putInt(ARG_RESOURCE, param2)
                        putString(ARG_TITLE, param3)
                        putInt(ARG_POS, param4)
                        pos = param4
                    }
                }
    }
}