package cl.uct.cedest.conteocelulas.Model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Cristian on 15-12-2017.
 */
class CaracteristicaHematies constructor( var anisocitosis: Int
                                          , var macrocitosis: Int
                                          , var microcitosis: Int
                                          , var anisocromia: Int
                                          , var hipocromia: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(anisocitosis)
        parcel.writeInt(macrocitosis)
        parcel.writeInt(microcitosis)
        parcel.writeInt(anisocromia)
        parcel.writeInt(hipocromia)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CaracteristicaHematies> {
        override fun createFromParcel(parcel: Parcel): CaracteristicaHematies {
            return CaracteristicaHematies(parcel)
        }

        override fun newArray(size: Int): Array<CaracteristicaHematies?> {
            return arrayOfNulls(size)
        }
    }
}