package cl.uct.cedest.conteocelulas.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies
import cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos
import cl.uct.cedest.conteocelulas.Model.CaracteristicaPlaquetas
import cl.uct.cedest.conteocelulas.Model.Conteo
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_CONTEO
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_HEMATIES
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_LEUCOCITOS
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_PLAQUETAS
import kotlinx.android.synthetic.main.activity_caracteristica_hematies.*

class CaracteristicaHematies : BaseActivity() {

    var hematies = CaracteristicaHematies(0,0,0,0,0);
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_HEMATIES, hematies)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caracteristica_hematies)

        val conteo = intent.getParcelableExtra<Conteo>(EXTRA_CONTEO)
        val plaquetas = intent.getParcelableExtra<CaracteristicaPlaquetas>(EXTRA_PLAQUETAS)
        val leucocitos = intent.getParcelableExtra<CaracteristicaLeucocitos>(EXTRA_LEUCOCITOS)

        if (macrocitosis1Chck.isChecked){
            hematies.macrocitosis = 1
        }


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            hematies = savedInstanceState.getParcelable(EXTRA_HEMATIES)

        }
    }
}
