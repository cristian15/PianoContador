package cl.uct.cedest.conteocelulas.Controller

import android.media.MediaPlayer
import android.os.Bundle
import cl.uct.cedest.conteocelulas.R
import kotlinx.android.synthetic.main.activity_conteo.*

class ConteoActivity : BaseActivity() {

    var total = 0
    var bs=0
    var eo=0
    var mc=0
    var jv=0
    var eb=0
    var sg=0
    var lf=0
    var mn=0
    var operacion ="+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conteo)

        totalConteoTxt.text = total.toString()

        plusMinusBtn.setOnClickListener {
            if(operacion == "+"){
                operacion = "-"
                plusMinusBtn.text = operacion
            }
            else{
                operacion = "+"
                plusMinusBtn.text = operacion
            }
        }

        eoBtn.setOnClickListener {
            try {
                var mp = MediaPlayer.create( this, R.raw.eo)
                mp.start()
            }
            catch (e: Exception) {
                println(e)
            }

            if(operacion == "+"){
                total++
                eo++
            }
            else{
                if (total>0 && eo > 0){
                    total--
                    eo--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = total.toString()
            calculaTotales()

        }

        bsBtn.setOnClickListener {
            try {
                var mp = MediaPlayer.create( this, R.raw.bs)
                mp.start()
            }
            catch (e: Exception) {
                println(e)
            }
            if(operacion == "+"){
                total++
                bs++
            }
            else{
                if (total>0 && bs > 0){
                    total--
                    bs--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = total.toString()

            calculaTotales()
        }

        mcBtn.setOnClickListener {
            try {
                var mp = MediaPlayer.create( this, R.raw.mc)
                mp.start()

            }
            catch (e: Exception) {
                println(e)
            }
            if(operacion == "+"){
                total++
                mc++
            }
            else{
                if (total>0 && mc > 0){
                    total--
                    mc--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = total.toString()
            calculaTotales()
        }

        jvBtn.setOnClickListener{
            try {
                var mp = MediaPlayer.create( this, R.raw.jv)
                mp.start()
            }
            catch (e: Exception) {
                println(e)
            }

            if(operacion == "+"){
                total++
                jv++
            }
            else{
                if (total>0 && jv > 0){
                    total--
                    jv--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = total.toString()
            calculaTotales()
        }

        ebBtn.setOnClickListener {
            try {
                var mp = MediaPlayer.create( this, R.raw.eb)
                mp.start()
            }
            catch (e: Exception) {
                println(e)
            }

            if(operacion == "+"){
                total++
                eb++
            }
            else{
                if (total>0 && eb > 0){
                    total--
                    eb--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = total.toString()
            calculaTotales()
        }

        sgBtn.setOnClickListener {
            try {
                var mp = MediaPlayer.create( this, R.raw.sg)
                mp.start()
            }
            catch (e: Exception) {
                println(e)
            }

            if(operacion == "+"){
                total++
                sg++
            }
            else{
                if (total>0 && sg > 0){
                    total--
                    sg--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = total.toString()
            calculaTotales()
        }

        lfBtn.setOnClickListener {
            try {
                var mp = MediaPlayer.create( this, R.raw.lf)
                mp.start()
            }
            catch (e: Exception) {
                println(e)
            }

            if(operacion == "+"){
                total++
                lf++
            }
            else{
                if (total>0 && lf > 0){
                    total--
                    lf--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = total.toString()
            calculaTotales()
        }

        mnBtn.setOnClickListener {
            try {
                var mp = MediaPlayer.create( this, R.raw.mn)
                mp.start()
            }
            catch (e: Exception) {
                println(e)
            }

            if(operacion == "+"){
                total++
                mn++
            }
            else{
                if (total>0 && mn > 0){
                    total--
                    mn--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = total.toString()
            calculaTotales()
        }
    }

    fun calculaTotales(){


        if (total >0){
            val totalEo =  eo*100/total
            eoTxt.text = "$eo [$totalEo %]"

            val totalBs = bs*100/total
            bsTxt.text = "$bs [$totalBs %]"

            val totalMc = mc*100/total
            mcTxt.text = "$mc [$totalMc %]"

            val totalJv = jv*100/total
            jvTxt.text = "$jv [$totalJv %]"

            val totalEb = eb*100/total
            ebTxt.text = "$eb [$totalEb %]"

            val totalSg = sg*100/total
            sgTxt.text = "$sg [$totalSg %]"

            val totalLf = lf*100/total
            lfTxt.text = "$lf [$totalLf %]"

            val totalMn = mn*100/total
            mnTxt.text = "$mn [$totalMn %]"
        }

        if (total == 100)
        {

        }

    }
}
