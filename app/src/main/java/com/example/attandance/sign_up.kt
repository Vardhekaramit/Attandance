package com.example.attandance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.attandance.databinding.ActivityPunchBinding
import com.example.attandance.databinding.ActivitySignUpBinding

class sign_up : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var db : Dbh
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.button.setOnClickListener {
            val uname = binding.editTextText.text.toString()
            val pass = binding.editTextText3.text.toString()
            val email = binding.editTextText2.text.toString()
            val repass = binding.editTextText4.text.toString()
            val db = Dbh(this)

           val savedata = db.insertdata(uname,pass)

           if(TextUtils.isEmpty(uname) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(email) || TextUtils.isEmpty(repass) ){
               Toast.makeText(this,"Please add the all detail", Toast.LENGTH_LONG).show()
           }
           else{
               if(pass.equals(repass)){
                   if(savedata == true){
                       Toast.makeText(this,"Sign up successfull", Toast.LENGTH_LONG).show()
                       val intent = Intent(applicationContext, MainActivity::class.java)
                       startActivity(intent)
                   }else{
                       Toast.makeText(this,"User exists", Toast.LENGTH_LONG).show()
                   }

               }
               else{
                   Toast.makeText(this,"Password not match", Toast.LENGTH_LONG).show()
               }
           }

       }


    }
}