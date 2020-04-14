package com.byfrunze.motozip.auth.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.byfrunze.motozip.R
import com.byfrunze.motozip.auth.presenters.SignInPresenter
import com.byfrunze.motozip.auth.views.SignInView
import com.byfrunze.motozip.content.NavActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter


class LoginActivity : MvpAppCompatActivity(), SignInView {

    lateinit var mAuth: FirebaseAuth

    @InjectPresenter
    lateinit var signInPresenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()


        btn_entered_sign_in.setOnClickListener {
            val nameUser = edt_email_sign_in.text.toString()
            val passwordUser = edt_password_sign_in.text.toString()
            signInPresenter.signInUser(nameUser = nameUser, passwordUser = passwordUser)

        }
    }

    override fun signInSuccessfully() {
        cpv_sign_in_loader.visibility = View.GONE
        MaterialDialog(this).show {
            title(R.string.successfull)
            icon(R.drawable.ic_check)
        }
        Handler().postDelayed({
            startActivity(Intent(this, NavActivity::class.java))
        }, 2000)
    }

    override fun signInError(textError: String) {
        cpv_sign_in_loader.visibility = View.GONE
        MaterialDialog(this).show {
            title(R.string.error)
            message(text = textError)
            icon(R.drawable.ic_uncheck)
        }
        edt_email_sign_in.isEnabled = true
        edt_password_sign_in.isEnabled = true
    }

    override fun signInLoading() {
        edt_email_sign_in.isEnabled = false
        edt_password_sign_in.isEnabled = false
        cpv_sign_in_loader.visibility = View.VISIBLE
    }
}
