package cl.uct.cedest.conteocelulas.Model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Cristian on 15-12-2017.
 */
class CaracteristicaPlaquetas constructor(var macroplaquetas: Int
                                          , var microplaquetas: Int
                                          , var disminuidas: Int
                                          , var aumentadas: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(macroplaquetas)
        parcel.writeInt(microplaquetas)
        parcel.writeInt(disminuidas)
        parcel.writeInt(aumentadas)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CaracteristicaPlaquetas> {
        override fun createFromParcel(parcel: Parcel): CaracteristicaPlaquetas {
            return CaracteristicaPlaquetas(parcel)
        }

        override fun newArray(size: Int): Array<CaracteristicaPlaquetas?> {
            return arrayOfNulls(size)
        }
    }
}