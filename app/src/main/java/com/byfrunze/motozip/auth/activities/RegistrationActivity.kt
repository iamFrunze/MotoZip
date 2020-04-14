package com.byfrunze.motozip.auth.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.byfrunze.motozip.R
import com.byfrunze.motozip.auth.helper.FBAuth
import com.byfrunze.motozip.auth.models.DadataBody
import com.byfrunze.motozip.auth.presenters.RegPresenter
import com.byfrunze.motozip.auth.views.RegView
import com.byfrunze.motozip.content.NavActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class RegistrationActivity : MvpAppCompatActivity(), RegView {

    @InjectPresenter
    lateinit var regPresenter: RegPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btn_registration_reg.setOnClickListener {
            val userEmail = edt_email_reg.text?.trim().toString()
            val userPass1 = edt_password_reg.text?.trim().toString()
            val userPass2 = edt_password_confirm_reg.text?.trim().toString()
            regPresenter.check(email = userEmail, pass1 = userPass1, pass2 = userPass2)
        }

        btn_entered_reg.setOnClickListener {
            FBAuth.fbAuthInit().currentUser?.reload()
            if (FBAuth.fbAuthInit().currentUser?.isEmailVerified == true)
                startActivity(Intent(this, NavActivity::class.java))
            else {
                MaterialDialog(this).show {
                    title(R.string.error)
                    message(text = "Подвердите email")
                    icon(R.drawable.ic_uncheck)
                }
            }
        }
        fab_to_login_by_reg.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    override fun loading() {
        scroll_view_reg.visibility = View.GONE
        cpv_reg_loader.visibility = View.VISIBLE
    }

    override fun successfully(textSuccess: String) {
        cpv_reg_loader.visibility = View.GONE
        MaterialDialog(this).show {
            title(R.string.successfull)
            message(text = textSuccess)
            icon(R.drawable.ic_check)
        }
        btn_entered_reg.visibility = View.VISIBLE
    }


    override fun error(textError: String) {
        cpv_reg_loader.visibility = View.GONE
        MaterialDialog(this).show {
            title(R.string.error)
            message(text = textError)
            icon(R.drawable.ic_uncheck)
        }
        scroll_view_reg.visibility = View.VISIBLE
    }

}