package com.example.bitfine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class activity_add : AppCompatActivity() {
    private lateinit var edt_name: EditText
    private lateinit var edt_licence: EditText
    private lateinit var edt_nic: EditText
    private lateinit var edt_dob: EditText
    private lateinit var edt_fineid: EditText
    private lateinit var edt_finetype: EditText
    private lateinit var edt_finevalue: EditText

    private lateinit var btn_add : Button

    private lateinit var fineObj : fine

    private lateinit var dbRef : DatabaseReference

    private fun clearControls(){
        edt_name.setText("")
        edt_licence.setText("")
        edt_nic.setText("")
        edt_dob.setText("")
        edt_fineid.setText("")
        edt_finetype.setText("")
        edt_finevalue.setText("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        edt_name = findViewById(R.id.edt_name)
        edt_licence = findViewById(R.id.edt_licence)
        edt_nic = findViewById(R.id.edt_nic)
        edt_dob = findViewById(R.id.edt_dob)
        edt_fineid = findViewById(R.id.edt_fineId)
        edt_finetype = findViewById(R.id.edt_fineType)
        edt_finevalue = findViewById(R.id.edt_value)

        btn_add = findViewById(R.id.btn_add)

        fineObj = fine()

        dbRef = FirebaseDatabase.getInstance().getReference("Fines")

        btn_add.setOnClickListener {
            try{
                if(TextUtils.isEmpty(edt_name.text.toString()))
                    Toast.makeText(applicationContext,"please enter job name",Toast.LENGTH_SHORT).show()
                else if(TextUtils.isEmpty(edt_licence.text.toString()))
                    Toast.makeText(applicationContext,"please enter job licence number",Toast.LENGTH_SHORT).show()
                else if(TextUtils.isEmpty(edt_nic.text.toString()))
                    Toast.makeText(applicationContext,"please enter job NIC number",Toast.LENGTH_SHORT).show()
                else if(TextUtils.isEmpty(edt_dob.text.toString()))
                    Toast.makeText(applicationContext,"please enter job DOB",Toast.LENGTH_SHORT).show()
                else if(TextUtils.isEmpty(edt_fineid.text.toString()))
                    Toast.makeText(applicationContext,"please enter job fineID",Toast.LENGTH_SHORT).show()
                else if(TextUtils.isEmpty(edt_finetype.text.toString()))
                    Toast.makeText(applicationContext,"please enter job fine type",Toast.LENGTH_SHORT).show()
                else if(TextUtils.isEmpty(edt_finevalue.text.toString()))
                    Toast.makeText(applicationContext,"please enter job fine value",Toast.LENGTH_SHORT).show()
                else{
                    fineObj.setFinename(edt_name.text.toString().trim())
                    fineObj.setLicenceNum(edt_licence.text.toString().trim())
                    fineObj.setNICNum(edt_nic.text.toString().trim())
                    fineObj.setDOBDate(edt_dob.text.toString().trim())
                    fineObj.setFineId(edt_fineid.text.toString().trim())
                    fineObj.setFineTypes(edt_finetype.text.toString().trim())
                    fineObj.setFineValues(edt_finevalue.text.toString().trim())

                    var fineid = fineObj.getFineId()

                    dbRef.child(fineid).setValue(fineObj)

                    Toast.makeText(
                        applicationContext,
                        "Data saved",
                        Toast.LENGTH_SHORT
                    ).show()
                    clearControls()


                }

            }catch (e:NumberFormatException){
                Toast.makeText(applicationContext,"Invalid Input",Toast.LENGTH_SHORT).show()
            }
        }
    }
}