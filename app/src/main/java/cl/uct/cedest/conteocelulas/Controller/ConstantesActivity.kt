package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.os.Bundle
import cl.uct.cedest.conteocelulas.R
import kotlinx.android.synthetic.main.activity_constantes.*

class ConstantesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constantes)
        siguienteBtn.setOnClickListener {
            val conteo = Intent(this, ConteoActivity::class.java)

            startActivity(conteo)
        }
    }
}
