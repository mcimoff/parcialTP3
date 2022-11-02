package com.example.practicaexamen

import android.os.Parcel
import android.os.Parcelable

class Persona (param1:String ) : Parcelable{

    var nombre : String

    init {
        this.nombre = param1
    }
    constructor(parcel: Parcel) : this(parcel.readString().toString()) {
    }

    override fun toString(): String {
        return this.nombre;
    }

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