package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cl.uct.cedest.conteocelulas.Model.*
import cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies
import cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.*
import kotlinx.android.synthetic.main.activity_caracteristica_hematies.*
import kotlinx.android.synthetic.main.activity_caracteristica_main.*
import kotlinx.android.synthetic.main.activity_caracteristica_plaqueta.*

class CaracteristicaPlaqueta : BaseActivity() {

    var plaquetas = CaracteristicaPlaquetas(0,0,0,0)

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAQUETAS, plaquetas)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caracteristica_plaqueta)

        val conteo = intent.getParcelableExtra<Conteo>(EXTRA_CONTEO)
        val hematies = intent.getParcelableExtra<CaracteristicaHematies>(EXTRA_HEMATIES)
        val leucocitos = intent.getParcelableExtra<CaracteristicaLeucocitos>(EXTRA_LEUCOCITOS)
        val paciente = intent.getParcelableExtra<Paciente>(EXTRA_PACIENTE)

        continuarPlaquetasBtn.setOnClickListener {

            if(normalesChck.isChecked){
                plaquetas.macroplaquetas = 0
                plaquetas.microplaquetas = 0
            }
            if (microPlaquetasChck.isChecked){
                plaquetas.microplaquetas = 1
                plaquetas.macroplaquetas = 0
            }
            if (aumentada1Chck.isChecked){
                plaquetas.aumentadas = 1
            }
            if (aumentada2Chck.isChecked){
                plaquetas.aumentadas = 2
            }
            if (aumentada3Chck.isChecked){
                plaquetas.aumentadas = 3
            }

            if (disminuida1Chck.isChecked){
                plaquetas.disminuidas = 1
            }
            if (disminuida2Chck.isChecked){
                plaquetas.disminuidas = 2
            }
            if (disminuida3Chck.isChecked){
                plaquetas.disminuidas = 3
            }

            val carac = Intent(this, CaracteristicaMain::class.java)
            carac.putExtra(EXTRA_HEMATIES, hematies)
            carac.putExtra(EXTRA_PLAQUETAS, plaquetas)
            carac.putExtra(EXTRA_LEUCOCITOS, leucocitos)
            carac.putExtra(EXTRA_CONTEO, conteo)
            carac.putExtra(EXTRA_PACIENTE, paciente)

            startActivity(carac)
        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            plaquetas = savedInstanceState.getParcelable(EXTRA_PLAQUETAS)

        }
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
