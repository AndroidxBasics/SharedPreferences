package com.example.lubuntupc.sharedpreferences

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val PREFS_NAME = "myPrefs"
    var myPref: SharedPreferences? = null

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      
 


		saveButton.setOnClickListener {
            myPref = getSharedPreferences(PREFS_NAME, 0)
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()

            if (!TextUtils.isEmpty(enterSthId.text.toString())) {
                var message = enterSthId.text.toString()
                editor.putString("messageKey", message)
                editor.commit()
            } else {
                Toast.makeText(this, "Please enter something", Toast.LENGTH_SHORT).show()
            }


        }


        //Wyciaganie z sharedPref


        var dataBack: SharedPreferences = getSharedPreferences(PREFS_NAME, 0)

        if (dataBack.contains("messageKey")) {
            var myMessage = dataBack.getString("messageKey", "not found!")
            resultEnter.text = myMessage

        }
    }
}

