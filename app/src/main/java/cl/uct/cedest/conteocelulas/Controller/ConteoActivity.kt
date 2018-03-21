package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cl.uct.cedest.conteocelulas.Model.Conteo
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.EXTRA_CONTEO
import cl.uct.cedest.conteocelulas.Utilities.TOTAL_CUENTA
import kotlinx.android.synthetic.main.activity_conteo.*


class ConteoActivity : BaseActivity() {

    var operacion ="+"


    var conteo = Conteo(0,0,0,0,0,0,0
            ,0,0,0,0,0,0,0
            ,0,0,0,0,0,0
            ,0,0,0)


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_CONTEO, conteo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conteo)

        mieloTable.visibility =  View.INVISIBLE
        promTable.visibility = View.INVISIBLE
        prolinTable.visibility = View.INVISIBLE
        linfoTable.visibility = View.INVISIBLE
        linfoReacTable.visibility = View.INVISIBLE
        monoTable.visibility = View.INVISIBLE
        promoTable.visibility = View.INVISIBLE
        MicroMegaCarioBLTable.visibility = View.INVISIBLE
        McarioblastoTable.visibility = View.INVISIBLE
        McariocitoTable.visibility = View.INVISIBLE
        MiMcariocitoTable.visibility = View.INVISIBLE
        eritoBasofiloTable.visibility = View.INVISIBLE
        eritoBLPoliCrTable.visibility = View.INVISIBLE
        eritoBlOrtoTable.visibility = View.INVISIBLE

        calculaTotales()


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

           playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.eosinofilo++
            }
            else{
                if (conteo.total>0 && conteo.eosinofilo > 0){
                    conteo.total--
                    conteo.eosinofilo--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()

        }

        bsBtn.setOnClickListener {
            playSound(R.raw.bs)
            if(operacion == "+"){
                conteo.total++
                conteo.basofilo++
            }
            else{
                if (conteo.total>0 && conteo.basofilo > 0){
                    conteo.total--
                    conteo.basofilo--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()

            calculaTotales()
        }

        mcBtn.setOnClickListener {
            playSound(R.raw.mc)
            if(operacion == "+"){
                conteo.total++
                conteo.mielocitos++
            }
            else{
                if (conteo.total>0 && conteo.mielocitos > 0){
                    conteo.total--
                    conteo.mielocitos--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        jvBtn.setOnClickListener{
            playSound(R.raw.jv)

            if(operacion == "+"){
                conteo.total++
                conteo.juveniles++
            }
            else{
                if (conteo.total>0 && conteo.juveniles > 0){
                    conteo.total--
                    conteo.juveniles--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        ebBtn.setOnClickListener {
            playSound(R.raw.eb)

            if(operacion == "+"){
                conteo.total++
                conteo.baciliforme++
            }
            else{
                if (conteo.total>0 && conteo.baciliforme > 0){
                    conteo.total--
                    conteo.baciliforme--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        sgBtn.setOnClickListener {
            playSound(R.raw.sg)

            if(operacion == "+"){
                conteo.total++
                conteo.segmentados++
            }
            else{
                if (conteo.total>0 && conteo.segmentados > 0){
                    conteo.total--
                    conteo.segmentados--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        lfBtn.setOnClickListener {
            playSound(R.raw.lf)

            if(operacion == "+"){
                conteo.total++
                conteo.linfocitos++
            }
            else{
                if (conteo.total>0 && conteo.linfocitos > 0){
                    conteo.total--
                    conteo.linfocitos--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        mnBtn.setOnClickListener {
           playSound(R.raw.mn)

            if(operacion == "+"){
                conteo.total++
                conteo.monocito++
            }
            else{
                if (conteo.total>0 && conteo.monocito > 0){
                    conteo.total--
                    conteo.monocito--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        promBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.promielocito++
            }
            else{
                if (conteo.total>0 && conteo.promielocito > 0){
                    conteo.total--
                    conteo.promielocito--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        mieloBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.mieloblasto++
            }
            else{
                if (conteo.total>0 && conteo.mieloblasto > 0){
                    conteo.total--
                    conteo.mieloblasto--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        linfoBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.linfoblastos++
            }
            else{
                if (conteo.total>0 && conteo.linfoblastos > 0){
                    conteo.total--
                    conteo.linfoblastos--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        linfoReacBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.linfocitoReactivo++
            }
            else{
                if (conteo.total>0 && conteo.linfocitoReactivo > 0){
                    conteo.total--
                    conteo.linfocitoReactivo--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        prolinBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.prolinfocito++
            }
            else{
                if (conteo.total>0 && conteo.prolinfocito > 0){
                    conteo.total--
                    conteo.prolinfocito--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        monoBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.monoblasto++
            }
            else{
                if (conteo.total>0 && conteo.monoblasto > 0){
                    conteo.total--
                    conteo.monoblasto--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        promoBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.promonocito++
            }
            else{
                if (conteo.total>0 && conteo.promonocito > 0){
                    conteo.total--
                    conteo.promonocito--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        megacarioblastoBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.megacarioblasto++
            }
            else{
                if (conteo.total>0 && conteo.megacarioblasto > 0){
                    conteo.total--
                    conteo.megacarioblasto--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        megacariocitoBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.megacariocito++
            }
            else{
                if (conteo.total>0 && conteo.megacariocito > 0){
                    conteo.total--
                    conteo.megacariocito--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        micromegacariocitoBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.micromegacariocito++
            }
            else{
                if (conteo.total>0 && conteo.micromegacariocito > 0){
                    conteo.total--
                    conteo.micromegacariocito--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        microMegaCarioBlBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.micromegacarioblasto++
            }
            else{
                if (conteo.total>0 && conteo.micromegacarioblasto > 0){
                    conteo.total--
                    conteo.micromegacarioblasto--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        eritoBasofiloBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.eritoblastoBasofilo++
            }
            else{
                if (conteo.total>0 && conteo.eritoblastoBasofilo > 0){
                    conteo.total--
                    conteo.eritoblastoBasofilo--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        eritoBlOrtoBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.eritoblastoOrtocromatico++
            }
            else{
                if (conteo.total>0 && conteo.eritoblastoOrtocromatico > 0){
                    conteo.total--
                    conteo.eritoblastoOrtocromatico--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        eritoBlPoliCrBtn.setOnClickListener {
            playSound(R.raw.eo)

            if(operacion == "+"){
                conteo.total++
                conteo.eritoblastoPolicromatico++
            }
            else{
                if (conteo.total>0 && conteo.eritoblastoPolicromatico > 0){
                    conteo.total--
                    conteo.eritoblastoPolicromatico--
                    operacion="+"
                    plusMinusBtn.text=operacion
                }
            }
            totalConteoTxt.text = conteo.total.toString()
            calculaTotales()
        }

        resultadoBtn.setOnClickListener {
            if(conteo.total == 10 ){
                val caracte = Intent(this, CaracteristicaMain::class.java)
                caracte.putExtra(EXTRA_CONTEO, conteo)
                startActivity(caracte)
            }
        }


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            conteo = savedInstanceState.getParcelable(EXTRA_CONTEO)
            calculaTotales()
        }
    }

    private fun calculaTotales(){

        totalConteoTxt.text = conteo.total.toString()

        if (conteo.total >0){

            val totalEo =  conteo.eosinofilo*100/conteo.total
            eoTxt.text = "${conteo.eosinofilo} [$totalEo %]"

            val totalBs = conteo.basofilo*100/conteo.total
            bsTxt.text = "${conteo.basofilo} [$totalBs %]"

            val totalMc = conteo.mielocitos*100/conteo.total
            mcTxt.text = "${conteo.mielocitos} [$totalMc %]"

            val totalJv = conteo.juveniles*100/conteo.total
            jvTxt.text = "${conteo.juveniles} [$totalJv %]"

            val totalEb = conteo.baciliforme*100/conteo.total
            ebTxt.text = "${conteo.baciliforme} [$totalEb %]"

            val totalSg = conteo.segmentados*100/conteo.total
            sgTxt.text = "${conteo.segmentados} [$totalSg %]"

            val totalLf = conteo.linfocitos*100/conteo.total
            lfTxt.text = "${conteo.linfocitos} [$totalLf %]"

            val totalMn = conteo.monocito*100/conteo.total
            mnTxt.text = "${conteo.monocito} [$totalMn %]"

            var total = conteo.promielocito*100/conteo.total
            promTxt.text = "${conteo.promielocito} [$total %]"

            total = conteo.mieloblasto*100/conteo.total
            mieloTxt.text = "${conteo.mieloblasto} [$total %]"

            total = conteo.linfoblastos*100/conteo.total
            linfoTxt.text = "${conteo.linfoblastos} [$total %]"

            total = conteo.linfocitoReactivo*100/conteo.total
            linfoReacTxt.text = "${conteo.linfocitoReactivo} [$total %]"

            total = conteo.prolinfocito*100/conteo.total
            prolinTxt.text = "${conteo.prolinfocito} [$total %]"

            total = conteo.monoblasto*100/conteo.total
            monoTxt.text = "${conteo.monoblasto} [$total %]"

            total = conteo.promonocito*100/conteo.total
            promoTxt.text = "${conteo.promonocito} [$total %]"

            total = conteo.megacarioblasto*100/conteo.total
            megacarioblastoTxt.text = "${conteo.megacarioblasto} [$total %]"

            total = conteo.megacariocito*100/conteo.total
            megacariocitoTxt.text = "${conteo.megacariocito} [$total %]"

            total = conteo.micromegacariocito*100/conteo.total
            micrimegacariocitoTxt.text = "${conteo.micromegacariocito} [$total %]"

            total = conteo.micromegacarioblasto*100/conteo.total
            microMegaCarioBlastoTxt.text = "${conteo.micromegacarioblasto} [$total %]"

            total = conteo.eritoblastoBasofilo*100/conteo.total
            eritoBasofiloTxt.text = "${conteo.eritoblastoBasofilo} [$total %]"

            total = conteo.eritoblastoOrtocromatico*100/conteo.total
            eritoOrtoCromaTxt.text = "${conteo.eritoblastoOrtocromatico} [$total %]"

            total = conteo.eritoblastoPolicromatico*100/conteo.total
            eritoPoliCroTxt.text = "${conteo.eritoblastoPolicromatico} [$total %]"
        }

        if(conteo.total <= 0)
        {
            eoTxt.text = "${conteo.eosinofilo} [0 %]"

            bsTxt.text = "${conteo.basofilo} [0 %]"

            mcTxt.text = "${conteo.mielocitos} [0 %]"

            jvTxt.text = "${conteo.juveniles} [0 %]"

            ebTxt.text = "${conteo.baciliforme} [0 %]"

            sgTxt.text = "${conteo.segmentados} [0 %]"

            lfTxt.text = "${conteo.linfocitos} [0 %]"

            mnTxt.text = "${conteo.monocito} [0 %]"

            promTxt.text = "${conteo.promielocito} [0 %]"

            mieloTxt.text = "${conteo.mieloblasto} [0 %]"

            linfoTxt.text = "${conteo.linfoblastos} [0 %]"

            linfoReacTxt.text = "${conteo.linfocitoReactivo} [0 %]"

            prolinTxt.text = "${conteo.prolinfocito} [0 %]"

            monoTxt.text = "${conteo.monoblasto} [0 %]"

            promoTxt.text = "${conteo.promonocito} [0 %]"

            megacarioblastoTxt.text = "${conteo.megacarioblasto} [0 %]"

            megacariocitoTxt.text = "${conteo.megacariocito} [0 %]"

            micrimegacariocitoTxt.text = "${conteo.micromegacariocito} [0 %]"

            microMegaCarioBlastoTxt.text = "${conteo.micromegacarioblasto} [0 %]"

            eritoBasofiloTxt.text = "${conteo.eritoblastoBasofilo} [0 %]"

            eritoOrtoCromaTxt.text = "${conteo.eritoblastoOrtocromatico} [0 %]"

            eritoPoliCroTxt.text = "${conteo.eritoblastoPolicromatico} [0 %]"
        }

        if (conteo.total == TOTAL_CUENTA)
        {
            val msj = Toast.makeText(this,"FIN CONTEO!!", Toast.LENGTH_SHORT)
            msj.show()
        }

    }

    fun mostrarMielo(view: View) {

        if (MieloideChck.isChecked){
            mieloTable.visibility = View.VISIBLE
            promTable.visibility = View.VISIBLE
        }
        else{
            mieloTable.visibility = View.INVISIBLE
            promTable.visibility = View.INVISIBLE

            conteo.total = conteo.total - conteo.mieloblasto - conteo.promielocito
            conteo.mieloblasto = 0
            conteo.promielocito = 0
            calculaTotales()
        }

    }

    fun mostrarLinfo(view: View){
        if(linfoideChck.isChecked){
            prolinTable.visibility = View.VISIBLE
            linfoTable.visibility = View.VISIBLE
            linfoReacTable.visibility = View.VISIBLE


            conteo.prolinfocito = 0
            conteo.linfoblastos = 0
            conteo.linfocitoReactivo = 0
            calculaTotales()
        }
        else{
            prolinTable.visibility = View.INVISIBLE
            linfoTable.visibility = View.INVISIBLE
            linfoReacTable.visibility = View.INVISIBLE

            conteo.total = conteo.total - conteo.prolinfocito - conteo.linfoblastos - conteo.linfocitoReactivo
            conteo.prolinfocito = 0
            conteo.linfoblastos = 0
            conteo.linfocitoReactivo = 0

            calculaTotales()
        }
    }

    fun mostrarMonocitica(view: View){
        if(moniciticaChck.isChecked){
            monoTable.visibility = View.VISIBLE
            promoTable.visibility = View.VISIBLE

            conteo.promonocito = 0
            conteo.monoblasto = 0

            calculaTotales()
        }
        else{
            monoTable.visibility = View.INVISIBLE
            promoTable.visibility = View.INVISIBLE

            conteo.total = conteo.total - conteo.promonocito - conteo.monoblasto
            conteo.promonocito = 0
            conteo.monoblasto = 0

            calculaTotales()
        }
    }

    fun mostrarMegacario(view: View){
        if(megatocriticaChck.isChecked){
            MicroMegaCarioBLTable.visibility = View.VISIBLE
            McarioblastoTable.visibility = View.VISIBLE
            McariocitoTable.visibility = View.VISIBLE
            MiMcariocitoTable.visibility = View.VISIBLE

            conteo.megacarioblasto = 0
            conteo.megacariocito = 0
            conteo.micromegacarioblasto = 0
            conteo.micromegacariocito = 0

            calculaTotales()
        }
        else{
            MicroMegaCarioBLTable.visibility = View.INVISIBLE
            McarioblastoTable.visibility = View.INVISIBLE
            McariocitoTable.visibility = View.INVISIBLE
            MiMcariocitoTable.visibility = View.INVISIBLE

            conteo.total = conteo.total - conteo.micromegacarioblasto - conteo.micromegacariocito - conteo.megacariocito - conteo.megacarioblasto

            conteo.megacarioblasto = 0
            conteo.megacariocito = 0
            conteo.micromegacarioblasto = 0
            conteo.micromegacariocito = 0

            calculaTotales()
        }
    }

    fun mostrarEritroide(view: View){
        if(eritroideChck.isChecked){
            eritoBasofiloTable.visibility = View.VISIBLE
            eritoBLPoliCrTable.visibility = View.VISIBLE
            eritoBlOrtoTable.visibility = View.VISIBLE

            conteo.eritoblastoBasofilo = 0
            conteo.eritoblastoOrtocromatico = 0
            conteo.eritoblastoPolicromatico = 0

            calculaTotales()
        }
        else{
            eritoBasofiloTable.visibility = View.INVISIBLE
            eritoBLPoliCrTable.visibility = View.INVISIBLE
            eritoBlOrtoTable.visibility = View.INVISIBLE


            conteo.total = conteo.total - conteo.eritoblastoPolicromatico - conteo.eritoblastoOrtocromatico - conteo.eritoblastoBasofilo

            conteo.eritoblastoBasofilo = 0
            conteo.eritoblastoOrtocromatico = 0
            conteo.eritoblastoPolicromatico = 0

            calculaTotales()
        }
    }


    private fun playSound(soundID: Int) {
        val mp = MediaPlayer.create(this, soundID)
        mp.start()
        mp.setOnCompletionListener { mp.release() }


    }


}
