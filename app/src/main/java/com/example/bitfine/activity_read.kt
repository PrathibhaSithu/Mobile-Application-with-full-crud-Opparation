package com.example.bitfine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bitfine.databinding.ActivityReadBinding
import com.example.bitfine.databinding.ActivityUpdateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class activity_read : AppCompatActivity() {
    private lateinit var binding : ActivityReadBinding
    private lateinit var readRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRead.setOnClickListener {
            val fineID : String = binding.edtRead.text.toString()
            if(fineID.isNotEmpty()){
                readData(fineID)
            }else{
                Toast.makeText(this,"please enter licence number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(fineID : String){
        readRef = FirebaseDatabase.getInstance().getReference("Fines")
        readRef.child(fineID).get().addOnSuccessListener {
            if(it.exists()){
                var name = it.child("finename").value
                var licence = it.child("licenceNum").value
                var NIC = it.child("nicnum").value
                var DOB = it.child("dobdate").value
                var fineID = it.child("fineId").value
                var fineType = it.child("fineTypes").value
                var fineValue = it.child("fineValues").value

                Toast.makeText(this,"Data read successfully",Toast.LENGTH_SHORT).show()
                binding.edtRead.text.clear()

                binding.tvName.text = name.toString()
                binding.tvLicence.text = licence.toString()
                binding.tvNic.text = NIC.toString()
                binding.tvDob.text = DOB.toString()
                binding.tvFineid.text = fineID.toString()
                binding.tvFinetype.text = fineType.toString()
                binding.tvFinevalue.text = fineValue.toString()
            }else{
                Toast.makeText(this,"Couldn't find fine", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this,"Operation Failed", Toast.LENGTH_SHORT).show()
        }
    }
}