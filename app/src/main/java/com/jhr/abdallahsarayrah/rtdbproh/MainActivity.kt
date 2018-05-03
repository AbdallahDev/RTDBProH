package com.jhr.abdallahsarayrah.rtdbproh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rtdb = FirebaseDatabase.getInstance().reference

        button2.setOnClickListener {
            rtdb.child("rtdbproh").child("users").child("abdallah")
                    .setValue(editText.text.toString())
            editText.text.clear()
        }

        rtdb.child("rtdbproh").child("users").child("abdallah").addValueEventListener(
                object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError?) {

                    }

                    override fun onDataChange(p0: DataSnapshot?) {
                        editText.setText(p0?.value.toString())
                    }
                }
        )
    }
}
