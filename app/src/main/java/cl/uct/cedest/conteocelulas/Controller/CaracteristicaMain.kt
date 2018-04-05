package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cl.uct.cedest.conteocelulas.Model.CaracteristicaPlaquetas
import cl.uct.cedest.conteocelulas.Model.Conteo
import cl.uct.cedest.conteocelulas.Model.Paciente
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.*
import kotlinx.android.synthetic.main.activity_caracteristica_main.*

class CaracteristicaMain : BaseActivity() {

    var plaquetas = CaracteristicaPlaquetas(0,0,0,0)
    var leucocitos = cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos("");
    var hematies = cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies(0,0,0,0,0,0,0)


    var paciente = Paciente("",0,0f,0f,0f,0f)


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAQUETAS, plaquetas)
        outState?.putParcelable(EXTRA_PACIENTE, paciente)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caracteristica_main)

        paciente = intent.getParcelableExtra(EXTRA_PACIENTE)
        val conteo = intent.getParcelableExtra<Conteo>(EXTRA_CONTEO)


        if (intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies>(EXTRA_HEMATIES) != null){
            hematies = intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies>(EXTRA_HEMATIES)
        }

        if(intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos>(EXTRA_LEUCOCITOS) != null){
            leucocitos = intent.getParcelableExtra<cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos>(EXTRA_LEUCOCITOS)
        }
        if (intent.getParcelableExtra<CaracteristicaPlaquetas>(EXTRA_PLAQUETAS) != null){
            plaquetas = intent.getParcelableExtra<CaracteristicaPlaquetas>(EXTRA_PLAQUETAS)
        }

        hematiesBtn.setOnClickListener{
            val hemat = Intent(this,CaracteristicaHematies::class.java)
            hemat.putExtra(EXTRA_CONTEO, conteo)
            hemat.putExtra(EXTRA_PACIENTE,paciente)
            hemat.putExtra(EXTRA_LEUCOCITOS, leucocitos)
            hemat.putExtra(EXTRA_PLAQUETAS, plaquetas)

            startActivity(hemat)
        }

        plaquetasBtn.setOnClickListener{
            val plaq = Intent(this, CaracteristicaPlaqueta::class.java)
            plaq.putExtra(EXTRA_LEUCOCITOS, leucocitos)
            plaq.putExtra(EXTRA_HEMATIES, hematies)
            plaq.putExtra(EXTRA_CONTEO, conteo)
            plaq.putExtra(EXTRA_PACIENTE,paciente)

            startActivity(plaq)
        }

        leucocitosBtn.setOnClickListener {
            val leuco = Intent(this, CaracteristicaLeucocitos::class.java)
            leuco.putExtra(EXTRA_HEMATIES, hematies)
            leuco.putExtra(EXTRA_PLAQUETAS, plaquetas)
            leuco.putExtra(EXTRA_CONTEO, conteo)
            leuco.putExtra(EXTRA_PACIENTE,paciente)

            startActivity(leuco)
        }

        resultadoFinalBtn.setOnClickListener(){

            val resul = Intent(this, ResultadoFinalActivity::class.java)

            resul.putExtra(EXTRA_HEMATIES, hematies)
            resul.putExtra(EXTRA_PLAQUETAS, plaquetas)
            resul.putExtra(EXTRA_LEUCOCITOS, leucocitos)
            resul.putExtra(EXTRA_CONTEO, conteo)
            resul.putExtra(EXTRA_PACIENTE,paciente)

            startActivity(resul)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            plaquetas = savedInstanceState.getParcelable(EXTRA_PLAQUETAS)

        }
    }
}
