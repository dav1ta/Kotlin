package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Btn.setOnClickListener {
            val email: String = Email.text.toString()
            val password: String = Pass.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener{task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "მომხმარებელი წარმატებით შეიქმნა!", Toast.LENGTH_LONG).show()
                                Email.setText("")
                                Pass.setText("")
                            } else {
                                Toast.makeText(this, "დაფიქსირდა შეცდომა!", Toast.LENGTH_LONG).show()
                                Email.setText("")
                                Pass.setText("")
                            }
                        }
            }
        }
    }
}