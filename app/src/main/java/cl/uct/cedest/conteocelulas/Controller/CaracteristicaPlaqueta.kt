package cl.uct.cedest.conteocelulas.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cl.uct.cedest.conteocelulas.Model.Conteo
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_CONTEO

class CaracteristicaPlaqueta : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caracteristica_plaqueta)

        val conteo = intent.getParcelableExtra<Conteo>(EXTRA_CONTEO)

        


    }
}
