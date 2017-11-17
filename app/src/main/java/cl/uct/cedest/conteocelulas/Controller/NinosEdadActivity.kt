package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.os.Bundle
import cl.uct.cedest.conteocelulas.R
import kotlinx.android.synthetic.main.activity_ninos_edad.*

class NinosEdadActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ninos_edad)

        recienNacidoBtn.setOnClickListener {
            val const = Intent(this, ConstantesActivity::class.java)
            startActivity(const)
        }
        doceMesesBtn.setOnClickListener {
            val const = Intent(this, ConstantesActivity::class.java)
            startActivity(const)
        }
        cuatroAnosBtn.setOnClickListener {
            val const = Intent(this, ConstantesActivity::class.java)
            startActivity(const)
        }
        dieciseisAnosBtn.setOnClickListener {
            val const = Intent(this, ConstantesActivity::class.java)
            startActivity(const)
        }
    }
}
