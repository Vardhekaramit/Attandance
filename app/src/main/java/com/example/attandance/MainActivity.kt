package com.example.attandance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.attandance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var dbh: Dbh
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.button11.setOnClickListener {
            val intent = Intent(this,sign_up::class.java)
            startActivity(intent)
        }
        dbh = Dbh(this)

        binding.button10.setOnClickListener {
            val user = binding.editTextText8.text.toString()
            val pas = binding.editTextText9.text.toString()

            if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pas)){
                Toast.makeText(this,"Add username or password", Toast.LENGTH_LONG).show()

            }
            else{

                val checkuser =  dbh.checkuserpass(user,pas)
                if(checkuser == true){
                    Toast.makeText(this,"Login successfull",Toast.LENGTH_LONG).show()
                    val intent = Intent(this,punch::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Wrong username or password",Toast.LENGTH_LONG).show()
                }
            }
        }


    }
}