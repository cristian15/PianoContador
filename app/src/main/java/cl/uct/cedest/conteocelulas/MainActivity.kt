package cl.uct.cedest.conteocelulas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ninosBtn.setOnClickListener{
            val ninos = Intent(this, NinosEdadActivity::class.java)
            startActivity(ninos)
        }
    }
}
