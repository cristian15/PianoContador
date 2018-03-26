package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cl.uct.cedest.conteocelulas.Model.CaracteristicaPlaquetas
import cl.uct.cedest.conteocelulas.Model.Conteo
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_CONTEO
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_HEMATIES
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_LEUCOCITOS
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_PLAQUETAS
import kotlinx.android.synthetic.main.activity_caracteristica_main.*

class CaracteristicaMain : BaseActivity() {

    var plaquetas = CaracteristicaPlaquetas(0,0,0,0)
    var leucocitos = cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos("");


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAQUETAS, plaquetas)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caracteristica_main)

        val conteo = intent.getParcelableExtra<Conteo>(EXTRA_CONTEO)
        val hematies = intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies>(EXTRA_HEMATIES)
        if(intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos>(EXTRA_LEUCOCITOS) != null){
            leucocitos = intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos>(EXTRA_LEUCOCITOS)
        }
        if (intent.getParcelableExtra<CaracteristicaPlaquetas>(EXTRA_PLAQUETAS) != null){
            plaquetas = intent.getParcelableExtra<CaracteristicaPlaquetas>(EXTRA_PLAQUETAS)
        }



        println("Plaquetas!!!!!!!!!!!!!!!!!!!!!!!!!!!!!:"+plaquetas.aumentadas);
        println("LEUCO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!:"+leucocitos.caracteristica);

        hematiesBtn.setOnClickListener{
            val hemat = Intent(this,CaracteristicaHematies::class.java)
            hemat.putExtra(EXTRA_CONTEO, conteo)
            hemat.putExtra(EXTRA_LEUCOCITOS, leucocitos)
            hemat.putExtra(EXTRA_PLAQUETAS, plaquetas)

            startActivity(hemat)
        }

        plaquetasBtn.setOnClickListener{
            val plaq = Intent(this,CaracteristicaPlaqueta::class.java)
            plaq.putExtra(EXTRA_LEUCOCITOS, leucocitos)
            plaq.putExtra(EXTRA_HEMATIES, hematies)
            plaq.putExtra(EXTRA_CONTEO, conteo)

            startActivity(plaq)
        }

        leucocitosBtn.setOnClickListener {
            val leuco = Intent(this,CaracteristicaLeucocitos::class.java)
            leuco.putExtra(EXTRA_HEMATIES, hematies)
            leuco.putExtra(EXTRA_PLAQUETAS, plaquetas)
            leuco.putExtra(EXTRA_CONTEO, conteo)

            startActivity(leuco)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            plaquetas = savedInstanceState.getParcelable(EXTRA_PLAQUETAS)

        }
    }
}
