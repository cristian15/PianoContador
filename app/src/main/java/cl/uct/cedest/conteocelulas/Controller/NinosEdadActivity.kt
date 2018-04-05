package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.os.Bundle
import cl.uct.cedest.conteocelulas.Model.Paciente
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_PACIENTE
import kotlinx.android.synthetic.main.activity_ninos_edad.*

class NinosEdadActivity : BaseActivity() {

    var paciente = Paciente("",0,0f,0f,0f,0f)

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PACIENTE, paciente)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ninos_edad)

        paciente = intent.getParcelableExtra(EXTRA_PACIENTE)

        recienNacidoBtn.setOnClickListener {
            val const = Intent(this, ConstantesActivity::class.java)
            paciente.edad = 0
            const.putExtra(EXTRA_PACIENTE, paciente)
            startActivity(const)
        }
        doceMesesBtn.setOnClickListener {
            val const = Intent(this, ConstantesActivity::class.java)
            paciente.edad = 1
            const.putExtra(EXTRA_PACIENTE, paciente)
            startActivity(const)
        }
        cuatroAnosBtn.setOnClickListener {
            val const = Intent(this, ConstantesActivity::class.java)
            paciente.edad = 4
            const.putExtra(EXTRA_PACIENTE, paciente)
            startActivity(const)
        }
        dieciseisAnosBtn.setOnClickListener {
            val const = Intent(this, ConstantesActivity::class.java)
            paciente.edad = 16
            const.putExtra(EXTRA_PACIENTE, paciente)
            startActivity(const)
        }

        println("PACIENTE:!!!!!!!! : ${paciente.tipo}")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            paciente = savedInstanceState.getParcelable(EXTRA_PACIENTE)
        }
    }
}
