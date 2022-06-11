package com.example.viajes
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.viajes.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize firebase

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        //Metodos a los botenes

        binding.Login.setOnClickListener {
            login();
        }

        binding.Register.setOnClickListener {
            Register();
        }
    }

    private fun update(user: FirebaseUser?){
        if(user != null){
            val intent = Intent( this, Principal::class.java)
            startActivity(intent)
        }
    }
     public override  fun onStart(){
         super.onStart()
         val user = auth.currentUser
         update(user)
     }

    private fun login(){
        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful){
                val user = auth.currentUser
                Log.d("User Login","Success")
                update(user)
            }else{
                Log.d("User Login","Fail")
                Toast.makeText(baseContext, "Fallo", Toast.LENGTH_LONG).show()
                update(null)
            }

        }
    }

    private fun Register(){
        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful){
                val user = auth.currentUser
                Log.d("User Register","Success")
                update(user)

            }else{
                Log.d("User Register","Fail")
                Toast.makeText(baseContext, "Fallo", Toast.LENGTH_LONG).show()
                update(null)
            }

        }
    }
}




