package cl.uct.cedest.conteocelulas.Model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Cristian on 18/11/2017.
 */
class Conteo constructor(var basofilo:Int
                         ,var eosinofilo : Int
                         ,var baciliforme : Int
                         ,var mielocitos : Int
                         ,var juveniles : Int
                         ,var segmentados : Int
                         ,var linfocitos : Int
                         ,var monocito : Int
                         ,var promielocito : Int
                         ,var mieloblasto : Int
                         ,var linfoblastos : Int
                         ,var linfocitoReactivo : Int
                         ,var prolinfocito : Int
                         ,var monoblasto : Int
                         ,var promonocito :Int
                         ,var megacarioblasto : Int
                         ,var megacariocito :Int
                         ,var micromegacariocito :Int
                         ,var micromegacarioblasto :Int
                         ,var eritoblastoBasofilo : Int
                         ,var eritoblastoPolicromatico : Int
                         ,var eritoblastoOrtocromatico :Int
                         ,var total :Int) : Parcelable {


    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(basofilo)
        parcel.writeInt(eosinofilo)
        parcel.writeInt(baciliforme)
        parcel.writeInt(mielocitos)
        parcel.writeInt(juveniles)
        parcel.writeInt(segmentados)
        parcel.writeInt(linfocitos)
        parcel.writeInt(monocito)
        parcel.writeInt(promielocito)
        parcel.writeInt(mieloblasto)
        parcel.writeInt(linfoblastos)
        parcel.writeInt(linfocitoReactivo)
        parcel.writeInt(prolinfocito)
        parcel.writeInt(monoblasto)
        parcel.writeInt(promonocito)
        parcel.writeInt(megacarioblasto)
        parcel.writeInt(megacariocito)
        parcel.writeInt(micromegacariocito)
        parcel.writeInt(micromegacarioblasto)
        parcel.writeInt(eritoblastoBasofilo)
        parcel.writeInt(eritoblastoPolicromatico)
        parcel.writeInt(eritoblastoOrtocromatico)
        parcel.writeInt(total)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Conteo> {
        override fun createFromParcel(parcel: Parcel): Conteo {
            return Conteo(parcel)
        }

        override fun newArray(size: Int): Array<Conteo?> {
            return arrayOfNulls(size)
        }
    }
}