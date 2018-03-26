package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos
import cl.uct.cedest.conteocelulas.Model.CaracteristicaPlaquetas
import cl.uct.cedest.conteocelulas.Model.Conteo
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_CONTEO
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_HEMATIES
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_LEUCOCITOS
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_PLAQUETAS
import kotlinx.android.synthetic.main.activity_caracteristica_leucocitos.*

class CaracteristicaLeucocitos : BaseActivity() {


    var leucocitos = CaracteristicaLeucocitos("")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAQUETAS, leucocitos)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caracteristica_leucocitos)

        val conteo = intent.getParcelableExtra<Conteo>(EXTRA_CONTEO)
        val hematies = intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies>(EXTRA_HEMATIES)
        if(intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos>(EXTRA_LEUCOCITOS) != null){
            leucocitos = intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos>(EXTRA_LEUCOCITOS)
        }
        val    plaquetas = intent.getParcelableExtra<CaracteristicaPlaquetas>(EXTRA_PLAQUETAS)

        continuarLeucoBtn.setOnClickListener(){
            leucocitos.caracteristica = caracteristicaTxt.text.toString()

            val carac = Intent(this, CaracteristicaMain::class.java)
            carac.putExtra(EXTRA_HEMATIES, hematies)
            carac.putExtra(EXTRA_PLAQUETAS, plaquetas)
            carac.putExtra(EXTRA_LEUCOCITOS, leucocitos)
            carac.putExtra(EXTRA_CONTEO, conteo)

            startActivity(carac)
        }


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            leucocitos = savedInstanceState.getParcelable(EXTRA_LEUCOCITOS)

        }
    }
}
