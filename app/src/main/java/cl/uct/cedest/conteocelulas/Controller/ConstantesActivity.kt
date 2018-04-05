package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.os.Bundle
import cl.uct.cedest.conteocelulas.Model.Paciente
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_PACIENTE
import kotlinx.android.synthetic.main.activity_constantes.*

class ConstantesActivity : BaseActivity() {

    var paciente = Paciente("",0,0f,0f,0f,0f)

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PACIENTE, paciente)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constantes)

        paciente = intent.getParcelableExtra(EXTRA_PACIENTE)

        siguienteBtn.setOnClickListener {
            val conteo = Intent(this, ConteoActivity::class.java)

            if (chcmTxt.text.length > 0){
                paciente.chcm = chcmTxt.text.toString().toFloat()
            }
            if (vcmTxt.text.length > 0){
                paciente.vcm = vcmTxt.text.toString().toFloat()
            }
            if (hcmTxt.text.length > 0){
                paciente.hcm = hcmTxt.text.toString().toFloat()
            }
            if (edeTxt.text.length > 0){
                paciente.ede = edeTxt.text.toString().toFloat()
            }

            conteo.putExtra(EXTRA_PACIENTE, paciente)

            startActivity(conteo)
        }

        println("PACIENTE!!!!!!!!!!!: ${paciente.edad} *** ${paciente.tipo}")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            paciente = savedInstanceState.getParcelable(EXTRA_PACIENTE)
        }
    }
}
