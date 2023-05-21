package com.example.bitfine

class fine {
    private var name : String = ""
    private var licence : String = ""
    private var NIC : String = ""
    private var DOB : String = ""
    private var fineID : String = ""
    private var fineType : String = ""
    private var fineValue : String = ""

    constructor()

    fun setFinename(name : String){
        this.name = name
    }

    fun getFinename(): String{
        return name
    }

    fun setLicenceNum(licence : String){
        this.licence = licence
    }

    fun getLicenceNum(): String{
        return licence
    }

    fun setNICNum(NIC : String){
        this.NIC = NIC
    }

    fun getNICNum(): String{
        return NIC
    }

    fun setDOBDate(DOB : String){
        this.DOB = DOB
    }

    fun getDOBDate(): String{
        return DOB
    }

    fun setFineId(fineID : String){
        this.fineID = fineID
    }

    fun getFineId(): String{
        return fineID
    }

    fun setFineTypes(fineType : String){
        this.fineType = fineType
    }

    fun getFineTypes(): String{
        return fineType
    }

    fun setFineValues(fineValue : String){
        this.fineValue = fineValue
    }

    fun getFineValues(): String{
        return fineValue
    }

}