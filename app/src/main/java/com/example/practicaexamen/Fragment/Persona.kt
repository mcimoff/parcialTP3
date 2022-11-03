package com.example.practicaexamen.Fragment

import android.os.Parcel
import android.os.Parcelable

class Persona (param1:String, param2: String, param3: Int) : Parcelable{

    var nombre : String
    var apellido: String
    var edad: Int

    init {
        this.nombre = param1
        this.apellido = param2
        this.edad = param3
    }
    constructor(parcel: Parcel) :
            this(parcel.readString().toString(),parcel.readString().toString(),parcel.readInt()) {
    }

   // override fun toString(): Mascota {
    //    return this

    //}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Persona> {
        override fun createFromParcel(parcel: Parcel): Persona {
            return Persona(parcel)
        }

        override fun newArray(size: Int): Array<Persona?> {
            return arrayOfNulls(size)
        }
    }
}