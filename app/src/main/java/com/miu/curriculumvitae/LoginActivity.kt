package com.miu.curriculumvitae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miu.curriculumvitae.common.Person
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    val person = Person(R.drawable.male, "Ganzorig", "Bayarsaikhan", "gbayarsaikhan@miu.edu", "Front End Developer", "+1 669 281 6496", "Dedicated and efficient full stack developer with 6+ years experience in application layers, presentation layers, and databases.")
    val KEY = "PERSON"
    val PREF = "CVPREF"

    var users = ArrayList<Person>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        users.add(person)

        val prefs = getSharedPreferences(PREF, MODE_PRIVATE)

        if (prefs.getBoolean("auth", false)) {
            val email = prefs.getString("email", "")
            if (email != null) {
                findUserByEmail(email)?.let { it1 -> startMainActivity(it1) }
            }
        }

        login.setOnClickListener {
            val inputEmail = et_email.text.toString()
            if (isValidated(inputEmail, et_password.text.toString())) {
                val editor = prefs.edit()

                editor.putBoolean("auth", true)
                editor.putString("email", inputEmail)
                editor.apply()

                findUserByEmail(inputEmail)?.let { it1 -> startMainActivity(it1) }

            } else {
                Toast.makeText(applicationContext, "Wrong credential", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun startMainActivity(person: Person) {
        var mainIntent = Intent(applicationContext, MainActivity::class.java)

        mainIntent.putExtra(KEY, person)
        startActivity(mainIntent)
    }

    private fun isValidated(email: String, password: String): Boolean {
        for (user in users) {
            if (user.email == email) {
                return true
            }
        }
        return false
    }

    private fun findUserByEmail(email: String): Person? {
        for (user in users) {
            if (user.email == email) {
                return user
            }
        }
        return null
    }
}