package com.example.bitfine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.bitfine.databinding.ActivityDeleteBinding
import com.example.bitfine.databinding.ActivityUpdateBinding
import com.google.firebase.database.*

class activity_delete : AppCompatActivity() {
    private lateinit var binding : ActivityDeleteBinding
    private lateinit var deleteRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDelete.setOnClickListener {
            var deleteFine = binding.edtDelete.text.toString()
            if(deleteFine.isNotEmpty()){
                deleteData(deleteFine)
            }else{
                Toast.makeText(this,"please enter fine ID", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteData(deleteFine: String) {
        deleteRef = FirebaseDatabase.getInstance().getReference("Fines")
        val fine = deleteRef.child(deleteFine)
        fine.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    fine.removeValue().addOnSuccessListener {
                        Toast.makeText(this@activity_delete, "Fine deleted successfully", Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                        Toast.makeText(this@activity_delete, "Operation failed", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@activity_delete, "Fine not found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@activity_delete, "Error: ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
