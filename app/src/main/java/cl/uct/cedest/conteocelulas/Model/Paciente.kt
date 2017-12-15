package cl.uct.cedest.conteocelulas.Model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Cristian on 16/11/2017.
 */
class Paciente constructor(var tipo : String, var vcm: Float, var hcm: Float, var chcm: Float) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readFloat()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tipo)
        parcel.writeFloat(vcm)
        parcel.writeFloat(hcm)
        parcel.writeFloat(chcm)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Paciente> {
        override fun createFromParcel(parcel: Parcel): Paciente {
            return Paciente(parcel)
        }

        override fun newArray(size: Int): Array<Paciente?> {
            return arrayOfNulls(size)
        }
    }
}