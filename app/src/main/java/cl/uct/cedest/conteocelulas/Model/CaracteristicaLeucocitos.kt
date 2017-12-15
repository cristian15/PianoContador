package cl.uct.cedest.conteocelulas.Model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Cristian on 15-12-2017.
 */
class CaracteristicaLeucocitos constructor(var caracteristica: String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(caracteristica)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CaracteristicaLeucocitos> {
        override fun createFromParcel(parcel: Parcel): CaracteristicaLeucocitos {
            return CaracteristicaLeucocitos(parcel)
        }

        override fun newArray(size: Int): Array<CaracteristicaLeucocitos?> {
            return arrayOfNulls(size)
        }
    }
}
