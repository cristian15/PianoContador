package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cl.uct.cedest.conteocelulas.Model.*
import cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies
import cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.*
import kotlinx.android.synthetic.main.activity_caracteristica_hematies.*

class CaracteristicaHematies : BaseActivity() {

    var hematies = CaracteristicaHematies(0,0,0,0,0,0,0);
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
        val paciente = intent.getParcelableExtra<Paciente>(EXTRA_PACIENTE)

        continuarHematiesBtn.setOnClickListener(){

            if (normocitosisChck.isChecked){
                hematies.normocitosis = 1
            }
            if (normocromiaChck.isChecked){
                hematies.normocromia = 1
            }

            if (macrocitosis1Chck.isChecked){
                hematies.macrocitosis = 1
            }
            if (macrocitosis2Chck.isChecked){
                hematies.macrocitosis = 2
            }
            if (macrocitosis3Chck.isChecked){
                hematies.macrocitosis = 3
            }

            if (microcitosis1Chck.isChecked){
                hematies.microcitosis = 1
            }
            if (microcitosis2Chck.isChecked){
                hematies.microcitosis = 2
            }
            if (microcitosis3Chck.isChecked){
                hematies.microcitosis = 3
            }

            if(anisocromia1Chck.isChecked){
                hematies.anisocitosis = 1
            }
            if(anisocromia2Chck.isChecked){
                hematies.anisocitosis = 2
            }
            if(anisocromia3Chck.isChecked){
                hematies.anisocitosis = 3
            }

            if (hipocromia1Chck.isChecked){
                hematies.hipocromia = 1
            }
            if (hipocromia2Chck.isChecked){
                hematies.hipocromia = 2
            }
            if (hipocromia3Chck.isChecked){
                hematies.hipocromia = 3
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
            hematies = savedInstanceState.getParcelable(EXTRA_HEMATIES)
        }
    }
}
