package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies
import cl.uct.cedest.conteocelulas.Model.CaracteristicaPlaquetas
import cl.uct.cedest.conteocelulas.Model.Conteo
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_CONTEO
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_HEMATIES
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_PLAQUETAS
import kotlinx.android.synthetic.main.activity_caracteristica_hematies.*
import kotlinx.android.synthetic.main.activity_caracteristica_plaqueta.*

class CaracteristicaPlaqueta : BaseActivity() {
/*
    lateinit var conteo: Conteo
    lateinit var plaquetas: CaracteristicaPlaquetas
    lateinit var hematies: CaracteristicaHematies
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caracteristica_plaqueta)

        val conteo = intent.getParcelableExtra<Conteo>(EXTRA_CONTEO)
        val plaquetas = intent.getParcelableExtra<CaracteristicaPlaquetas>(EXTRA_PLAQUETAS)
        val hematies = intent.getParcelableExtra<CaracteristicaHematies>(EXTRA_HEMATIES)

        println("Conteo: ${conteo.eosinofilo}")

/*
        continuarBtn.setOnClickListener {
            val carac = Intent(this, CaracteristicaMain::class.java)
            carac.putExtra(EXTRA_HEMATIES, hematies)
            carac.putExtra(EXTRA_PLAQUETAS, plaquetas)
            carac.putExtra(EXTRA_CONTEO, conteo)

            startActivity(carac)
        }*/

    }
    fun continuarClick(view: View){
       /* val carac = Intent(this, CaracteristicaMain::class.java)
        carac.putExtra(EXTRA_HEMATIES, hematies)
        carac.putExtra(EXTRA_PLAQUETAS, plaquetas)
        carac.putExtra(EXTRA_CONTEO, conteo)

        startActivity(carac)*/
    }

    fun normalesClick(view: View){
        if(normalesChck.isChecked){
            macroPlaquetasChck.visibility = View.INVISIBLE
            microPlaquetasChck.visibility = View.INVISIBLE
        }
        else{
            macroPlaquetasChck.visibility = View.VISIBLE
            microPlaquetasChck.visibility = View.VISIBLE
        }
    }
}
