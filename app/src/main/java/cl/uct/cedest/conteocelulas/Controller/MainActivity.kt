package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.os.Bundle
import cl.uct.cedest.conteocelulas.Model.Paciente
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_PACIENTE
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    var paciente = Paciente("",0f,0f,0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adultosBtn.setOnClickListener {
            paciente.tipo = "adulto"
            val const = Intent(this, ConstantesActivity::class.java)
            const.putExtra(EXTRA_PACIENTE, paciente)


            startActivity(const)
        }
        ninosBtn.setOnClickListener{
            val ninos = Intent(this, NinosEdadActivity::class.java)
            startActivity(ninos)
        }
    }
}
