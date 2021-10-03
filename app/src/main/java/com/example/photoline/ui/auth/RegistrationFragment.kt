package com.example.photoline.ui.auth

import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.database.CHILD_EMAIL
import com.example.photoline.database.CHILD_LOGIN
import com.example.photoline.database.registrationUser
import com.example.photoline.utils.hideBottomMenu
import com.example.photoline.utils.onFailureRegistration
import com.example.photoline.utils.onSuccessRegistration
import kotlinx.android.synthetic.main.fragment_login.btn_reg_next
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    override fun onResume() {
        super.onResume()
        hideBottomMenu()

        btn_reg_next.setOnClickListener { startRegistration() }
    }

    private fun startRegistration() {
        val login = reg_et_login.text.toString().trim()
        val email = reg_et_email.text.toString().trim()
        val password = reg_et_pass.text.toString().trim()
        // TODO: добавить валидацию вводимых данных

        val userData = mutableMapOf<String, Any>()
        userData[CHILD_LOGIN] = login
        userData[CHILD_EMAIL] = email

        registrationUser(email, password, {
            onFailureRegistration()
        }) {
            onSuccessRegistration(userData)
        }
    }
}