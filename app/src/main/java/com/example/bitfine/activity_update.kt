package com.example.bitfine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bitfine.databinding.ActivityUpdateBinding
import com.google.firebase.database.*

class activity_update : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var updateRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener {
            var name = binding.edtName.text.toString()
            var licence = binding.edtLicence.text.toString()
            var nic = binding.edtNic.text.toString()
            var dob = binding.edtDob.text.toString()
            var fineID = binding.edtFineId.text.toString()
            var fineType = binding.edtFineType.text.toString()
            var fineValue = binding.edtValue.text.toString()

            updateData(name, licence, nic, dob, fineID, fineType, fineValue)
        }
    }

    private fun updateData(
        name: String,
        licence: String,
        nic: String,
        dob: String,
        fineID: String,
        fineType: String,
        fineValue: String
    ) {
        updateRef = FirebaseDatabase.getInstance().getReference("Fines")
        val fine = mapOf<String, String>(
            "Name" to name,
            "Licence" to licence,
            "NIC" to nic,
            "DOB" to dob,
            "FineID" to fineID,
            "FineType" to fineType,
            "FineValue" to fineValue
        )

        updateRef.child(fineID).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Record exists, update it
                    updateRef.child(fineID).setValue(fine).addOnSuccessListener {
                        // Data updated successfully
                        Toast.makeText(this@activity_update, "Data updated", Toast.LENGTH_SHORT)
                            .show()
                        binding.edtName.text.clear()
                        binding.edtLicence.text.clear()
                        binding.edtNic.text.clear()
                        binding.edtDob.text.clear()
                        binding.edtFineId.text.clear()
                        binding.edtFineType.text.clear()
                        binding.edtValue.text.clear()
                    }.addOnFailureListener {
                        // Failed to update data
                    }
                } else {
                    // Record does not exist, show error message
                    Toast.makeText(
                        this@activity_update,
                        "Record does not exist",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors here
            }
        })
    }
}